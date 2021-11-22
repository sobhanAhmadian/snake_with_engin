package gameUI;

import org.junit.jupiter.api.Test;
import snake.SnakeGame;

import java.awt.*;

class GameHomeTest {

    @Test
    public void test() {
        GameHome gameHome = new GameHome("/res/snake_back.jpg", 1000, 570);
        SnakeGame game = new SnakeGame(1000, 600);
        GameFrame frame = new GameFrame(1000, 600, Color.gray, game, gameHome);
        while (true) ;
    }

}