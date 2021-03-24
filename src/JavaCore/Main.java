package JavaCore;

public class Main {

    public static void main(String[] args) {
        String[][] array1 = {
                {"1", "2"},
                {"3", "4"}
        };
        try {
            int sum = arraySum(array1);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"5", ":)", "7", "8"},
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"}
        };
        try {
            int sum = arraySum(array2);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        String[][] array3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };
        try {
            int sum = arraySum(array3);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
    private final static int ARRAY_SIZE = 4;

    public static int arraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException(ARRAY_SIZE);
        }
        for (String[] col:array) {
            if (col.length != ARRAY_SIZE) {
                throw new MyArraySizeException(ARRAY_SIZE);
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }


    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(int size) {
            super("Ожидается массив размера - " + size + "x" + size);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int i, int j, String value) {
            super("Элемент с координатами (" + i + "," + j + ") не является числом - " + value);
        }
    }
}
