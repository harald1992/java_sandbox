package configuration;

public class Configuration {

    public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 640;
    public static final int TILE_SIZE = 64;
    public static final int X_MAX = 2 * GAME_WIDTH;
    public static final int Y_MAX = 10 * GAME_HEIGHT;
    public static final int ROAD_X_MIN = X_MAX / 2 - 4 * TILE_SIZE;
    public static final int ROAD_X_MAX = X_MAX / 2 + 3 * TILE_SIZE;
    public static final int ROAD_WIDTH =  ROAD_X_MAX - ROAD_X_MIN;

    public static final int DEFAULT_UNIT_SIZE = 64;

}
