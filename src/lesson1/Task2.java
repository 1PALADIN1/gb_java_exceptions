package lesson1;

/*
2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 */
public class Task2 {
    public void run() {
        String[][] arr = new String[2][5];
        sum2d(arr);
    }

    // 1. arr может быт null - тогда будет NullPointer исключение
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // 2. Так как двумерный массив - массив массивов, то один из вложенных массивов может быть null (получим снова NullPointer)
            // 3. Если размер массива меньше 4, то обратимся к несущствующем индексу (OutOfBounds исключение)
            for (int j = 0; j < 5; j++) {
                // 4. Необработанное исключение - если parseInt не смог распарсить строку, то он бросит исключение NumberFormat
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }

        return sum;
    }
}
