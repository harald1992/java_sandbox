package helper;

import object.GameObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CollisionHelper {

    public static float calculateOverlapRatio(GameObject obj1, GameObject obj2) {
        final Rectangle2D r1 = obj1.getBoxCollider();
        final Rectangle2D r2 = obj2.getBoxCollider();

        if (!r1.intersects(r2)) {
            return 0; // No overlap
        }

        final double ix1 = Math.max(r1.getMinX(), r2.getMinX());
        final double iy1 = Math.max(r1.getMinY(), r2.getMinY());
        final double ix2 = Math.min(r1.getMaxX(), r2.getMaxX());
        final double iy2 = Math.min(r1.getMaxY(), r2.getMaxY());

        final double iWidth = ix2 - ix1;
        final double iHeight = iy2 - iy1;

        if (iWidth < 0 || iHeight < 0) {
            return 0; // No actual overlap
        }

        final double overlapArea = iWidth * iHeight;
        final double obj1Area = r1.getWidth() * r1.getHeight();
        final double obj2Area = r2.getWidth() * r2.getHeight();
        final double totalArea = obj1Area + obj2Area - overlapArea; // Subtract overlapArea to avoid double counting

        return (float) (overlapArea / totalArea);
    }
}
