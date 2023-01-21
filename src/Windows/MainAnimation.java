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

    public final boolean DARK_MODE;

    private final ArrayList<Ball> balls;

    public MainAnimation(boolean darkMode) {
        this.balls = new ArrayList<>();

        this.DARK_MODE = darkMode;

        setBackground(this.DARK_MODE ? Color.BLACK : Color.WHITE);

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
        int width = getWidth();
        int height = getHeight();

        for (Ball ball : balls) {
            ball.step(width, height);
        }

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            // xSorted and ySorted are broken optimization stuff
//            xSorted = (ArrayList<Ball>) sort(xSorted, Mode.X);
            LineManager manager = new LineManager(g);
            findNearBalls(manager, sort(balls, Axis.X), Axis.X);
//            ySorted = (ArrayList<Ball>) sort(ySorted, Mode.Y);
            findNearBalls(manager, sort(balls, Axis.Y), Axis.Y);

            g.setColor(this.DARK_MODE ? Color.WHITE : Color.BLACK);
            g.fillOval((int)(ball.getX() - ball.getRadius()), (int)(ball.getY() - ball.getRadius()), (int) ball.getDiameter(), (int) ball.getDiameter());
        }
    }

    private void findNearBalls(LineManager lineManager, List<Ball> list, Axis axis) {
        for (int i = 0; i < list.size() - 2; i++) {
            int j = i + 1;
            while ((getCoordOf(list.get(j), axis) - getCoordOf(list.get(i), axis)) < CLOSE_LINE_TOLERANCE) {
                lineManager.suggestLine(Line.newLine(list.get(i).getLoc(), list.get(j).getLoc()));
                j++;
                if (j > list.size() - 1) break;
            }
        }
    }

    private double getCoordOf(Ball ball, Axis axis) {
        return switch (axis) {
            case X -> ball.getX();
            case Y -> ball.getY();
        };
    }

    public void addBall(float radius, float startX, float startY, float dx, float dy) {
        this.balls.add(new Ball(radius, new Location(startX, startY), dx, dy));
    }
    public enum Axis { X, Y }

    List<Ball> sort(List<Ball> array, Axis axis) {
        Function<Ball, Double> getCoord = b -> getCoordOf(b, axis);
        return array.stream().sorted(Comparator.comparing(getCoord)).toList();
    }
}
