package lesson1;

/*
3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
необходимо как-то оповестить пользователя.
 */
public class Task3 {
    public void run() {
        System.out.println("======== TASK3 ========");

        try {
            int[] result = merge(new int[] { 1, 2, 3, 4}, new int[] { 4, 3, 2, 1});
            System.out.print("Result: ");
            for (int el : result) {
                System.out.print(el + " ");
            }
            System.out.println();

            merge(new int[] { 1, 2, 3, 4}, new int[] { 4, 3 });
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private int[] merge(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length) {
            throw new RuntimeException("Array sizes are not equal!");
        }

        int[] result = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            result[i] = arrA[i] - arrB[i];
        }

        return result;
    }
}
