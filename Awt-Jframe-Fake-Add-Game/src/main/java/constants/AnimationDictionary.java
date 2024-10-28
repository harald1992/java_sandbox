package constants;

import object.Vector2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class AnimationDictionary {


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
    public static ArrayList<String> allActions = new ArrayList<>(Arrays.asList("IDLE", "WALK", "SHOOT", "ATTACK"));

    static {
        final int idleStartX = 0;
        final int idleEndX = 3;
        final int walkStartX = 4;
        final int walkEndX = 10;
        final int shootStartX = 28;
        final int shootEndX = 31;
        final int attackStartX = 16; //~~~~~~~~~ minotaur only
        final int attackEndX = 22;  // minotaur only

        for (final String action : allActions) {
            for (int y = 0; y < allDirections.size(); y++) {
                final String direction = allDirections.get(y);

                final int startX = switch (action) {
                    case "IDLE" -> idleStartX;
                    case "WALK" -> walkStartX;
                    case "SHOOT" -> shootStartX;
                    case "ATTACK" -> attackStartX;

                    default -> throw new IllegalStateException("Unexpected value: " + action);
                };
                final int endX = switch (action) {
                    case "IDLE" -> idleEndX;
                    case "WALK" -> walkEndX;
                    case "SHOOT" -> shootEndX;
                    case "ATTACK" -> attackEndX;
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
