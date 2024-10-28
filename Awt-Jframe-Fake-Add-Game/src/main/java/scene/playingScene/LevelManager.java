package scene.playingScene;

import helper.LevelBuilder;
import lombok.Getter;
import object.BaseClass;
import object.unit.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;
import static configuration.Configuration.X_MAX;
import static configuration.Configuration.Y_MAX;
import static helper.LoadSave.loadFullImage;
import static scene.playingScene.EnemyManager.getEnemyManager;
import static scene.playingScene.ProjectileManager.getProjectileManager;

@Getter
public class LevelManager implements BaseClass {

    private final PlayingScene playingScene;

    private  TileManager tileManager;
    private  CheckpointManager checkpointManager;

    private final LevelBuilder levelBuilder = new LevelBuilder();
    private Player player;

    public LevelManager(final PlayingScene playingScene) {
        this.playingScene = playingScene;
        tileManager = new TileManager();
        checkpointManager = new CheckpointManager();
        startNewLevel();
    }



    public void startNewLevel() {
        tileManager = new TileManager();
        EnemyManager.reset();
        checkpointManager = new CheckpointManager();
        ProjectileManager.reset();
        player = new Player(X_MAX / 2, Y_MAX - 5 * DEFAULT_UNIT_SIZE);

        tileManager.setTiles(levelBuilder.createTileMap());
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
        g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        //        g.setColor(Color.DARK_GRAY);
        //        g.drawRect(0,0, 100, 100);
    }



}
