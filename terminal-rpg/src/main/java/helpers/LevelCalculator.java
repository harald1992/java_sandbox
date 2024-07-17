package helpers;

public class LevelCalculator {

    private static final double Y = 3; // Adjust based on how quickly levels should increase

    public static int calculateXpForLevel(int level) {
        return (int) Math.pow(level, Y);
    }

    public static int calculateLevelForXp(int xp) {
        return (int) Math.round( Math.pow(xp, 1/Y));
    }

}
