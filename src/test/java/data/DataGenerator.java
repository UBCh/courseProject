package data;
import com.github.javafaker.Faker;
import lombok.Value;
//import page.BDPageFaker;
//import page.DBPage;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateNumber() {
        String number = faker.business().creditCardNumber();
       // BDPageFaker.setUp(number);
        return number;
    }

    // генерируем валидный срок дейстия карты
    public static String generateYearValidYear() {
      int cYear =LocalDate.now (). getYear ();
      int i = faker.number().numberBetween(0,4);
        String year = String.valueOf( cYear -2000 + i);

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
        String month = String.valueOf(faker.number().numberBetween(10,12));
        return month;
    }

   // public static class Registration {

    // private Registration() {
      //  }

       // public static UserInfo generateUser() {

           // return new UserInfo(generateNumber(), generateName(), generateMonth(), generateCVV(), generateYearValidYear());
       // }

    //}

    //@Data
    //@RequiredArgsConstructor
    @Value
    public static class UserInfo {
        String number;
        String name;
        String month;
        String cvv;
        String year;

    }

}
