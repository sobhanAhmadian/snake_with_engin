package snake;

import gameEngine.GameListener;
import gameObjects.Bead;

public class SnakeGameListener implements GameListener {

    private Snake snake;

    public SnakeGameListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void onUpButtonClicked() {
        snake.getHead().setDirection(Bead.Direction.UP);
    }

    @Override
    public void onDownButtonClicked() {
        snake.getHead().setDirection(Bead.Direction.DOWN);
    }

    @Override
    public void onRightButtonClicked() {
        snake.getHead().setDirection(Bead.Direction.RIGHT);
    }

    @Override
    public void onLeftButtonClicked() {
        snake.getHead().setDirection(Bead.Direction.LEFT);
    }

    @Override
    public void onSpaceButtonClicked() {
    }

    @Override
    public void onRightMouseButtonClicked(int x, int y) {

    }

    @Override
    public void onLeftMouseButtonClicked(int x, int y) {

    }
}
