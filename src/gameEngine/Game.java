package gameEngine;

import gameUI.dialogue.GameOverDialog;
import gameUI.dialogue.GameWinDialog;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Game extends JPanel {

    private static final long DELAY = 5;
    private final List<GameObject> gameObjects;
    private GameListener gameListener;
    private int width;
    private int height;
    private final Color backgroundColor;
    private Clip clip_for_gameOver;
    private Clip clip_for_gameWin;
    private Clip clip_for_gaming;

    public Game(int width, int height, Color backgroundColor) {

        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;

        setVisible(true);
        setSize(width, height);
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseHandler());
        addComponentListener(new ComponentHandler());
        gameObjects = new ArrayList<>();
        setFocusable(true);
        requestFocus();
    }

    public void start() {
        (new Thread(this::play)).start();
    }

    public void play() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            if (isGameWin()) {

                showGameWinDialog();
                clearCache();
                break;
            } else if (isGameOver()) {

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

            if (isGameStop()) continue;

            for (GameObject gameObject :
                    gameObjects) {
                gameObject.update();
            }
            updateGame();

            saveGame();
        }
    }

    protected abstract void updateGame();

    protected abstract boolean isGameWin();

    protected abstract boolean isGameOver();

    protected abstract boolean isGameStop();

    protected abstract void showGameOverDialog(int a);

    protected abstract void showGameWinDialog(int a);

    private void showGameWinDialog() {

        repaint();
/*
        clip_for_gaming.stop();
        clip_for_gameWin.start();
*/

        new GameWinDialog(
                this,
                actionEvent -> System.out.println("home"), // TODO: 11/15/21  
                actionEvent -> System.out.println("next level") // TODO: 11/15/21  
        );
    }

    private void showGameOverDialog() {

        repaint();
//        clip_for_gaming.stop();
//        clip_for_gameOver.start();

        new GameOverDialog(
                this,
                actionEvent -> repeatGame()
        );
    }

    private void repeatGame() {

        // TODO: 11/15/21  
//        clip_for_gaming.close();
//        clip_for_gameWin.close();
//        clip_for_gameOver.close();
    }

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
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (GameObject gameObject :
                gameObjects) {
            gameObject.pain(graphics2D);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    // setter and getter functions

    public void setGameListener(GameListener gameListener) {
        this.gameListener = gameListener;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
