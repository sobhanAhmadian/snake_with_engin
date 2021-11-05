package snake;

import gameObjects.Bead;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static int speed = 1;
    private List<Bead> beads;
    private SnakeGame.Callback callback;

    public Snake(SnakeGame.Callback callback) {
        this.callback = callback;
        beads = new ArrayList<>();

        Bead head = new Bead("/res/head.png", Bead.Type.HEAD);
        head.setX(SnakeGame.START_X);
        head.setY(SnakeGame.START_Y);
        head.setDirection(Bead.Direction.UP);
        beads.add(head);
        this.callback.addBead(head);
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
        callback.addBead(bead);
    }

    private Bead getEndBead() {
        return beads.get(beads.size() - 1);
    }

    public Bead getHead() {
        return beads.get(0);
    }
}
