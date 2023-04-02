package Game;

public class Fruit {
    public int x;
    public int y;
    public static int size;

    public Fruit(int size) {
        this.size = size;
        this.changePos();
    }

    public void changePos() {
        this.x = (int) (Math.random() * size);
        this.y = (int) (Math.random() * size);
    }
}