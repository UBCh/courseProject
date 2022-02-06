package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;
import data.DataInvalidGenerator;

import static java.lang.Thread.sleep;

public class LoginInvalidPage {

     private LoginInvalidPage() {}
    private static SelenideElement cardNumber = SeleKtorPage.getCardNumber();
    private static SelenideElement month = SeleKtorPage.getMonth();
    private static SelenideElement year = SeleKtorPage.getYear();
    private static SelenideElement owner = SeleKtorPage.getOwner();
    private static SelenideElement cvv = SeleKtorPage.getCvv();


    private static SelenideElement buttonBuy = SeleKtorPage.getButtonBuy();
    private static SelenideElement buttonLoan = SeleKtorPage.getButtonLoan();
    private static SelenideElement buttonContinue = SeleKtorPage.getButtonContinue();

    public static void InvalidNumber() {
        cardNumber.setValue(DataInvalidGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }

    public static  void InvalidMonth () {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataInvalidGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }

    private static class InvalidMonth {
    }
    public static   void InvalidYearBefore ( ) {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataInvalidGenerator.generateYearBefore());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }


    public static  void InvalidYearAfter ( ) {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataInvalidGenerator.generateYearAfter());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }


    public static  void InvalidName () {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataInvalidGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }


    public static void InvalidCVV () {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataGenerator.generateMonth());
        year.setValue(DataGenerator.generateYearValidYear());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataInvalidGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }


    public static void InvalidPageZero () {
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }

   // ввод месяца и года не правильный формат ввода

    public static void InvalidData() {
        cardNumber.setValue(DataGenerator.generateNumber());
        month.setValue(DataInvalidGenerator.generateMonthInCorrected());
        year.setValue(DataInvalidGenerator.generateYearInCorrected());
        owner.setValue(DataGenerator.generateName());
        cvv.setValue(DataGenerator.generateCVV());
        buttonContinue.click();
        Selenide.sleep(7000);
        return ;
    }

}
