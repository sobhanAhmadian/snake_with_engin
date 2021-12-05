import gameLibrary.gameEngine.level.LevelHandler;
import gameLibrary.gameUI.GameFrame;
import gameLibrary.gameUI.GameHome;
import snake.SnakeGame;
import snake.SnakeLevel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        loadLevels();
        GameHome gameHome = new GameHome("/res/background.jpg",
                "/res/run.png",
                "/res/run_clicked.png",
                1000, 575);
        SnakeGame game = new SnakeGame(1000, 575);
        GameFrame frame = new GameFrame(1000, 600, game, gameHome);
    }

    private static void loadLevels() {
        List<SnakeLevel> levels = new ArrayList<>();
        levels.add(new SnakeLevel(1, 4));
        levels.add(new SnakeLevel(2, 4));
        levels.add(new SnakeLevel(3, 3));
        levels.add(new SnakeLevel(4, 3));
        LevelHandler.<SnakeLevel>getLevelHandler().addAllLevels(levels);
    }
}
