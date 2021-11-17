package snake;

import gameEngine.GameEngine;

import java.awt.*;

public class SnakeGame extends GameEngine {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private Snake snake;
    private SeedGenerator seedGenerator;
    private boolean gameStop;
    private boolean gameWin;
    private boolean gameOver;

    public SnakeGame(int width, int height) {
        super(width, height,
                Color.getColor("#212121"),
                "/res/game_over_audio.wav",
                "/res/game_win_audio.wav",
                "/res/game_audio.wav");
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

    @Override
    protected void initialGame() {
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
        gameOver = false;
        gameWin = false;
        gameStop = false;
    }
}
