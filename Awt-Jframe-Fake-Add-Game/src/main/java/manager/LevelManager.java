package manager;

import helper.LevelBuilder;
import lombok.Getter;
import object.unit.Player;
import scene.PlayingScene;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;
import static configuration.Configuration.X_MAX;
import static configuration.Configuration.Y_MAX;
import static helper.LoadSave.loadFullImage;

@Getter
public class LevelManager {

    private final PlayingScene playingScene;

    private final TileManager tileManager;
    private final EnemyManager enemyManager;
    private final CheckpointManager checkpointManager;

    private final LevelBuilder levelBuilder = new LevelBuilder();
    private Player player;

    public LevelManager(final PlayingScene playingScene) {
        this.playingScene = playingScene;
        tileManager = new TileManager(this);
        enemyManager = new EnemyManager(this);
        checkpointManager = new CheckpointManager(this);
        startNewLevel();
    }

    public void startNewLevel() {
        tileManager.setTiles(levelBuilder.createTileMap());
        player = new Player(X_MAX / 2, Y_MAX - 5 * DEFAULT_UNIT_SIZE);

        enemyManager.setEnemies(levelBuilder.createEnemies());

        checkpointManager.setCheckpointRows(levelBuilder.createCheckpoints());

    }

    public void update() {
        tileManager.update();
        enemyManager.update();
        checkpointManager.update();
        player.update();
    }

    public void draw(Graphics2D g) {
        tileManager.draw(g);
        enemyManager.draw(g);
        checkpointManager.draw(g);
        player.draw(g);

        BufferedImage bg = loadFullImage("/BackgroundFade_medium.png");
//        g.drawImage(bg, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        //        g.setColor(Color.DARK_GRAY);
        //        g.drawRect(0,0, 100, 100);
    }



}
