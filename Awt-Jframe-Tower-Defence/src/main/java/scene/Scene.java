package scene;

import main.Game;

public abstract class Scene {
    private Game game;

    public Scene(Game game) {
        this.game = game;
    }
}
