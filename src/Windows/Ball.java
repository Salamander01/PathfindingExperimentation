package Windows;

import Graph.Location;

class Ball {
    private float radius;
    private float diameter;

    private Location loc;

    private float dx;
    private float dy;

    public Ball(float radius, Location loc, float dx, float dy) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.loc = loc;
        this.dx = dx;
        this.dy = dy;
    }

    protected void step(int width, int height) {
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

    protected Location getLoc() { return this.loc; }

    protected double getX() {
        return this.loc.x();
    }

    protected double getY() {
        return this.loc.y();
    }

    protected float getRadius() {
        return this.radius;
    }

    protected float getDiameter() {
        return this.diameter;
    }
}
