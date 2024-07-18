package main;

public class Camera {

    private static int x, y;

    public static void setCameraPosition(final int xPos, final int yPos) {
        x = xPos;
        y = yPos;
//        int intX = (int) Math.floor(xPos);
//        int intY = (int) Math.floor(yPos);

        // Update camera position with integer coordinates to avoid rounding errors
//        x = intX;
//        y = intY;
    }

    public static int getCameraX() {
        return  x;
    }

    public static int getCameraY() {
        return y;
    }
}
