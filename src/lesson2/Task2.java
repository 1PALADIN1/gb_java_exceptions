package lesson2;

/*
2. Если необходимо, исправьте данный код
(задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */
public class Task2 {
    public void run() {
        System.out.println("======== TASK2 ========");

//        int[] intArray = null;
//        int[] intArray = new int[]{ 1, 2, 3, 4, 5 };
        int[] intArray = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException e) {
            System.out.println("Catching NullPointerException: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching ArrayIndexOutOfBoundsException: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching ArithmeticException: " + e);
        }
    }
}
