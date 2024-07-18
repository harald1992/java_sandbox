package helper;

import object.CheckpointRow;
import object.unit.Enemy;
import object.tile.Tile;
import object.tile.TileEnum;

import java.util.ArrayList;

import static configuration.Configuration.ROAD_X_MAX;
import static configuration.Configuration.ROAD_X_MIN;
import static configuration.Configuration.TILE_SIZE;
import static configuration.Configuration.X_MAX;
import static configuration.Configuration.Y_MAX;
import static helper.HelperFunctions.getRandomNumberBetween;

public class LevelBuilder {

    private int[][] createBaseMap() {
        final int[][] level = new int[X_MAX / TILE_SIZE][Y_MAX / TILE_SIZE];

        // base floor
        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
            for (int x = 0; x < X_MAX / TILE_SIZE; x++) {
                level[x][y] = TileEnum.WATER.getValue();
            }
        }

        // water-left
        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
                final int x = ROAD_X_MIN / TILE_SIZE - 1;
            level[x][y] = TileEnum.WATER_LEFT.getValue();
        }

        // road
        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
            for (int x = ROAD_X_MIN / TILE_SIZE; x < ROAD_X_MAX / TILE_SIZE; x++) {
                level[x][y] = TileEnum.ROAD.getValue();
            }
        }

        // water-right
        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
            final int x = ROAD_X_MAX / TILE_SIZE;
            level[x][y] = TileEnum.WATER_RIGHT.getValue();
        }

        //        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
        //            for (int x = 0; x < X_MAX / TILE_SIZE; x++) {
        //                System.out.print(level[x][y]);
        //            }
        //            System.out.println();
        //        }
        return level;
    }

    public ArrayList<Tile> createTileMap() {
        final int[][] level = createBaseMap();

        final ArrayList<Tile> tiles = new ArrayList<>();

        for (int y = 0; y < Y_MAX / TILE_SIZE; y++) {
            for (int x = 0; x < X_MAX / TILE_SIZE; x++) {
                final int value = level[x][y];
                tiles.add(new Tile(TileEnum.fromValue(value), x * TILE_SIZE, y * TILE_SIZE));
//                if (value < 10) {
//                    tiles.add(new Water(value, x * TILE_SIZE, y * TILE_SIZE));
//                } else {
//                    tiles.add(new Road(value, x * TILE_SIZE, y * TILE_SIZE));
//                }
            }
        }
        return tiles;
    }

    public ArrayList<Enemy> createEnemies() {
        final ArrayList<Enemy> enemies = new ArrayList<>();

        for (int y = 0; y < Y_MAX - 15 * TILE_SIZE; y += 15 * TILE_SIZE) {
            final int randomX = getRandomNumberBetween(ROAD_X_MIN, ROAD_X_MAX);
            enemies.add(new Enemy(randomX, y));
//            randomX = getRandomNumberBetween(ROAD_X_MIN, ROAD_X_MAX);

//            enemies.add(new Enemy(randomX, y, DEFAULT_UNIT_SIZE, 2 * DEFAULT_UNIT_SIZE));
        }

        return enemies;
    }

    public ArrayList<CheckpointRow> createCheckpoints() {
        final ArrayList<CheckpointRow> checkpointRows = new ArrayList<>();

        for (int y = 7 * TILE_SIZE; y < Y_MAX; y += 15 * TILE_SIZE) {
            final int width = ROAD_X_MAX - ROAD_X_MIN;
            checkpointRows.add(new CheckpointRow(ROAD_X_MIN, y, width));
        }

        return checkpointRows;
    }

}
