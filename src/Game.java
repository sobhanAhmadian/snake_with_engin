import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Game extends JPanel {

    private static final long DELAY = 20;
    private final List<GameObject> gameObjects;
    private boolean gameWin;
    private boolean gameOver;

    public Game() {
        setVisible(true);
        setSize(1000, 600);
        gameObjects = new ArrayList<>();

        Sprite bead = new Sprite("/res/bead.png") {
            @Override
            public void update() {
                this.setX(this.getX() + 3);
            }
        };

        bead.setX(1);
        bead.setY(500);
        bead.setWidth(50);
        bead.setHeight(50);
        bead.setAngle(20);
        addGameObject(bead);

        repaint();
    }

    public void start() {
        (new Thread(this::play)).start();
    }

    public void play() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            if (gameWin) {

                showGameWinDialog();
                clearCache();
                break;
            } else if (gameOver) {

                showGameOverDialog();
                clearCache();
                break;
            }

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beforeTime = System.currentTimeMillis();
            repaint();

            for (GameObject gameObject :
                    gameObjects) {
                gameObject.update();
            }

            gameOver = isGameOver();
            gameWin = isGameWin();
            saveGame();
        }
    }


    protected abstract boolean isGameWin();

    protected abstract boolean isGameOver();

    private void clearCache() {

    }

    private void saveGame() {
    }

    protected abstract void showGameOverDialog();

    protected abstract void showGameWinDialog();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (GameObject gameObject :
                gameObjects) {
            gameObject.pain(graphics2D);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        repaint();
    }
}
