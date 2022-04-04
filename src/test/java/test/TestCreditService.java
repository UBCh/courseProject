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

public class TestCreditService {

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
         open("http://localhost:8080");
        StartPage.buyLoan();
        PurchasePage.getKredit();
    }


    @Test
    @DisplayName("Покупка тура в кредит, одобрена банком.")
    void shouldIpotekaApproved() {
        PageForm.fillingСardNumber(DataHelper.getFirstCardInfo());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getOk();
        var expected ="APPROVED" ;
        var actual = DataBDHelper.getCreditPurchaseStatus();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура  кредит карта №2, отклонена банком.")
    void shouldIpotekaRejected() {
        PageForm.fillingСardNumber(DataHelper.getSecondCardInfo());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getError();
        var expected = "DECLINED";
        var actual = DataBDHelper.getCreditPurchaseStatus();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Покупка тура в кредит по несуществующей карте, отклонена банком.")
    void shouldIpotekaRejectedFake() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getError();

    }


    @Test
    @DisplayName("Покупка тура кредит, отправка пустой формы.")
    void shouldIpotekaZero() {
        PageForm.buttonPress();
        PurchasePage.getNote();
    }

    @Test
    @DisplayName("Покупка тура в кредит, не валидный номер")
    void shouldIpotekaInvalidNumber() {
        PageForm.fillingСardNumber(InvalidDataGenerator.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteNumber();

    }


    @Test
    @DisplayName("Покупка тура в кредит, не валидный месяц")
    void shouldIpotekaInvalidMonth() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(InvalidDataGenerator.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteManth();
    }

    @Test
    @DisplayName("Покупка тура в кредит, истек год")
    void shouldIpotekaInvalidYearExpired() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(InvalidDataGenerator.generateYearBefore());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteFormatYearBefore();
    }

    @Test
    @DisplayName("Покупка тура в кредит, неправильный  год")
    void shouldIpotekaInvalidYearInCorrect() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(InvalidDataGenerator.generateYearAfter());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteFormatYearAfter();
    }

    @Test
    @DisplayName("Покупка тура в кредит,  ввод неверного формата месяц и год")
    void shouldIpotekaYearMonthIncorrected() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(InvalidDataGenerator.generateMonthInCorrected());
        PageForm.fillingYear(InvalidDataGenerator.generateYearInCorrected());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidData();
    }


    @Test
    @DisplayName("Покупка тура в кредит, некорректное имя")
    void shouldIpotekaInvalidNaimInCorrect() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(InvalidDataGenerator.generateName());
        PageForm.fillingCVV(DataHelper.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidName();
    }

    @Test
    @DisplayName("Покупка тура в кредит, некорректный CVV")
    void shouldIpotekaInvalidCVVInCorrect() {
        PageForm.fillingСardNumber(DataHelper.generateNumber());
        PageForm.fillingMonth(DataHelper.generateMonth());
        PageForm.fillingYear(DataHelper.generateYearValidYear());
        PageForm.fillingOwner(DataHelper.generateName());
        PageForm.fillingCVV(InvalidDataGenerator.generateCVV());
        PageForm.buttonPress();
        PurchasePage.getNoteInvalidCVV();
    }


}
