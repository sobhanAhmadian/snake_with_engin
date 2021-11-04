package snake;

import gameObjects.Bead;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Bead> beads;

    public Snake() {
        beads = new ArrayList<>();

        Bead head = new Bead("/res/head.png", Bead.Type.HEAD);
        head.setX(SnakeGame.START_X);
        head.setY(SnakeGame.START_Y);
        head.setDirection(Bead.Direction.UP);
        beads.add(head);
    }

    public void addBead() {
        Bead bead = new Bead("/res/bead.png", Bead.Type.BODY);

        Bead parentBead = getEndBead();
        bead.setDirection(parentBead.getDirection());
        switch (parentBead.getDirection()) {
            case UP:
                bead.setX(parentBead.getX());
                bead.setY(parentBead.getY() + SnakeGame.BEAD_SIZE);
                break;
            case DOWN:
                bead.setX(parentBead.getX());
                bead.setY(parentBead.getY() - SnakeGame.BEAD_SIZE);
                break;
            case LEFT:
                bead.setX(parentBead.getX() + SnakeGame.BEAD_SIZE);
                bead.setY(parentBead.getY());
                break;
            case RIGHT:
                bead.setX(parentBead.getX() - SnakeGame.BEAD_SIZE);
                bead.setY(parentBead.getY());
                break;
        }
        beads.add(bead);
    }

    private Bead getEndBead() {
        return beads.get(beads.size() - 1);
    }
}
