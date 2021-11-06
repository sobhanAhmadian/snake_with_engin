package snake;

import gameEngine.Game;

public class SnakeGame extends Game {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private Snake snake;
    private SeedGenerator seedGenerator;

    public SnakeGame(int width, int height) {
        super(width, height);
        snake = new Snake(this::addGameObject);
        seedGenerator = new SeedGenerator(this::addGameObject, () -> snake.beadPositions(), getWidth(), getHeight());
        setGameListener(new SnakeGameListener(snake));
    }

    @Override
    protected void updateGame() {

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
