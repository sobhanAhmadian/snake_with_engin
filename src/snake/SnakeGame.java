package snake;

import gameEngine.Game;
import gameObjects.Bead;

public class SnakeGame extends Game {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    private Snake snake;

    public SnakeGame() {
        snake = new Snake(this::addGameObject);
        setGameListener(new SnakeGameListener(snake));
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

    interface Callback {
        void addBead(Bead bead);
    }
}
