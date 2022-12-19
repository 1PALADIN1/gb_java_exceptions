package lesson1;

/*
1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
public class Task1 {
    public void run() {
        System.out.println("======== TASK1 ========");

        try {
            divByZero();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            outOfRange();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            indexOfNullArray();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            throwException();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private int divByZero() {
        return 1 / 0;
    }

    private void outOfRange() {
        int[] arr = new int[2];
        int result = arr[10];
    }

    private void indexOfNullArray() {
        int[] arr = null;
        int result = arr[2];
    }

    private void throwException() {
        throw new RuntimeException("Test exception");
    }
}
