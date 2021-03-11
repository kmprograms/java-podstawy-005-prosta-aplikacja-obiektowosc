package generator;

import java.util.Random;

public interface NumberGenerator {
    Random random = new Random();

    /**
     *
     * @param min ...
     * @param max ...
     * @return ...
     */
    static int intValue(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Illegal generation range: [ " + min + ", " + max + "]");
        }
        return random.nextInt(max - min + 1) + min;
    }
}
