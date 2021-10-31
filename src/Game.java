import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel {

    private List<GameObject> gameObjects;

    public Game() {
        setVisible(true);
        setSize(1000, 600);
        gameObjects = new ArrayList<>();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (GameObject gameObject :
                gameObjects) {
            gameObject.pain(graphics2D);
        }
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        repaint();
    }
}
