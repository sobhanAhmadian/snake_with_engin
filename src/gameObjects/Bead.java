package gameObjects;

import gameEngine.Sprite;

public class Bead extends Sprite {

    public Bead() {
        super("/res/bead.png");
    }

    @Override
    public void update() {
        setX(getX() + 1);
    }
}
