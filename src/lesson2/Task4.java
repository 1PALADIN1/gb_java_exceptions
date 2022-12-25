package lesson2;

import java.util.Scanner;

/*
4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public void run() {
        System.out.println("======== TASK4 ========");

        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter string:");
                String input = in.nextLine();
                if (input.trim().isEmpty()) {
                    throw new RuntimeException("Input string can't be blank!");
                }

                System.out.println("Input string: " + input);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        in.close();
    }
}
