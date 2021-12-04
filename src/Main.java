import gameLibrary.gameEngine.GameEngine;
import gameLibrary.gameUI.GameFrame;
import gameLibrary.gameUI.GameHome;
import snake.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameHome gameHome = new GameHome("/res/background.jpg", 1000, 575);
        SnakeGame game = new SnakeGame(1000, 575);
        GameFrame frame = new GameFrame(1000, 600, game, gameHome);
    }
}
