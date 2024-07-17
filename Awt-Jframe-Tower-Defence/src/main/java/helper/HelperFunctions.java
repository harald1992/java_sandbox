package helper;

public class HelperFunctions {

    public static int getRandomNumberBetween(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
