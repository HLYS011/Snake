package Game;

import java.util.ArrayList;

import Visual.Grid;

public class Snake {
    public Case head;
    public int snakeSize = 1;
    public ArrayList<Case> body = new ArrayList<Case>();

    public Snake() {
        head = new Case(4, 4);
        body.add(head);
    }

    public void inheritDir() {
        if (head.direction != "null") {
            for (int i = 0; i < body.size() - 1; i++) {
                body.get(i + 1).direction = body.get(i).direction;
            }
        }
    }

    public void moveSnake() {
        /*
         * System.out.println(body.size());
         * System.out.println(body.get(0).direction);
         * switch (body.get(0).direction) {
         * case "UP":
         * body.add(0, new Case(body.get(0).x, body.get(0).y - 1));
         * break;
         * case "RIGHT":
         * body.add(0, new Case(body.get(0).x + 1, body.get(0).y));
         * break;
         * case "DOWN":
         * body.add(0, new Case(body.get(0).x, body.get(0).y + 1));
         * break;
         * case "LEFT":
         * body.add(0, new Case(body.get(0).x - 1, body.get(0).y));
         * break;
         * 
         * }
         * System.out.println(body.get(0).direction + " " + body.get(body.size() -
         * 1).direction);
         * 
         * body.get(body.size() - 1).direction = body.get(0).direction;
         * body.remove(body.size() - 1);
         * System.out.println(body.size());
         */
        Case previous_head = body.get(body.size() - 1);
        // Créer la prochaine tête
        addTile();
        body.get(body.size() - 1).direction = previous_head.direction;
        // Supprimer l'ancienne
        body.remove(previous_head);
    }

    public void addTile() {
        switch (body.get(body.size() - 1).direction) {
            case "UP":
                body.add(new Case(body.get(body.size() - 1).x, body.get(body.size() - 1).y + 1));
                break;
            case "LEFT":
                body.add(new Case(body.get(body.size() - 1).x + 1, body.get(body.size() - 1).y));
                break;
            case "DOWN":
                body.add(new Case(body.get(body.size() - 1).x, body.get(body.size() - 1).y - 1));
                break;
            case "RIGHT":
                body.add(new Case(body.get(body.size() - 1).x - 1, body.get(body.size() - 1).y));
                break;
        }
    }
}
