package org.mahesha;

public class RandomGenerator {

    /**
     * @param low  The lower value for random generator (included)
     * @param high The high value for random generator (not-included)
     * @return integer between low and high(not-included)
     */
    public static int generateNumber(int low, int high) {
        int num = (int) (Math.random() * high);
        if (num < low) {
            num = num + low;
            if (num > high) {
                num = num - (high - low) - 1;
            }
        }
        return num;
    }
}
