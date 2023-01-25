package Windows;

import java.awt.*;

class BallWindow extends Window {

    protected BallWindow() {
        super("Main Animation", new Dimension(800, 500),true);
        this.frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(WindowsManager.darkMode ? Color.WHITE : Color.BLACK);

        // TODO Ball and line drawing code here
    }

    @Override
    protected void update() {
        super.update();

        // TODO code for ball steps
    }
}
