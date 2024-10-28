import enums.DirectionEnum;
import helper.MathHelpers;
import object.Vector2D;
import org.junit.jupiter.api.Test;

import static helper.MathHelpers.convertAngleToDirection;
import static helper.MathHelpers.convertVector2DToAngleDegrees;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathHelpersTest {
    private static final float DELTA = 0.01f; // Allowable delta for floating-point comparisons

    @Test
    public void testConvertAngleToDirectionRight() {
        assertEquals(DirectionEnum.RIGHT, convertAngleToDirection(0));
        assertEquals(DirectionEnum.RIGHT, convertAngleToDirection(360));
        assertEquals(DirectionEnum.RIGHT, convertAngleToDirection(1));
        assertEquals(DirectionEnum.RIGHT, convertAngleToDirection(359));
    }

    @Test
    public void testConvertAngleToDirectionTopRight() {
        assertEquals(DirectionEnum.TOP_RIGHT, convertAngleToDirection(22.5f));
        assertEquals(DirectionEnum.TOP_RIGHT, convertAngleToDirection(45));
        assertEquals(DirectionEnum.TOP_RIGHT, convertAngleToDirection(67.4f));
    }

    @Test
    public void testConvertAngleToDirectionTop() {
        assertEquals(DirectionEnum.TOP, convertAngleToDirection(67.5f));
        assertEquals(DirectionEnum.TOP, convertAngleToDirection(90));
        assertEquals(DirectionEnum.TOP, convertAngleToDirection(112.4f));
    }

    @Test
    public void testConvertAngleToDirectionTopLeft() {
        assertEquals(DirectionEnum.TOP_LEFT, convertAngleToDirection(112.5f));
        assertEquals(DirectionEnum.TOP_LEFT, convertAngleToDirection(135));
        assertEquals(DirectionEnum.TOP_LEFT, convertAngleToDirection(157.4f));
    }

    @Test
    public void testConvertAngleToDirectionLeft() {
        assertEquals(DirectionEnum.LEFT, convertAngleToDirection(157.5f));
        assertEquals(DirectionEnum.LEFT, convertAngleToDirection(180));
        assertEquals(DirectionEnum.LEFT, convertAngleToDirection(202.4f));
    }

    @Test
    public void testConvertAngleToDirectionBottomLeft() {
        assertEquals(DirectionEnum.BOTTOM_LEFT, convertAngleToDirection(202.5f));
        assertEquals(DirectionEnum.BOTTOM_LEFT, convertAngleToDirection(225));
        assertEquals(DirectionEnum.BOTTOM_LEFT, convertAngleToDirection(247.4f));
    }

    @Test
    public void testConvertAngleToDirectionBottom() {
        assertEquals(DirectionEnum.BOTTOM, convertAngleToDirection(247.5f));
        assertEquals(DirectionEnum.BOTTOM, convertAngleToDirection(270));
        assertEquals(DirectionEnum.BOTTOM, convertAngleToDirection(292.4f));
    }

    @Test
    public void testConvertAngleToDirectionBottomRight() {
        assertEquals(DirectionEnum.BOTTOM_RIGHT, convertAngleToDirection(292.5f));
        assertEquals(DirectionEnum.BOTTOM_RIGHT, convertAngleToDirection(315));
        assertEquals(DirectionEnum.BOTTOM_RIGHT, convertAngleToDirection(337.4f));
    }

    @Test
    public void testConvertVector2DToAngleDegreesRight() {
        assertEquals(0, convertVector2DToAngleDegrees(new Vector2D(1, 0)), DELTA);
    }

    @Test
    public void testConvertVector2DToAngleDegreesUp() {
        assertEquals(90, convertVector2DToAngleDegrees(new Vector2D(0, 1)), DELTA);
    }

    @Test
    public void testConvertVector2DToAngleDegreesLeft() {
        assertEquals(180, convertVector2DToAngleDegrees(new Vector2D(-1, 0)), DELTA);
    }

    @Test
    public void testConvertVector2DToAngleDegreesDown() {
        final Vector2D vector = new Vector2D(0, -1);
        final float expected = -90;
        assertEquals(expected, convertVector2DToAngleDegrees(vector), DELTA);
    }

    @Test
    public void testConvertVector2DToAngleDegreesQuadrant1() {
        final Vector2D vector = new Vector2D(1, 1);
        final float expected = 45;
        assertEquals(expected, convertVector2DToAngleDegrees(vector), DELTA);
    }

    @Test
    public void testConvertVector2DToAngleDegreesQuadrantCommas() {
        final Vector2D vector = new Vector2D(-0.25678076f, 0.966467f);
        final float expected = 104.879f;
        assertEquals(expected, convertVector2DToAngleDegrees(vector), DELTA);
    }


}
