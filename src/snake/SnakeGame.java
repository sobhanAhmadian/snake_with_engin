package snake;

import gameEngine.Game;

import java.awt.*;

public class SnakeGame extends Game {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private final Snake snake;
    private final SeedGenerator seedGenerator;
    private boolean gameStop;
    private boolean gameWin;
    private boolean gameOver;

    public SnakeGame(int width, int height) {
        super(width, height,
                Color.getColor("#212121"),
                "/res/game_over_audio.wav",
                "/res/game_win_audio.wav",
                "/res/game_audio.wav");
        snake = new Snake(this::addGameObject);
        seedGenerator = new SeedGenerator(this::addGameObject, snake::beadPositions, getWidth(), getHeight());
        setGameListener(new SnakeGameListener(snake, new SnakeGameListener.Stopper() {
            @Override
            public void stop(boolean b) {
                gameStop = b;
            }

            @Override
            public boolean isStop() {
                return isGameStop();
            }
        }));
    }

    @Override
    protected void updateGame() {

        if (snake.hasHeadCollisionWithBody())
            gameOver = true;

        if (seedGenerator.checkSeedCollision(snake.getHead().getX(), snake.getHead().getY())) {
            seedGenerator.changeSeedPosition();
            snake.addBead();
        }
    }

    @Override
    protected boolean isGameWin() {
        return gameWin;
    }

    @Override
    protected boolean isGameOver() {
        return gameOver;
    }

    @Override
    protected boolean isGameStop() {
        return gameStop;
    }
}
