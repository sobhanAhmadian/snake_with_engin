package snake;

import gameObjects.Bead;
import other.Pair;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static int speed = 1;
    private List<Bead> beads;
    private Callback callback;

    public Snake(Callback callback) {
        this.callback = callback;
        beads = new ArrayList<>();

        Bead head = new Bead("/res/head.png", Bead.Type.HEAD);
        head.setX(SnakeGame.START_X + 10);
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

    public List<Pair<Integer, Integer>> beadPositions() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        //TODO
        return list;
    }

    interface Callback {
        void addBead(Bead bead);
    }
}
