package helper;

import enums.DirectionEnum;
import object.Vector2D;

public class MathHelpers {

    public static DirectionEnum convertAngleToDirection(final float angleDegrees) {
        final int index = (int) ((angleDegrees + 360 + 22.5) % 360) / 45;
        return switch (index) {
            case 0 -> DirectionEnum.RIGHT;
            case 1 -> DirectionEnum.TOP_RIGHT;
            case 2 -> DirectionEnum.TOP;
            case 3 -> DirectionEnum.TOP_LEFT;
            case 4 -> DirectionEnum.LEFT;
            case 5 -> DirectionEnum.BOTTOM_LEFT;
            case 6 -> DirectionEnum.BOTTOM;
            case 7 -> DirectionEnum.BOTTOM_RIGHT;
            default ->
                // This default case should never be reached due to the modulo operation,
                // but it's good practice to handle it.
                    null;
        };
    }

    public static float convertVector2DToAngleDegrees(final Vector2D vector) {
        return (float) Math.toDegrees(Math.atan2(vector.getYFloat(), vector.getXFloat()));
    }

}
