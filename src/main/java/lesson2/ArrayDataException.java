package lesson2;

public class ArrayDataException extends Exception {
    public int i;
    public int j;

    ArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
