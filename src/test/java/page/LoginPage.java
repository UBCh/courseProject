package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;
import data.DataHelper;
import lombok.SneakyThrows;
import lombok.val;
import static java.lang.Thread.sleep;


import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class LoginPage {

    public LoginPage() {
    }

    private static SelenideElement cardNumber = SeleKtorPage.getCardNumber();
    private static SelenideElement month = SeleKtorPage.getMonth();
    private static SelenideElement year = SeleKtorPage.getYear();
    private static SelenideElement owner = SeleKtorPage.getOwner();
    private static SelenideElement cvv = SeleKtorPage.getCvv();


    private static SelenideElement buttonBuy = SeleKtorPage.getButtonBuy();
    private static SelenideElement buttonLoan = SeleKtorPage.getButtonLoan();
    private static SelenideElement buttonContinue = SeleKtorPage.getButtonContinue();


    public static void buyPage() {
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardInfo()));
       // Selenide.sleep(5000);
        month.setValue(DataGenerator.generateMonth());
        //Selenide.sleep(5000);
        year.setValue(DataGenerator.generateYearValidYear());
        //Selenide.sleep(5000);
        owner.setValue(DataGenerator.generateName());
        //Selenide.sleep(5000);
        cvv.setValue(DataGenerator.generateCVV());
       // Selenide.sleep(5000);
        buttonContinue.click();
        Selenide.sleep(7000);
        return;
    }

    public static class BuyPage {

    }
    public static void BuyPage2() {
        cardNumber.setValue(String.valueOf(DataHelper.getSecondCardInfo()));
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return;
    }

    public static class BuyPage2 {

    }


    public static void FakerPage () {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }

    private static class FakerPage {
    }

}

