import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public Game() {
        setVisible(true);
        setSize(1000, 600);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.black);
        g.fillRect(1, 1, 100, 100);
    }
}
