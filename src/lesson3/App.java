package lesson3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
- фамилия, имя, отчество - строки
- дата_рождения - строка формата dd.mm.yyyy
- номер_телефона - целое беззнаковое число без форматирования
- пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
 */
public class App {
    private final int TOTAL_FIELDS = 6;
    private final int PHONE_NUMBER_LENGTH = 11;

    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter user data:");
                String[] input = parseInput(in.nextLine());
                User user = createUser(input);
                writeUserToFile(user);

                System.out.println("User created: " + user);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid input birthdate: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        in.close();
    }

    private String[] parseInput(String input) throws RuntimeException {
        input = input.trim();
        if (input.isEmpty()) {
            throw new RuntimeException("Input string can't be blank!");
        }

        // example: Михайлов Михаил Михайлович 20.01.1993 89008007060 m
        String[] fields = input.split(" ");
        if (fields.length < TOTAL_FIELDS) {
            throw new RuntimeException("Input args can't be less then " + TOTAL_FIELDS);
        }

        if (fields.length > TOTAL_FIELDS) {
            throw new RuntimeException("Input args can't be greater then " + TOTAL_FIELDS);
        }

        return fields;
    }

    private User createUser(String[] input) throws RuntimeException, ParseException {
        String lastName = input[0];
        String firstName = input[1];
        String patronymic = input[2];

        if (!validateName(lastName)) {
            throw new RuntimeException("User's last name contains invalid character!");
        }
        if (!validateName(firstName)) {
            throw new RuntimeException("User's first name contains invalid character!");
        }
        if (!validateName(patronymic)) {
            throw new RuntimeException("User's patronymic contains invalid character!");
        }

        // date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);
        Date birthdate = formatter.parse(input[3]);

        // phone
        if (input[4].length() != PHONE_NUMBER_LENGTH) {
            throw new RuntimeException("Invalid phone number length! Required: " + PHONE_NUMBER_LENGTH);
        }
        long phone;
        try {
            phone = Long.parseLong(input[4]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input phone number: " + e.getMessage());
        }

        // configure sex
        if (input[5].length() != 1) {
            throw new RuntimeException("Invalid input sex param! Must be length of 1");
        }

        Sex sex = switch (input[5].toLowerCase()) {
            case "m" -> Sex.M;
            case "f" -> Sex.F;
            default -> throw new RuntimeException("Unsupported sex type!");
        };

        return new User(firstName, lastName, patronymic, birthdate, phone, sex);
    }

    private boolean validateName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i)))
                return false;
        }

        return true;
    }

    private void writeUserToFile(User user) {
        // TODO: implement
    }
}
