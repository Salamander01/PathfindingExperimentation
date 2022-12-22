package Windows;

import Misc.SimpleSet;

import java.awt.*;
import java.util.HashSet;

public class LineManager {
    private Graphics g;
    private SimpleSet<Line> set;
    private SimpleSet<Line> drawn;

    public void suggestLine(Line line) {
        if (!set.add(line)) {
            if (drawn.add(line)) draw(line);
        }
    }

    public void draw(Line line) {
        if (line.length() > 290) {
            System.err.println("Big line");
            return;
        }
        g.drawLine((int) line.loc1().x(), (int) line.loc1().y(), (int) line.loc2().x(), (int) line.loc2().y());
    }

    public LineManager(Graphics g) {
        this.g = g;
        this.set = new SimpleSet<>();
        this.drawn = new SimpleSet<>();
    }
}
