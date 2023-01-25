package Graph;

public record Location(double x, double y) {
    public double distanceTo(Location other) {
        return Math.sqrt(Math.pow(other.x - x(), 2F) + Math.pow(other.y - y(), 2F));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location loc)) return false;
        return this.x() == loc.x() && this.y() == loc.y();
    }
}