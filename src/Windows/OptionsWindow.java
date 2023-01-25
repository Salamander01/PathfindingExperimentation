package Windows;

import javax.swing.*;
import java.awt.*;

class OptionsWindow extends Window {

    protected OptionsWindow() {
        super("Options Window", new Dimension(200, 100), true);
        JButton darkModeToggle = new JButton(WindowsManager.darkMode ? "Light Mode" : "Dark Mode");
        darkModeToggle.addActionListener(e -> {
            WindowsManager.darkMode = !WindowsManager.darkMode;
            darkModeToggle.setText(WindowsManager.darkMode ? "Light Mode" : "Dark Mode");
            WindowsManager.updateWindows();
        });
        this.add(darkModeToggle);
        this.frame.setVisible(true);
    }

}
