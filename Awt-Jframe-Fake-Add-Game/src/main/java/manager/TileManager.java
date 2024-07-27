package manager;

import lombok.Setter;
import object.BaseClass;
import object.tile.Tile;

import java.awt.*;
import java.util.ArrayList;

@Setter
public class TileManager implements BaseClass {
    public ArrayList<Tile> tiles = new ArrayList<>();

    private final LevelManager levelManager;

    public TileManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void update() {
    }

    public void draw(Graphics2D g) {
        for (final Tile tile : tiles) {
            tile.draw(g);
        }
    }

}
