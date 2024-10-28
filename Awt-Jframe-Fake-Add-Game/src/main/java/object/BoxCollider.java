package object;

import java.awt.geom.Rectangle2D;

import static main.Camera.getCameraX;
import static main.Camera.getCameraY;

public class BoxCollider extends Rectangle2D.Float {

    public BoxCollider(final float x, final float y, final int width, final int height) {
        super(x, y, width, height);
    }

    public int drawX() {
        return (int) (x - getCameraX());
    }

    public int drawY() {
        return (int) (y - getCameraY());
    }

}
