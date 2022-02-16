package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;

public class DataHelper {

    public DataHelper() {
    }

       public static String getFirstCardInfo() {
           String cardNumberFirst ="4444 4444 4444 4441";
        return cardNumberFirst;
    }

    public static String getSecondCardInfo() {
         String cardNumberSecond ="4444 4444 4444 4442";
        return cardNumberSecond;
    }


    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateNumber() {
        String number = faker.business().creditCardNumber();
         return number;
    }

    // генерируем валидный срок дейстия карты
    public static String generateYearValidYear() {
        int cYear = LocalDate.now().getYear();
        int i = faker.number().numberBetween(0, 4);
        String year = String.valueOf(cYear - 2000 + i);

        return year;
    }

    //генерируем имя
    public static String generateName() {
        String name = faker.name().lastName();
        return name;
    }

    // генерируем CVV
    public static String generateCVV() {
        String cvv = faker.number().digits(3);
        return cvv;
    }

    //генерируем месяц
    public static String generateMonth() {
        String month = String.valueOf(faker.number().numberBetween(10, 12));
        return month;
    }

    @Value
    public static class UserInfo {
        String number;
        String name;
        String month;
        String cvv;
        String year;

    }


}
