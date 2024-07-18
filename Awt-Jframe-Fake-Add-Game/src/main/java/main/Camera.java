package main;

public class Camera {

    private static float x, y;

    public static void setCameraPosition(final float xPos, final float yPos) {
        x = xPos;
        y = yPos;
//        int intX = (int) Math.floor(xPos);
//        int intY = (int) Math.floor(yPos);

        // Update camera position with integer coordinates to avoid rounding errors
//        x = intX;
//        y = intY;
    }

    public static float getCameraX() {
        return  x;
    }

    public static float getCameraY() {
        return y;
    }
}
