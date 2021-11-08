package snake;

import gameObjects.Seed;
import other.Pair;

import java.util.List;
import java.util.Random;

public class SeedGenerator {

    public static final int SEED_SIZE = 50;
    private Seed seed;
    private SeedAdder seedAdder;
    private PositionChecker positionChecker;
    private Random random;
    private int boardWidth;
    private int boardHeight;

    public SeedGenerator(SeedAdder seedAdder, PositionChecker positionChecker, int boardWidth, int boardHeight) {
        this.seedAdder = seedAdder;
        this.positionChecker = positionChecker;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        random = new Random();

        seed = new Seed();
        seed.setX(100);
        seed.setY(100);
        seed.setWidth(SEED_SIZE);
        seed.setHeight(SEED_SIZE);
        this.seedAdder.addSeed(seed);
    }

    public boolean checkSeedCollision(int x, int y) {
        return y > seed.getY() - SnakeGame.BEAD_SIZE &&
                y < seed.getY() + SEED_SIZE &&
                x > seed.getX() - SnakeGame.BEAD_SIZE &&
                x < seed.getX() + SEED_SIZE;
    }

    public void changeSeedPosition() {
        int x = random.nextInt(boardWidth - SEED_SIZE);
        int y = random.nextInt(boardHeight - SEED_SIZE);

        for (Pair<Integer, Integer> position :
                positionChecker.positions()) {
            if (x < position.getF() + SnakeGame.BEAD_SIZE && x > position.getF())
                if (y < position.getS() + SnakeGame.BEAD_SIZE && y > position.getS())
                    changeSeedPosition();
        }

        seed.setX(x);
        seed.setY(y);
    }

    interface PositionChecker {
        List<Pair<Integer, Integer>> positions();
    }

    interface SeedAdder {
        void addSeed(Seed seed);
    }

}
