package manager;

import helper.LevelBuilder;
import lombok.Getter;
import object.Player;
import scene.PlayingScene;

import java.awt.*;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.X_MAX;
import static configuration.Configuration.Y_MAX;

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
        player = new Player(0.5f * X_MAX, Y_MAX - 10 * DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, 2 * DEFAULT_UNIT_SIZE);

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

//        g.setColor(Color.DARK_GRAY);
//        g.drawRect(0,0, 100, 100);
    }

}
