package lesson3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final Date birthdate;
    private final long phone;
    private final Sex sex;

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public User(String firstName, String lastName, String patronymic, Date birthdate, long phone, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phone = phone;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "<" + lastName + "><" + firstName + "><" + patronymic + "><"
                + formatter.format(birthdate) + "><" + phone + "><" + sex + ">";
    }
}
