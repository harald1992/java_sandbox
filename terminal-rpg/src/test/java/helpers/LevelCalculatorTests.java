package helpers;

import org.junit.jupiter.api.Test;

import static helpers.LevelCalculator.calculateXpForLevel;

public class LevelCalculator {

    @Test
    void calculateLevels() {

        for (int i = 0; i < 20; i++) {
            System.out.println(calculateXpForLevel(i));
        }
    }

}
