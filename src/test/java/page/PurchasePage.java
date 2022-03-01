package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.DataSeleKtor;
import data.InvalidDataGenerator;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;

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

    public static void getOk() {
        DataSeleKtor.getoK().shouldBe(visible);
    }

    public static void getError() {
        DataSeleKtor.getError().shouldBe(visible);
    }

    public static void getNote() {
        DataSeleKtor.getNoteCardNumber().shouldBe(visible);
        DataSeleKtor.getNoteManth().shouldBe(visible);
        DataSeleKtor.getNoteYear().shouldBe(visible);
        DataSeleKtor.getNoteOwner().shouldBe(visible);
        DataSeleKtor.getNoteCVV().shouldBe(visible);
    }

    public static void getNoteNumber() {
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }

    public static void getNoteManth() {
        DataSeleKtor.getFormatManth().shouldBe(visible);
    }

    public static void getNoteFormatYearBefore() {
        DataSeleKtor.getFormatYearBefore().shouldBe(visible);
    }

    public static void getNoteFormatYearAfter() {
        DataSeleKtor.getFormatYear().shouldBe(visible);
    }

    public static void getNoteInvalidData() {
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат", "Неверный формат"));
    }

    public static void getNoteInvalidName() {
        DataSeleKtor.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

    public static void getNoteInvalidCVV() {
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }

}

