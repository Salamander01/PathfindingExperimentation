import Windows.MainAnimation;

import java.util.Random;

public class Main {

    public static final boolean DARK_MODE = false;
    public static final int NUM_OF_BALLS = 40;

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation(DARK_MODE);
        for (int i = 0; i < NUM_OF_BALLS; i++) {
            animation.addBall(5,  randInt(0, 1200), randInt(0, 600), randOpt(new int[] {-1, 1}), randOpt(new int[] {-1, 1}));
        }
        while (true) {
            animation.step();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.err.println("Something went wrong with the sleep command.");
                e.printStackTrace();
            }
        }
    }

    static Random rand = new Random();

    public static int randInt(int start, int end) {
        return rand.nextInt(end - start) + start;
    }

    public static int randOpt(int[] options) {
        return options[randInt(0, options.length)];
    }
}