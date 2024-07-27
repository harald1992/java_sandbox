package constants;

import object.Vector2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimationDictionary {

    //    public static int[][] IDLE_TOP = { { 4, 2 }, { 5, 2 }, { 6, 2 }, { 7, 2 }, { 8, 2 }, { 9, 2 }, { 10, 2 }, { 11, 2 } };
    //    public static int[][] IDLE_TOP_LEFT = { { 4, 3 }, { 5, 3 }, { 6, 3 }, { 7, 3 }, { 8, 3 }, { 9, 3 }, { 10, 3 }, { 11, 3 } };
    //    public static int[][] IDLE_TOP_RIGHT = { { 4, 1 }, { 5, 1 }, { 6, 1 }, { 7, 1 }, { 8, 1 }, { 9, 1 }, { 10, 1 }, { 11, 1 } };

//    public static int[][] IDLE_LEFT = animationArrayBetween(new Vector2D(0, 0), new Vector2D(3, 0));
//    public static int[][] IDLE_TOP_LEFT = animationArrayBetween(new Vector2D(0, 1), new Vector2D(3, 1));
//    public static int[][] IDLE_TOP = animationArrayBetween(new Vector2D(0, 2), new Vector2D(3, 2));
//    public static int[][] IDLE_TOP_RIGHT = animationArrayBetween(new Vector2D(0, 3), new Vector2D(3, 3));
//    public static int[][] IDLE_RIGHT = animationArrayBetween(new Vector2D(0, 4), new Vector2D(3, 4));
//    ;
//    public static int[][] IDLE_BOTTOM_RIGHT = animationArrayBetween(new Vector2D(0, 5), new Vector2D(3, 5));
//    ;
//    public static int[][] IDLE_BOTTOM = animationArrayBetween(new Vector2D(0, 6), new Vector2D(3, 6));
//    ;
//    public static int[][] IDLE_BOTTOM_LEFT = animationArrayBetween(new Vector2D(0, 7), new Vector2D(3, 7));
//    ;
//
//    public static int[][] WALK_LEFT = animationArrayBetween(new Vector2D(4, 0), new Vector2D(10, 0));
//    public static int[][] WALK_TOP_LEFT = animationArrayBetween(new Vector2D(4, 1), new Vector2D(10, 1));
//    public static int[][] WALK_TOP = animationArrayBetween(new Vector2D(4, 2), new Vector2D(10, 2));
//    public static int[][] WALK_TOP_RIGHT = animationArrayBetween(new Vector2D(4, 3), new Vector2D(10, 3));
//    public static int[][] WALK_RIGHT = animationArrayBetween(new Vector2D(4, 4), new Vector2D(10, 4));
//    ;
//    public static int[][] WALK_BOTTOM_RIGHT = animationArrayBetween(new Vector2D(4, 5), new Vector2D(10, 5));
//    ;
//    public static int[][] WALK_BOTTOM = animationArrayBetween(new Vector2D(4, 6), new Vector2D(10, 6));
//    ;
//    public static int[][] WALK_BOTTOM_LEFT = animationArrayBetween(new Vector2D(4, 7), new Vector2D(10, 7));
//    ;

    //   static int y = 2;
    //        public static int[][] SHOOTING_LEFT = { { 28, 0 }, { 29, 0 }, { 30, 0 }, { 31, 0 } };
    //    public static int[][] SHOOTING_TOP_LEFT = { { 28, 1 }, { 29, 1 }, { 30, 1 }, { 31, 1 } };
    //    public static int[][] SHOOTING_TOP = { { 28, 2 }, { 29, 2 }, { 30, 2 }, { 31, 2 } };
    //    public static int[][] SHOOTING_TOP_RIGHT = { { 28, 3 }, { 29, 3 }, { 30, 3 }, { 31, 3 } };
    //    public static int[][] SHOOTING_RIGHT = { { 28, 4 }, { 29, 4 }, { 30, 4 }, { 31, 4 } };
    //    public static int[][] SHOOTING_BOTTOM_RIGHT = { { 28, 5 }, { 29, 5 }, { 30, 5 }, { 31, 5 } };
    //    public static int[][] SHOOTING_BOTTOM = { { 28, 6 }, { 29, 6 }, { 30, 6 }, { 31, 6 } };
    //    public static int[][] SHOOTING_BOTTOM_LEFT = { { 28, 7 }, { 29, 7 }, { 30, 7 }, { 31, 7 } };

//    public static int[][] SHOOTING_LEFT = animationArrayBetween(new Vector2D(28, 0), new Vector2D(31, 0));
//    public static int[][] SHOOTING_TOP_LEFT = animationArrayBetween(new Vector2D(28, 1), new Vector2D(31, 1));
//    public static int[][] SHOOTING_TOP = animationArrayBetween(new Vector2D(28, 2), new Vector2D(31, 2));
//    public static int[][] SHOOTING_TOP_RIGHT = animationArrayBetween(new Vector2D(28, 3), new Vector2D(31, 3));
//    public static int[][] SHOOTING_RIGHT = animationArrayBetween(new Vector2D(28, 4), new Vector2D(31, 4));
//    ;
//    public static int[][] SHOOTING_BOTTOM_RIGHT = animationArrayBetween(new Vector2D(28, 5), new Vector2D(31, 5));
//    ;
//    public static int[][] SHOOTING_BOTTOM = animationArrayBetween(new Vector2D(28, 6), new Vector2D(31, 6));
//    ;
//    public static int[][] SHOOTING_BOTTOM_LEFT = animationArrayBetween(new Vector2D(28, 7), new Vector2D(31, 7));
//    ;

    private static int[][] animationArrayBetween(final Vector2D start, final Vector2D end) {
        final int length = end.getX() - start.getX() + 1; // +1 to include end vector
        final int[][] animationArray = new int[length][2];

        for (int i = 0; i < length; i++) {
            animationArray[i] = new int[] { start.getX() + i, start.getY() };
        }
        return animationArray;
    }

    public static LinkedHashMap<String, int[][]> animationCoordinatesMap = new LinkedHashMap<>();

    public static ArrayList<String> allDirections = new ArrayList<>(Arrays.asList("LEFT", "TOP_LEFT", "TOP", "TOP_RIGHT", "RIGHT", "BOTTOM_RIGHT", "BOTTOM", "BOTTOM_LEFT"));
    public static ArrayList<String> allActions = new ArrayList<>(Arrays.asList("IDLE", "WALK", "SHOOT"));

    static {
        final int idleStartX = 0;
        final int idleEndX = 3;
        final int walkStartX = 4;
        final int walkEndX = 10;
        final int shootStartX = 28;
        final int shootEndX = 31;

        for (final String action : allActions) {
            for (int y = 0; y < allDirections.size(); y++) {
                final String direction = allDirections.get(y);

                final int startX = switch (action) {
                    case "IDLE" -> idleStartX;
                    case "WALK" -> walkStartX;
                    case "SHOOT" -> shootStartX;
                    default -> throw new IllegalStateException("Unexpected value: " + action);
                };
                final int endX = switch (action) {
                    case "IDLE" -> idleEndX;
                    case "WALK" -> walkEndX;
                    case "SHOOT" -> shootEndX;
                    default -> throw new IllegalStateException("Unexpected value: " + action);
                };
                animationCoordinatesMap.put(action + "_" + direction, animationArrayBetween(new Vector2D(startX, y), new Vector2D(endX, y)));
            }
        }

//        for (final Map.Entry<String, int[][]> entry : animationCoordinatesMap.entrySet()) {
//           final String key = entry.getKey();
//           final int[][] value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + Arrays.deepToString(value));
//        }
    }

//    public static int[][] getAnimationCoordinates(final AnimationStateEnum animationState) {
//        final var value =  animationCoordinatesMap.get(animationState.getText());
////        System.out.println(Arrays.deepToString(value));
//        return value;
//    }

    public static int[][] getAnimationCoordinates(final String animationStateString) {
      return animationCoordinatesMap.get(animationStateString);
    }

}
