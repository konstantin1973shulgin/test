package lesson1;

public class Cat implements CanRunJump {
    protected  int maxHeight;
    protected  int maxLength;
    protected  String name;

    public Cat(int maxHeight, int maxLength, String name) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;

    }



    public int getMaxHeight() {
        return maxHeight;
    }

    public void jump() {
        System.out.println("Кот бежит");
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void run() {
        System.out.println("Кот прыгает");
    }

    public String toString() {
        return "Кот по кличке " + name;
    }
}

