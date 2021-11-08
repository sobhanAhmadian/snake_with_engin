package snake;

import gameEngine.Game;

import java.awt.*;

public class SnakeGame extends Game {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private Snake snake;
    private SeedGenerator seedGenerator;

    public SnakeGame(int width, int height) {
        super(width, height, Color.getColor("#212121"));
        snake = new Snake(this::addGameObject);
        seedGenerator = new SeedGenerator(this::addGameObject, () -> snake.beadPositions(), getWidth(), getHeight());
        setGameListener(new SnakeGameListener(snake, new SnakeGameListener.Stopper() {
            @Override
            public void stop(boolean b) {
                setGameStop(b);
            }

            @Override
            public boolean isStop() {
                return isGameStop();
            }
        }));
    }

    @Override
    protected void updateGame() {
        if (seedGenerator.checkSeedCollision(snake.getHead().getX(), snake.getHead().getY())) {
            seedGenerator.changeSeedPosition();
            snake.addBead();
        }
    }

    @Override
    protected boolean isGameWin() {
        return false;
    }

    @Override
    protected boolean isGameOver() {
        return false;
    }

    @Override
    protected void showGameOverDialog() {

    }

    @Override
    protected void showGameWinDialog() {

    }
}
