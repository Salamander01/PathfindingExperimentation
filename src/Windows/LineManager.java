package Windows;

import java.awt.*;
import java.util.HashSet;

public class LineManager {
    private Graphics g;
    private HashSet<Line> set;
    private HashSet<Line> drawn;

    public LineManager(Graphics g) {
        this.g = g;
        this.set = new HashSet<>();
        this.drawn = new HashSet<>();
    }

    public void suggestLine(Line line) {
        if (!set.add(line) || !set.add(line.opposite())) {
            if (drawn.add(line) || drawn.add(line.opposite())) draw(line);
        }
    }

    public void draw(Line line) {
        if (line.length() > 280) {
            System.err.println("Big line");
            return;
        }
        g.drawLine((int) line.loc1().x(), (int) line.loc1().y(), (int) line.loc2().x(), (int) line.loc2().y());
    }
}
