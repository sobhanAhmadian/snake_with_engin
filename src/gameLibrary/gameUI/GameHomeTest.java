package gameLibrary.gameUI;

import org.junit.jupiter.api.Test;
import snake.SnakeGame;

class GameHomeTest {

    @Test
    public void test() {
        GameHome gameHome = new GameHome("/res/background.jpg", 1000, 575);
        SnakeGame game = new SnakeGame(1000, 575);
        GameFrame frame = new GameFrame(1000, 600, game, gameHome);
        while (true) ;
    }

}