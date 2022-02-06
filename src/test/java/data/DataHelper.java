package data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

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


    //@Value
    //public static class CardInfo {
        //String cardNumber;
    //}




}
