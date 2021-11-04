package gameObjects;

import gameEngine.AutoMoverSprite;
import snake.SnakeGame;

public class Bead extends AutoMoverSprite {

    public enum Type {HEAD, BODY}

    public enum Direction {UP, DOWN, LEFT, RIGHT}

    private Type type;

    private Direction direction;

    public Bead(String imagePath, Type type) {
        super(imagePath);
        this.type = type;
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
                setyStep(SnakeGame.speed);
                setxStep(0);
                break;
            case DOWN:
                setyStep(-1 * SnakeGame.speed);
                setxStep(0);
                break;
            case LEFT:
                setxStep(-1 * SnakeGame.speed);
                setyStep(0);
                break;
            case RIGHT:
                setxStep(SnakeGame.speed);
                setyStep(0);
                break;
        }
    }
}
