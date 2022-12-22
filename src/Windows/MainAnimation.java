package Windows;

import Graph.Location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MainAnimation extends JPanel {

    public static final int CLOSE_LINE_TOLERANCE = 150;

    private ArrayList<Ball> balls;

    private int width, height;

    public MainAnimation() {
        this.balls = new ArrayList<>();

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Main Animation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1200, 600);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.setVisible(true);
    }

    public void step() {
        this.width = getWidth();
        this.height = getHeight();

        for (Ball ball : balls) {
            ball.step(width, height);
        }

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
//            g.setColor(Color.red);
//            g.fillOval((int)(ball.getX() - 100), (int)(ball.getY() - 100), 200, 200);
//            g.setColor(Color.black);
//            xSorted = (ArrayList<Ball>) sort(xSorted, Mode.X);
            LineManager manager = new LineManager(g);
            findNearBalls(manager, sort(balls, Mode.X), Mode.X);
//            ySorted = (ArrayList<Ball>) sort(ySorted, Mode.Y);
            findNearBalls(manager, sort(balls, Mode.Y), Mode.Y);

            g.setColor(Color.BLACK);
            g.fillOval((int)(ball.getX() - ball.getRadius()), (int)(ball.getY() - ball.getRadius()), (int) ball.getDiameter(), (int) ball.getDiameter());
        }
    }

    private void findNearBalls(LineManager lineManager, List<Ball> list, Mode mode) {
        for (int i = 0; i < list.size() - 2; i++) {
            int j = i + 1;
            while ((getCoordOf(list.get(j), mode) - getCoordOf(list.get(i), mode)) < CLOSE_LINE_TOLERANCE) {
                lineManager.suggestLine(new Line(list.get(i).getLoc(), list.get(j).getLoc()));
                j++;
                if (j > list.size() - 1) break;
            }
        }
    }

    private double getCoordOf(Ball ball, Mode mode) {
        return switch (mode) {
            case X -> ball.getX();
            case Y -> ball.getY();
        };
    }

    public void addBall(float radius, float startX, float startY, float dx, float dy) {
        this.balls.add(new Ball(radius, new Location(startX, startY), dx, dy));
    }

    public enum Mode { X, Y }

    List<Ball> sort(List<Ball> array, Mode mode) {
        Function<Ball, Double> getCoord = b -> getCoordOf(b, mode);
        return array.stream().sorted(Comparator.comparing(getCoord)).toList();
    }
}
