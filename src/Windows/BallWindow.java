package Windows;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class BallWindow extends Window {

    protected BallWindow() {
        super("Main Animation", new Dimension(800, 500),true);
//        MouseListener mouseListener = new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        };
        this.addMouseListener(mouseListener);
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
