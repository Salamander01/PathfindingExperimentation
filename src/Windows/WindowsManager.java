package Windows;

import Graph.Location;

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

        ballWindow.addBall(new Location(5, 5), 2, 2);
    }

    public static void updateAll() {
        ballWindow.userUpdate();
        optionsWindow.userUpdate();
    }
}
