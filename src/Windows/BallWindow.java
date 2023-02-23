package Windows;

import Graph.Location;
import Windows.Elements.Ball;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class BallWindow extends Window {

    private ArrayList<Ball> balls;

    protected BallWindow() {
        super("Main Animation", new Dimension(800, 500),true);

        this.balls = new ArrayList<>();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            balls.forEach(e -> e.update(this.getWidth(), this.getHeight()));
            this.repaint();
        }, 10, 15, TimeUnit.MILLISECONDS);

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

}
