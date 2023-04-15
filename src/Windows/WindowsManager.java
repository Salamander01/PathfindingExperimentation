package Windows;

import Graph.Location;

import java.util.Random;

public class WindowsManager {
    protected static boolean darkMode = true;

    private static BallWindow ballWindow;
    private static OptionsWindow optionsWindow;

    public enum windowType {
        BALL_WINDOW,
        OPTIONS_WINDOW
    }

    public static void initWindows() {
        ballWindow = new BallWindow();
        optionsWindow = new OptionsWindow();

        for (int i = 0; i < 50; i++) {
            ballWindow.addBall(new Location(randInt(1, ballWindow.getWidth()), randInt(0, ballWindow.getHeight())), 1, 1);
        }

        ballWindow.addBall(new Location(5, 5), 2, 2);
    }

    public static void userUpdateAll() {
        ballWindow.update();
        optionsWindow.update();
    }

    public static int randInt(int begin, int end) {
        return new Random().nextInt(end - begin) + begin;
    } // TODO remove this
}
