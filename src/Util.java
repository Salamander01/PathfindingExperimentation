import java.util.Random;

public class Util {
    private static final Random rand = new Random();

    public static int randInt(int begin, int end) {
        return rand.nextInt(end - begin) + begin;
    }

    public static Object randOpt(Object[] options) {
        return options[randInt(0, options.length)];
    }
}
