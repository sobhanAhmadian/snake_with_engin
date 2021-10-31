import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Game game = new Game();
        Bead bead = new Bead("/res/bead.png");
        bead.setX(500);
        bead.setY(500);
        bead.setWidth(50);
        bead.setHeight(50);
        bead.setAngle(20);
        game.addGameObject(bead);
        frame.add(game, BorderLayout.CENTER);
        frame.invalidate();
        frame.repaint();
    }
}
