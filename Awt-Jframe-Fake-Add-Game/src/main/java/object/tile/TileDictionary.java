//package object.tile;
//
//import java.awt.image.BufferedImage;
//import java.util.HashMap;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//import static helper.HelperFunctions.getRandomNumberBetween;
//import static helper.LoadSave.loadFullImage;
//
//public class TileDictionary {
//
//    private static HashMap<TileEnum, Function<TileEnum, Function<Void, BufferedImage>>> spriteFunctions = new HashMap<>();
//
//   static {
//        loadSprites();
//    }

//
//    private static void loadSprites() {
//        spriteFunctions.put(TileEnum.WATER, tile -> t -> getRandomWaterSprite());
//        spriteFunctions.put(TileEnum.WATER_LEFT, tile -> t -> getRandomWaterLeftSprite());
//        spriteFunctions.put(TileEnum.WATER_RIGHT, tile -> t -> getRandomWaterRightSprite());
//        spriteFunctions.put(TileEnum.ROAD, tile -> t ->  loadFullImage("/sprites/road/road.png"));
//    }
//
//    public static BufferedImage getTileSprite(final TileEnum tileEnum) {
//        return spriteFunctions.getOrDefault(tileEnum, tile -> null).apply(tileEnum);
//    }
//
//    private static BufferedImage getRandomWaterSprite() {
//        int randomTileIndex = getRandomNumberBetween(21, 33);
//        return loadFullImage("/sprites/water/water/watrtl" + randomTileIndex + ".png");
//    }
//
//    private static BufferedImage getRandomWaterLeftSprite() {
//        int randomTileIndex = getRandomNumberBetween(5, 8);
//        return loadFullImage("/sprites/water/water-left/watrtl0" + randomTileIndex + "mirror.png");
//    }
//
//    private static BufferedImage getRandomWaterRightSprite() {
//        int randomTileIndex = getRandomNumberBetween(5, 8);
//        return loadFullImage("/sprites/water/water-right/watrtl0" + randomTileIndex + ".png");
//    }
//
//
//}
