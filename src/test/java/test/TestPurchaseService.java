package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBDHelper;
import data.DataHelper;
import data.InvalidDataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.PageForm;
import page.PurchasePage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPurchaseService {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openPage() {
        open (System.getProperty("sql.http"));
        StartPage.buyPage();
        PurchasePage.getDebet();
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, одобрена банком.")
    void shouldPurchaseApproved() {
        PageForm.fillingСardNumber(DataHelper.getFirstCardInfo());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getOk();
        var expected = "APPROVED";
        var actual = DataBDHelper.getDebitPurchaseStatus();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте №2, отклонена банком.")
    void shouldPurchaseRejected() {
        PageForm.fillingСardNumber(DataHelper.getSecondCardInfo());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getError();
        var expected = "DECLINED";
        var actual = DataBDHelper.getDebitPurchaseStatus();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой несуществующей карте, отклонена банком.")
    void shouldPurchaseRejectedFake() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getError();

    }

    @Test
    @DisplayName("Покупка тура по дебетовой  карте, отправка пустой формы.")
    void shouldPurchaseZero() {
        PageForm.buttonPress();
        PurchasePage.getNote();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный номер")
    void shouldPurchaseInvalidNumber() {
        PageForm.fillingСardNumber(InvalidDataGenerator.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteNumber();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный месяц")
    void shouldPurchaseInvalidMonth() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(InvalidDataGenerator.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteManth();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, истек год")
    void shouldPurchaseInvalidYearExpired() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(InvalidDataGenerator.generateYearBefore());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteFormatYearBefore();
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, неправильный  год")
    void shouldPurchaseInvalidYearIncorrected() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(InvalidDataGenerator.generateYearAfter());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteFormatYearAfter();
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, ввод неверного формата месяц и год")
    void shouldPurchaseYearMonthIncorrected() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(InvalidDataGenerator.generateMonthInCorrected());
        PageForm.fillingYear(InvalidDataGenerator.generateYearInCorrected());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidData();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректное имя ")
    void shouldPurchaseInvalidNaimIncorrected() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(InvalidDataGenerator.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidName();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректный CVV ")
    void shouldPurchaseInvalidCVVIncorrected() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(InvalidDataGenerator.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidCVV();
    }


}
