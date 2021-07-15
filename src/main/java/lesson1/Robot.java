package lesson1;

public class Robot implements CanRunJump {
    protected  int maxHeight;
    protected  int maxLength;
    protected  String name;


      public Robot(int maxHeight, int maxLength, String name) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void jump() {
        System.out.println("Робот прыгает");
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void run() {
        System.out.println("Робот бежит");
    }

    public String toString() {
        return "Робот " + name;
    }
}
