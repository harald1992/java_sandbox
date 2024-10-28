import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static helper.FormationHelpers.getFormation;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormationHelpersTest {

    @Test
    void getRightRowsColumns0() {
        final ArrayList<Point2D> formation = getFormation(1, 4);
        System.out.println(formation.getFirst());
        assertEquals(List.of(new Point2D.Float(0, 0)), formation);
    }

    @Test
    void getRightRowsColumns2() {
        final ArrayList<Point2D> formation = getFormation(2, 4);
        assertEquals(List.of(new Point2D.Float(0, 0), new Point2D.Float(1, 0)), formation);
    }

    @Test
    void getRightRowsColumns4() {
        final ArrayList<Point2D> formation = getFormation(4, 4);
        assertEquals(List.of(
                new Point2D.Float(0, 0),
                new Point2D.Float(1, 0),
                new Point2D.Float(2, 0),
                new Point2D.Float(3, 0)
                ),
        formation);
    }

    @Test
    void getRightRowsColumns9() {
        final ArrayList<Point2D> formation = getFormation(9, 4);

        assertEquals(formation.size(), 9);
        assertEquals(List.of(
                        new Point2D.Float(0, 0),
                        new Point2D.Float(1, 0),
                        new Point2D.Float(2, 0),
                        new Point2D.Float(3, 0),
                        new Point2D.Float(0, 1),
                        new Point2D.Float(1, 1),
                        new Point2D.Float(2, 1),
                        new Point2D.Float(3, 1),
                        new Point2D.Float(0, 2)
                ),
                formation);
    }
}
