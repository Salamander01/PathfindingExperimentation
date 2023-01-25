package Windows;

import java.util.ArrayList;

public class WindowsManager {
    protected static boolean darkMode = true;

    private static ArrayList<Window> windows;

    static {
        windows = new ArrayList<>();
    }

    public static void initWindows() {
        windows.add(new BallWindow());
        windows.add(new OptionsWindow());
    }

    public static void updateAll() {
        windows.forEach(Window::update);
    }
}
