package lesson2;

import java.util.Scanner;

/*
1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public void run() {
        System.out.println("======== TASK1 ========");
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter float value:");
                String input = in.nextLine();
                float value = Float.parseFloat(input);

                System.out.println("Input float: " + value);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input string is not a float: " + e.getMessage());
            }
        }

        in.close();
    }
}
