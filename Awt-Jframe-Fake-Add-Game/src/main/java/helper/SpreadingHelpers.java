package helper;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class SpreadingHelpers {



    public static List<Point2D> arrangeUnitsInFormation(Point2D center, int amount, int initialColumns, double spaceBetweenUnits, double unitSize) {
        final List<Point2D> positions = new ArrayList<>();
        int columns = initialColumns;
        int rows = (int) Math.ceil((double) amount / columns);

        // Adjust columns and rows based on the amount to maintain formation
        while (rows * columns < amount) {
            columns++;
            rows = (int) Math.ceil((double) amount / columns);
        }

        double totalWidth = columns * unitSize + (columns - 1) * spaceBetweenUnits;
        double totalHeight = rows * unitSize + (rows - 1) * spaceBetweenUnits;

        // Calculate the starting position to center the formation
        double startX = center.getX() - totalWidth / 2;
        double startY = center.getY() - totalHeight / 2;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int index = row * columns + col;
                if (index >= amount) break; // Stop if we've placed all units

                double x = startX + col * (unitSize + spaceBetweenUnits);
                double y = startY + row * (unitSize + spaceBetweenUnits);
                positions.add(new Point2D.Double(x, y));
            }
        }

        return positions;
    }

}
