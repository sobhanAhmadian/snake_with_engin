import gameEngine.Game;
import gameObjects.Bead;

public class SnakeGame extends Game {

    public SnakeGame() {
        Bead bead = new Bead();
        bead.setX(100);
        bead.setY(100);
        bead.setWidth(50);
        bead.setHeight(50);
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
