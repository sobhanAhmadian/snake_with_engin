import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Game game = new Game() {
            @Override
            protected boolean isGameWin() {
                return false;
            }

            @Override
            protected boolean isGameOver() {
                return false;
            }

            @Override
            protected void showGameOverDialog() {

            }

            @Override
            protected void showGameWinDialog() {

            }
        };
        game.start();
        frame.add(game, BorderLayout.CENTER);
        frame.invalidate();
        frame.repaint();
    }
}
