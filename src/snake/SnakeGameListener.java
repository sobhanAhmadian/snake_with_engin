package snake;

import gameLibrary.gameEngine.GameListener;
import gameObjects.Bead;

public class SnakeGameListener implements GameListener {

    private Snake snake;
    private Stopper stopper;

    public SnakeGameListener(Snake snake, Stopper stopper) {
        this.snake = snake;
        this.stopper = stopper;
    }

    @Override
    public void onUpButtonClicked() {
        if (checkForNeckBreak(Bead.Direction.UP)) return;
        if (snake.getHead().getDirection() == Bead.Direction.DOWN) return;
        snake.getHead().setAngle(0);
        snake.getHead().setDirection(Bead.Direction.UP);
    }

    @Override
    public void onDownButtonClicked() {
        if (checkForNeckBreak(Bead.Direction.DOWN)) return;
        if (snake.getHead().getDirection() == Bead.Direction.UP) return;
        snake.getHead().setAngle(2);
        snake.getHead().setDirection(Bead.Direction.DOWN);
    }

    @Override
    public void onRightButtonClicked() {
        if (checkForNeckBreak(Bead.Direction.RIGHT)) return;
        if (snake.getHead().getDirection() == Bead.Direction.LEFT) return;
        snake.getHead().setAngle(1);
        snake.getHead().setDirection(Bead.Direction.RIGHT);
    }

    @Override
    public void onLeftButtonClicked() {
        if (checkForNeckBreak(Bead.Direction.LEFT)) return;
        if (snake.getHead().getDirection() == Bead.Direction.RIGHT) return;
        snake.getHead().setAngle(3);
        snake.getHead().setDirection(Bead.Direction.LEFT);
    }

    @Override
    public void onSpaceButtonClicked() {
        stopper.stop(!stopper.isStop());
    }

    @Override
    public void onRightMouseButtonClicked(int x, int y) {

    }

    @Override
    public void onLeftMouseButtonClicked(int x, int y) {

    }

    private boolean checkForNeckBreak(Bead.Direction direction) {
        Bead neck = snake.getNeck();
        Bead head = snake.getHead();
        if (neck == null) return false;
        switch (direction) {
            case UP:
            case DOWN:
                if (head.getX() > neck.getX() - neck.getHeight() &&
                        head.getX() < neck.getX() + neck.getWidth())
                    return true;
                break;
            case RIGHT:
            case LEFT:
                if (head.getY() > neck.getY() - neck.getHeight() &&
                        head.getY() < neck.getY() + neck.getHeight())
                    return true;
                break;
        }
        return false;
    }

    public interface Stopper {
        void stop(boolean b);

        boolean isStop();
    }
}
