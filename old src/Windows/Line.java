package Windows;

import Graph.Location;

public record Line(Location loc1, Location loc2) {
    public double length() {
        return loc1.distanceTo(loc2);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Line line)) return false;
        return (loc1 == line.loc1 && loc2 == line.loc2) || (loc1 == line.loc2 && loc2 == line.loc1);
    }

    // Guarantees that a line from A to B is the same as B to A
    public static Line newLine(Location loc1, Location loc2) {
        return new Line((loc1.x() > loc2.x() ? loc1 : loc2), (loc1.x() < loc2.x() ? loc1 : loc2));
    }
}
