package gameLibrary.gameUI.dialogue;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverDialog extends Dialog {
    public GameOverDialog(Component parent, ActionListener repeatListener) {
        super(
                parent,
                "",
                "Sorry You Are Game Over",
                350,
                "/gameLibrary/gameEngine/res/game_over.png",
                "Exit",
                "Repeat",
                actionEvent -> System.exit(0),
                repeatListener);
    }
}
