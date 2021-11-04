package snake;

import gameEngine.Game;
import gameObjects.Bead;

public class SnakeGame extends Game {

    public static final int START_X = 500;
    public static final int START_Y = 300;
    public static final int BEAD_SIZE = 50;

    public static int speed = 1;

    public SnakeGame() {
        Bead bead = new Bead("/res/bead.png", Bead.Type.HEAD);
        bead.setX(100);
        bead.setY(100);
        bead.setWidth(50);
        bead.setHeight(50);
        bead.setxStep(1);
        bead.setyStep(1);
        addGameObject(bead);
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
