package Windows.Elements;

import Graph.Location;

public class Ball {
    private final double radius;
    private final double diameter;

    private Location loc;

    private double dx;
    private double dy;

    public Ball(double radius, Location loc, double dx, double dy) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.loc = loc;
        this.dx = dx;
        this.dy = dy;
    }

    public void update(int width, int height) {
        double x = loc.x() + dx;
        double y = loc.y() + dy;

        if (loc.x() - radius < 0) {
            dx = -dx;
            x = radius;
        } else if (x + radius > width) {
            dx = -dx;
            x = width - radius;
        }

        if (y - radius < 0) {
            dy = -dy;
            y = radius;
        } else if (y + radius > height) {
            dy = -dy;
            y = height - radius;
        }

        this.loc = new Location(x, y);
    }

    public Location getLoc() { return this.loc; }

    public double getRadius() {
        return this.radius;
    }

    public double getDiameter() {
        return this.diameter;
    }
}
