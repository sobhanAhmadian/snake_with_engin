package gameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Game extends JPanel {

    private static final long DELAY = 20;
    private final List<GameObject> gameObjects;
    private GameListener gameListener;
    private boolean gameWin;
    private boolean gameOver;
    private boolean gameStop;

    public Game() {
        setVisible(true);
        setSize(1000, 600);
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseHandler());
        addComponentListener(new ComponentHandler());
        setFocusable(true);
        requestFocusInWindow();
        gameObjects = new ArrayList<>();
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

            if (gameStop) continue;

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

    protected abstract void showGameOverDialog();

    protected abstract void showGameWinDialog();

    private void clearCache() {

    }

    private void saveGame() {
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        repaint();
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyTyped(e);

            if (gameListener == null) return;

            if (e.getKeyCode() == KeyEvent.VK_SPACE) gameListener.onSpaceButtonClicked();
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) gameListener.onRightButtonClicked();
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) gameListener.onLeftButtonClicked();
            else if (e.getKeyCode() == KeyEvent.VK_UP) gameListener.onUpButtonClicked();
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) gameListener.onDownButtonClicked();
        }
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            if (gameListener == null) return;

            if (e.getButton() == MouseEvent.BUTTON1)
                gameListener.onLeftMouseButtonClicked(e.getX(), e.getY());
            else if (e.getButton() == MouseEvent.BUTTON3)
                gameListener.onRightMouseButtonClicked(e.getX(), e.getY());
        }
    }

    private class ComponentHandler implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) {
            requestFocus();
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            requestFocus();
        }

        @Override
        public void componentShown(ComponentEvent e) {
            requestFocus();
        }

        @Override
        public void componentHidden(ComponentEvent e) {

        }
    }


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

    // setter and getter functions

    public void setGameWin(boolean gameWin) {
        this.gameWin = gameWin;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameStop() {
        return gameStop;
    }

    public void setGameStop(boolean gameStop) {
        this.gameStop = gameStop;
    }

    public void setGameListener(GameListener gameListener) {
        this.gameListener = gameListener;
    }
}
