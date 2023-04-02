package Game;

import java.awt.*;

public class Case {
    public int x, y;
    public Color col;
    public String direction = "null";

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void changeCol(Color c) {
        this.col = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Case) {
            if (((Case) obj).x == this.x && ((Case) obj).y == this.y) {
                return true;
            }
        }
        return false;
    }
}
