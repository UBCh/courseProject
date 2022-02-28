package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBDHelper;
import data.DataSeleKtor;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.LoginPage;
import page.PurchasePage;

import static com.codeborne.selenide.Condition.visible;
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
    public void openPage(){
        open("http://localhost:8080");
        LoginPage.buyLoan();
        DataSeleKtor.getHeadingIpoteka().shouldBe(visible);}


    @Test
    @DisplayName("Покупка тура в кредит, одобрена банком.")
    void shouldIpotekaApproved() {
        PurchasePage.buyPageFirst();
        PurchasePage.getOk();
        var expected=  DataBDHelper.stubTest ();
        var actual = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура  кредит, отклонена банком.")
    void shouldIpotekaRejected() {
        PurchasePage.BuyPageSecond();
      PurchasePage.getError();
        var expected=  DataBDHelper.stubTest ();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Покупка тура в кредит по несуществующей карте, отклонена банком.")
    void shouldIpotekaRejectedFake() {
        PurchasePage.FakerPage();
       PurchasePage.getError();
        var expected=  DataBDHelper.stubTest ();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Покупка тура кредит, отправка пустой формы.")
    void shouldIpotekaZero() {
        PurchasePage.InvalidPageZero();
        PurchasePage.getNote();
    }

    @Test
    @DisplayName("Покупка тура в кредит, не валидный номер")
    void shouldIpotekaInvalidNumber() {
        PurchasePage.InvalidNumber();
       PurchasePage.getNoteNumber();

    }


    @Test
    @DisplayName("Покупка тура в кредит, не валидный месяц")
    void shouldIpotekaInvalidMonth() {
        PurchasePage.InvalidMonth();
       PurchasePage.getNoteManth();
    }

    @Test
    @DisplayName("Покупка тура в кредит, истек год")
    void shouldIpotekaInvalidYearExpired() {
        PurchasePage.InvalidYearBefore();
       PurchasePage.getNoteFormatYearBefore();
    }

    @Test
    @DisplayName("Покупка тура в кредит, неправильный  год")
    void shouldIpotekaInvalidYearInCorrect() {
        PurchasePage.InvalidYearAfter();
       PurchasePage.getNoteFormatYearBefore();
    }

    @Test
    @DisplayName("Покупка тура в кредит,  ввод неверного формата месяц и год")
    void shouldIpotekaYearMonthIncorrected() {
        PurchasePage.InvalidData();
       PurchasePage.getNoteInvalidData();
    }


    @Test
    @DisplayName("Покупка тура в кредит, некорректное имя")
    void shouldIpotekaInvalidNaimInCorrect() {
        PurchasePage.InvalidName();
        PurchasePage.getNoteInvalidName();
    }

     @Test
    @DisplayName("Покупка тура в кредит, некорректный CVV")
    void shouldIpotekaInvalidCVVInCorrect() {
         PurchasePage.InvalidCVV();
        PurchasePage.getNoteInvalidCVV();
    }



}
