package lesson1;

public class Wall implements Obstaclable {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean toRun(int maxLength) {
        return false;
    }

    public boolean toJump(int maxHeight) {
        return (maxHeight >= height);
    }

    public String toString() {
        return "преодолеть стену высотой " + height + " м";
    }
}
