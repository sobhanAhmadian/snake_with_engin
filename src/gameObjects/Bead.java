package gameObjects;

import gameEngine.AutoMoverSprite;
import snake.Snake;
import snake.SnakeGame;

public class Bead extends AutoMoverSprite {

    public enum Type {HEAD, BODY}

    public enum Direction {UP, DOWN, LEFT, RIGHT}

    private Type type;
    private Bead parentBead;
    private Direction direction;

    public Bead(String imagePath, Type type, Bead parentBead) {
        super(imagePath);
        this.type = type;
        this.parentBead = parentBead;
        setHeight(SnakeGame.BEAD_SIZE);
        setWidth(SnakeGame.BEAD_SIZE);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        switch (direction) {
            case UP:
                setyStep(-1 * Snake.speed);
                setxStep(0);
                break;
            case DOWN:
                setyStep(Snake.speed);
                setxStep(0);
                break;
            case LEFT:
                setxStep(-1 * Snake.speed);
                setyStep(0);
                break;
            case RIGHT:
                setxStep(Snake.speed);
                setyStep(0);
                break;
        }
    }

    @Override
    public void update() {
        super.update();
        if (parentBead != null) {
            if (getDirection() == Direction.RIGHT || getDirection() == Direction.LEFT)
                if (getX() == parentBead.getX())
                    if (parentBead.getY() < getY()) setDirection(Direction.UP);
                    else setDirection(Direction.DOWN);
            if (getDirection() == Direction.UP || getDirection() == Direction.DOWN)
                if (getY() == parentBead.getY())
                    if (parentBead.getX() < getX()) setDirection(Direction.LEFT);
                    else setDirection(Direction.RIGHT);
        }

    }
}
