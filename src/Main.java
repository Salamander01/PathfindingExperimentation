import Windows.MainAnimation;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        for (int i = 0; i < 20; i++) {
            animation.addBall(5,  randInt(0, 1200), randInt(0, 600), (-2 * randInt(0, 2) + 1) * 2, (-2 * randInt(0, 2) + 1) * 2);
        }
        while (true) {
            animation.step();
            try {
                Thread.sleep(20);
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
}