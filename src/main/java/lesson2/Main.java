package lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "4"}
        };
        try {
            try {
                int result = method(arr);
                System.out.println(getcalculate(result));
            } catch (ArraySizeException e) {
                System.out.println("Неверный размер массива!");
            }
        }
        catch (ArrayDataException e) {
            System.out.println("Не число в массиве: " + getcalculate(e.i) + "," + getcalculate(e.j));
        }

    }

    public static int method(String[][] arr) throws ArraySizeException, ArrayDataException {
        int calculate = 0;
        if (getcalculate(arr.length) != 4) {
            throw new ArraySizeException();
        }
        for (int i = 0; getcalculate(i) < getcalculate(arr.length); i++) {
            if (getcalculate(arr[i].length) != 4) {
                throw new ArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    calculate +=  Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j);
                }
            }

        }
        return calculate;
    }

    private static int getcalculate(int calculate) {
        return calculate;
    }
}

