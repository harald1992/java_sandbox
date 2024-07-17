//package Archive;
//
//import object.PlayerMinion;
//
//import java.awt.geom.Point2D;
//import java.util.ArrayList;
//import java.util.List;
//
//import static configuration.Configuration.DEFAULT_UNIT_SIZE;
//import static configuration.Configuration.TILE_SIZE;
//import static helper.SpreadingHelpers.spreadObjectsInCircle;
//import static helper.SpreadingHelpers.spreadObjectsInSquare;
//
//public class Archive {
//    public void setAmount_oldrect(final int amount) {
//        this.amount = amount;
//        int spread = TILE_SIZE / 2;
//        Point2D topLeft = new Point2D.Double(x - spread, y - spread);
//        Point2D topRight = new Point2D.Double(x + spread, y + spread);
//        Point2D bottomLeft = new Point2D.Double(0, y - 100);
//        Point2D bottomRight = new Point2D.Double(x + 100, y - 100);
//        int sizeModifier = 1;
//        List<Point2D> positions = spreadObjectsInSquare(topLeft, topRight, bottomLeft, bottomRight, amount);
//
//        playerMinions.clear();
//        positions.forEach(position -> playerMinions.add(
//                new PlayerMinion((float) position.getX(), (float) position.getY(), DEFAULT_UNIT_SIZE / sizeModifier, 2 * DEFAULT_UNIT_SIZE / sizeModifier)));
//
//    }
//
//    public void setAmount_Circle(final int amount) {
//        this.amount = amount;
//        final List<Point2D> positions = new ArrayList<>();
//
//        // middle one always filled
//        positions.add(new Point2D.Double(x, y));
//        int amountRemaining = amount - 1;
//        final int sizeModifier = 1 + (int) Math.log(amount) / 5;
//        System.out.println("size modifier: " + sizeModifier);
//
//        final Point2D center = new Point2D.Double(x, y); // Center of the circle
//        int step = 5;
//        double radius = 0.5 * TILE_SIZE;
//
//        while (amountRemaining > 0) {
//
//            final int innerStep = Math.min(amountRemaining, step);
//            positions.addAll(spreadObjectsInCircle(center, radius, innerStep));
//            step = (int) (step * 1.2f);
//            radius += 0.15 * TILE_SIZE;
//            amountRemaining -= innerStep;
//        }
//
//        playerMinions.clear();
//        positions.forEach(position -> playerMinions.add(
//                new PlayerMinion((float) position.getX(), (float) position.getY(), DEFAULT_UNIT_SIZE / sizeModifier, 2 * DEFAULT_UNIT_SIZE / sizeModifier)));
//
//    }
//
//    public static List<Point2D> spreadObjectsInCircle(Point2D center, double radius, int numberOfObjects) {
//        final List<Point2D> positions = new ArrayList<>();
//        final double angleStep = 360.0 / numberOfObjects;
//
//        for (int i = 0; i < numberOfObjects; i++) {
//            double angleInRadians = Math.toRadians(i * angleStep);
//            double x = center.getX() + radius * Math.cos(angleInRadians);
//            double y = center.getY() + radius * Math.sin(angleInRadians);
//            positions.add(new Point2D.Double(x, y));
//        }
//
//        return positions;
//    }
//
//    public static List<Point2D> spreadObjectsInSquare(Point2D topLeft, Point2D topRight, Point2D bottomLeft, Point2D bottomRight, int numberOfObjects) {
//        List<Point2D> positions = new ArrayList<>();
//        int objectsPerSide = numberOfObjects / 4;
//        double sideLengthX = topRight.getX() - topLeft.getX();
//        double sideLengthY = bottomLeft.getY() - topLeft.getY();
//        double deltaX = sideLengthX / (objectsPerSide - 1);
//        double deltaY = sideLengthY / (objectsPerSide - 1);
//
//        // Top side
//        for (int i = 0; i < objectsPerSide; i++) {
//            positions.add(new Point2D.Double(topLeft.getX() + i * deltaX, topLeft.getY()));
//        }
//
//        // Right side
//        for (int i = 1; i < objectsPerSide; i++) { // Start from 1 to avoid corner overlap
//            positions.add(new Point2D.Double(topRight.getX(), topRight.getY() + i * deltaY));
//        }
//
//        // Bottom side
//        for (int i = 1; i < objectsPerSide; i++) {
//            positions.add(new Point2D.Double(bottomRight.getX() - i * deltaX, bottomRight.getY()));
//        }
//
//        // Left side
//        for (int i = 1; i < objectsPerSide - 1; i++) { // End one early to avoid corner overlap
//            positions.add(new Point2D.Double(bottomLeft.getX(), bottomLeft.getY() - i * deltaY));
//        }
//
//        return positions;
//    }
//}
