package main;

public class Camera {

    private static float x, y;

    public static void setCameraPosition(final float xPos, final float yPos) {
        x = xPos;
        y = yPos;
    }

    public static int getCameraX() {
        return (int) x;
    }

    public static int getCameraY() {
        return (int) y;
    }
}
