package scene.playingScene;

import lombok.Getter;
import main.Game;
import scene.Scene;
import scene.SceneMethods;

import java.awt.*;

@Getter
public class PlayingScene extends Scene implements SceneMethods {
    private final LevelManager levelManager;

    public PlayingScene(final Game game) {
        super(game);
        this.levelManager = new LevelManager(this);
    }

    public void update() {
        levelManager.update();
    }

    @Override
    public void render(Graphics2D g) {
        levelManager.draw(g);

    }
}
