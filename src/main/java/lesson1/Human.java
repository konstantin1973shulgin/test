package lesson1;

public class Human implements CanRunJump {
    protected   String name;
    protected  int maxHeight;
    protected  int maxLength;


    public Human( int maxHeight,  int maxLength, String name) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;

    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void jump() {
        System.out.println("Человек прыгает");
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void run() {
        System.out.println("Человек бежит ");
    }

    public String toString() {
        return "Человек по имени " + name;
    }
}