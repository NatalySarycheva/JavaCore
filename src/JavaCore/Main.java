package JavaCore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] array1 = {"Вася"};
        try {
            swapElements(array1, 2,4);
        } catch (SwapElementsException e) {
            System.out.println(e.getMessage());
        }

        Integer[] array2 = {5, 3, 8, 15};
        try {
            swapElements(array2, -1,15);
        } catch (SwapElementsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(array2));

        try {
            swapElements(array2, 2,3);
        } catch (SwapElementsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(array2));
    }

    private static <T extends Object> void swapElements(T[] array, int idx1, int idx2) throws SwapElementsException {
        if (array.length < 2) {
            throw new InvalidArraySizeException();
        }

        if (idx1 < 0 || idx1 >= array.length || idx2 < 0 || idx2 >= array.length) {
            throw new IndexOutOfRangeException(array.length);
        }

        if (idx1 == idx2) {
            return;
        }

        T temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    private static class SwapElementsException extends Exception {
        SwapElementsException(String msg){
            super(msg);
        }
    }

    private static class InvalidArraySizeException extends SwapElementsException {
        InvalidArraySizeException() {
            super("Размер массива должен быть больше 1");
        }
    }

    private static class IndexOutOfRangeException extends SwapElementsException {
        IndexOutOfRangeException(int length) {
            super("Индексы должны быть больше или равны 0 и меньше " + (length - 1));
        }
    }
}
