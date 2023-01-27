package Windows;

import Graph.Location;
import Windows.Elements.Ball;

import java.awt.*;
import java.util.ArrayList;

class BallWindow extends Window {

    private ArrayList<Ball> balls;

    protected BallWindow() {
        super("Main Animation", new Dimension(800, 500),true);

        this.balls = new ArrayList<>();

        Thread thread = new Thread(() -> {
            while (true) {
                this.systemUpdate();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        this.frame.setVisible(true);
    }

    public void addBall(Location loc, double dx, double dy) {
        this.balls.add(new Ball(6, loc, dx, dy));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(WindowsManager.darkMode ? Color.WHITE : Color.BLACK);

        this.balls.forEach(ball -> {
            g.fillOval((int)(ball.getLoc().x() - ball.getRadius()), (int)(ball.getLoc().y() - ball.getRadius()), (int) ball.getDiameter(), (int) ball.getDiameter());
        });
    }

    @Override
    protected void systemUpdate() {
        super.systemUpdate();
        this.balls.forEach(e -> e.update(this.getWidth(), this.getHeight()));
        repaint();
    }
}
