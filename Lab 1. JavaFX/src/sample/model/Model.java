package sample.model;

/**
 * Created by Alex on 21.02.2017.
 */
public class Model {
    private static final int min = 0;
    private static final int max = 100;

    private int generatedNum;

    /**
     * Main constructor
     */
    public Model() {
        generateNewNumber();
    }

    /**
     * Generate random numler in range
     *
     * @param min Minimum value
     * @param max Maximum value
     * @return Random number
     */
    public static double randomInRange(final int min, final int max) {
        return (min + Math.random() * (max - min));
    }

    /**
     * Saving new random number
     */
    public void generateNewNumber() {
        generatedNum = (int) randomInRange(min, max);
    }

    /**
     * Compare your number with random
     *
     * @param num Number to compare
     * @return Returns 0 if you divine number, returns 1, if your number more that set number, else -1
     */
    public int compare(final int num) {
        if (num > generatedNum) {
            return 1;
        }

        if (num == generatedNum) {
            return 0;
        }

        return -1;
    }
}
