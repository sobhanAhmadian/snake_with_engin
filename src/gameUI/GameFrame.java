package gameUI;

import gameEngine.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Game game;
    private GameHome gameHome;

    public GameFrame(int width, int height, Color background,
                     Game game, GameHome gameHome) {
        this.game = game;
        this.gameHome = gameHome;
        setSize(width, height);
        getContentPane().setBackground(background);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(gameHome, BorderLayout.CENTER);

        setVisible(true);
    }


}
