package manager;

import helper.LevelBuilder;
import lombok.Getter;
import object.BaseClass;
import object.unit.Player;
import scene.PlayingScene;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.X_MAX;
import static configuration.Configuration.Y_MAX;
import static helper.LoadSave.loadFullImage;
import static manager.EnemyManager.getEnemyManager;
import static manager.ProjectileManager.getProjectileManager;

@Getter
public class LevelManager implements BaseClass {

    private final PlayingScene playingScene;

    private final TileManager tileManager;
    private final CheckpointManager checkpointManager;

    private final LevelBuilder levelBuilder = new LevelBuilder();
    private Player player;

    public LevelManager(final PlayingScene playingScene) {
        this.playingScene = playingScene;
        tileManager = new TileManager(this);
        checkpointManager = new CheckpointManager(this);
        startNewLevel();
    }

    public void startNewLevel() {
        tileManager.setTiles(levelBuilder.createTileMap());
        player = new Player(X_MAX / 2, Y_MAX - 5 * DEFAULT_UNIT_SIZE);

        getEnemyManager().setEnemies(levelBuilder.createEnemies());

        checkpointManager.setCheckpointRows(levelBuilder.createCheckpoints());

    }

    public void update() {
        tileManager.update();
        getEnemyManager().update();
        checkpointManager.update();
        getProjectileManager().update();
        player.update();
    }

    public void draw(Graphics2D g) {
        tileManager.draw(g);
        getEnemyManager().draw(g);
        checkpointManager.draw(g);
        player.draw(g);

        getProjectileManager().draw(g);

        BufferedImage bg = loadFullImage("/BackgroundFade_medium.png");
//        g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        //        g.setColor(Color.DARK_GRAY);
        //        g.drawRect(0,0, 100, 100);
    }



}
