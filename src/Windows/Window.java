package Windows;

import javax.swing.*;
import java.awt.*;

class Window extends JPanel {

    protected final JFrame frame;

    // Constructors
    private Window(String name, boolean maxSize, Dimension size, boolean resizeable) {
        setBackground(WindowsManager.darkMode ? Color.BLACK : Color.WHITE);

        frame = new JFrame(name);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (maxSize) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            frame.setSize(size);
        }

        frame.setResizable(resizeable);

        frame.setContentPane(this);
    }

    protected Window(String name, Dimension size, boolean resizeable) {
        this(name, false, size, resizeable);
    }

    protected Window(String name, boolean resizeable) {
        this(name, true, null, resizeable);
    }

    // Protected Methods
    protected void update() {
        setBackground(WindowsManager.darkMode ? Color.BLACK : Color.WHITE);
        repaint();
    }

}
