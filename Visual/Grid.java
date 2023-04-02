package Visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Game.*;

public class Grid extends JComponent implements KeyListener {
    public static int size = 8;
    public Fruit f = new Fruit(size);
    public Case[][] grid = new Case[size][size];
    public static final int tileSize = 80;
    Snake s;

    public Grid() {
        s = new Snake();
    }

    public void initGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Case(i, j);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics gra) {

        gra.fillRect(0, 0, WIDTH, HEIGHT);
        Graphics2D gra2D = (Graphics2D) gra;
        gra2D.setStroke(new BasicStroke(10));
        gra.setColor(Color.white);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gra.fillRect(i * tileSize, j * tileSize, tileSize - 1, tileSize - 1);
            }
        }
        for (Case c : s.body) {
            if (c.equals(s.body.get(0))) {
                gra.setColor(new Color(0, 150, 0));
            } else {
                gra.setColor(Color.green);
            }
            gra.fillRect(c.x * tileSize, c.y * tileSize, tileSize - 1, tileSize - 1);
            gra.setColor(Color.WHITE);
        }
        gra.setColor(new Color(255, 0, 102));
        gra.fillRect(f.x * tileSize, f.y * tileSize, tileSize - 1, tileSize - 1);

        gra.setColor(Color.WHITE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 38:
                if (s.body.get(s.body.size() - 1).direction != "DOWN")
                    s.head.direction = "UP";
                break;
            case 37:
                if (s.body.get(s.body.size() - 1).direction != "RIGHT")
                    s.head.direction = "LEFT";
                break;
            case 40:
                if (s.body.get(s.body.size() - 1).direction != "UP")
                    s.head.direction = "DOWN";
                break;
            case 39:
                if (s.body.get(s.body.size() - 1).direction != "LEFT")
                    s.head.direction = "RIGHT";
                break;
        }
        s.moveSnake();
        s.inheritDir();
        checkFood();

        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(tileSize * size, tileSize * size);
    }

    public void checkFood() {
        if (s.head.x == f.x && s.head.y == f.y) {

            f.changePos();
            s.addTile();
        }

    }
}