package Game;

public class Fruit {
    public int x;
    public int y;
    public int size;

    public Fruit(int size) {
        this.changePos();
    }

    public void changePos() {
        this.x = (int) (Math.random() * 8);
        this.y = (int) (Math.random() * 8);
    }
}