package helper;

import object.GameObject;

public class HelperFunctions {

    public static int getRandomNumberBetween(final int min, final int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static float getDistanceBetween(final GameObject object1, final GameObject object2) {
        final float dx = object1.getCenter().getX() - object2.getCenter().getX();
        final float dy = object1.getCenter().getY() - object2.getCenter().getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
