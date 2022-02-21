package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.DataSeleKtor;
import data.InvalidDataGenerator;

public class PurchasePage {

    private PurchasePage() {
    }

    private static SelenideElement cardNumber = DataSeleKtor.getCardNumber();
    private static SelenideElement month = DataSeleKtor.getMonth();
    private static SelenideElement year = DataSeleKtor.getYear();
    private static SelenideElement owner = DataSeleKtor.getOwner();
    private static SelenideElement cvv = DataSeleKtor.getCvv();

    private static SelenideElement buttonContinue = DataSeleKtor.getButtonContinue();

    public static void buyPageFirst() {
        cardNumber.setValue(String.valueOf(DataHelper.getFirstCardInfo()));
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);


    }

    public static void BuyPageSecond() {
        cardNumber.setValue(String.valueOf(DataHelper.getSecondCardInfo()));
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }

    public static void FakerPage() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);
    }

    public static void InvalidNumber() {
        cardNumber.setValue(InvalidDataGenerator.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }

    public static void InvalidMonth() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(InvalidDataGenerator.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }

    public static void InvalidYearBefore() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(InvalidDataGenerator.generateYearBefore());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }


    public static void InvalidYearAfter() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(InvalidDataGenerator.generateYearAfter());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }


    public static void InvalidName() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(InvalidDataGenerator.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }


    public static void InvalidCVV() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(DataHelper.generateMonth());
        year.setValue(DataHelper.generateYearValidYear());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(InvalidDataGenerator.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);
    }


    public static void InvalidPageZero() {
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }

    // ввод месяца и года не правильный формат ввода

    public static void InvalidData() {
        cardNumber.setValue(DataHelper.generateNumber());
        month.setValue(InvalidDataGenerator.generateMonthInCorrected());
        year.setValue(InvalidDataGenerator.generateYearInCorrected());
        owner.setValue(DataHelper.generateName());
        cvv.setValue(DataHelper.generateCVV());
        buttonContinue.click();
        // $(byText("Путешествие дня")).shouldBe(visible, Duration.ofMillis(30000));
        Selenide.sleep(20000);

    }

}
