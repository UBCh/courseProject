package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;

public class InvalidDataGenerator {
    private InvalidDataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    // получаем не валидный номер карты
    public static String generateNumber() {
        String number = faker.number().digits(10);
        return number;
    }

    // генерируем  значение года действия карты, истекшего
    public static String generateYearBefore() {
        int cYear = LocalDate.now().getYear();
        int i = faker.number().numberBetween(1, 4);
        String yearBefor = String.valueOf(cYear - 2000 - i);
        return yearBefor;
    }

    // генерируем  значение года действия карты, больше возможного срока
    public static String generateYearAfter() {
        int cYear = LocalDate.now().getYear();
        int i = faker.number().numberBetween(5, 99);
        String yearAfter = String.valueOf(cYear - 2000 + i);
        return yearAfter;
    }

    //генерируем не валидное имя
    public static String generateName() {
        String name = faker.number().digits(6);
        return name;
    }

    // генерируем не валидный CVV
    public static String generateCVV() {
        String cvv = faker.number().digits(2);
        return cvv;
    }
    //генерируем не валидный месяц

    public static String generateMonth() {
        String month = String.valueOf(faker.number().numberBetween(13, 99));
        return month;
    }

    public static String generateMonthInCorrected() {
        String month = String.valueOf(faker.number().numberBetween(0, 9));
        return month;
    }

    public static String generateYearInCorrected() {
        String yearIC = String.valueOf(faker.number().numberBetween(0, 9));
        return yearIC;
    }

    @Value
    public static class UserInvalid {
        String number;
        String name;
        String month;
        String cvv;
        String yearBefor;
        String yearAfter;


    }

}
