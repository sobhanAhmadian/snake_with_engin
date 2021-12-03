package snake;

import gameLibrary.gameEngine.GameEngine;
import gameLibrary.gameEngine.level.LevelHandler;

import java.awt.*;

public class SnakeGame extends GameEngine {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private Snake snake;
    private SeedGenerator seedGenerator;
    private boolean gameStop;
    private boolean gameOver;
    private final SnakeLevel snakeLevel;
    private int eatenSeeds;

    public SnakeGame(int width, int height) {
        super(width, height,
                new Color(33, 33, 33),
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

        snakeLevel = LevelHandler.<SnakeLevel>getLevelHandler().getCurrentLevel();
        setDelay(snakeLevel.getDelay());
    }

    @Override
    protected void updateGame() {

        if (snake.hasHeadCollisionWithBody())
            gameOver = true;

        if (seedGenerator.checkSeedCollision(snake.getHead().getX(), snake.getHead().getY())) {
            seedGenerator.changeSeedPosition();
            snake.addBead();
            eatenSeeds++;
        }
    }

    @Override
    protected boolean isGameWin() {
        return eatenSeeds == snakeLevel.getTotalSeeds();
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
        seedGenerator.initial();
        snake.initial();
        gameOver = false;
        gameStop = false;
    }

    @Override
    public void finish() {
        eatenSeeds = 0;
        clear();
        snake.clear();
    }
}
