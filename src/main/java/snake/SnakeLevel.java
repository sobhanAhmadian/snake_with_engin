package snake;


import gameEngine.level.Level;

public class SnakeLevel extends Level {

    private int totalSeeds;
    private long delay;

    public SnakeLevel(int totalSeeds, long delay) {
        this.totalSeeds = totalSeeds;
        this.delay = delay;
    }

    public int getTotalSeeds() {
        return totalSeeds;
    }

    public long getDelay() {
        return delay;
    }
}
