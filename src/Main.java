import gameEngine.Game;
import snake.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Game game = new SnakeGame();
        game.start();
        frame.add(game, BorderLayout.CENTER);
        frame.invalidate();
        frame.repaint();
    }
}
