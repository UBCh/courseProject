package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBDHelper;
import data.DataSeleKtor;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.PurchasePage;

import static com.codeborne.selenide.CollectionCondition.texts;
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

    @Before
    public void openPage(){
        open("http://185.119.57.9:8080");
        LoginPage.buyLoan();
        DataSeleKtor.getHeadingIpoteka().shouldBe(visible);}


    @Test
    @DisplayName("Покупка тура в кредит, одобрена банком.")
    void shouldIpotekaApproved() {

        DataSeleKtor.getoK().shouldBe(visible);
        var expected=  DataBDHelper.stubTest ();
        var actual = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура  кредит, отклонена банком.")
    void shouldIpotekaRejected() {
        PurchasePage.BuyPageSecond();
        DataSeleKtor.getError().shouldBe(visible);
        var expected=  DataBDHelper.stubTest ();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Покупка тура в кредит по несуществующей карте, отклонена банком.")
    void shouldIpotekaRejectedFake() {
        PurchasePage.FakerPage();
        DataSeleKtor.getError().shouldBe(visible);
        var expected=  DataBDHelper.stubTest ();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Покупка тура кредит, отправка пустой формы.")
    void shouldIpotekaZero() {
        PurchasePage.InvalidPageZero();
        DataSeleKtor.getNoteCardNumber().shouldBe(visible);
        DataSeleKtor.getNoteManth().shouldBe(visible);
        DataSeleKtor.getNoteYear().shouldBe(visible);
        DataSeleKtor.getNoteOwner().shouldBe(visible);
        DataSeleKtor.getNoteCVV().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, не валидный номер")
    void shouldIpotekaInvalidNumber() {
        PurchasePage.InvalidNumber();
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));

    }


    @Test
    @DisplayName("Покупка тура в кредит, не валидный месяц")
    void shouldIpotekaInvalidMonth() {
        PurchasePage.InvalidMonth();
        DataSeleKtor.getFormatManth().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, истек год")
    void shouldIpotekaInvalidYearExpired() {
        PurchasePage.InvalidYearBefore();
        DataSeleKtor.getFormatYearBefore().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, неправильный  год")
    void shouldIpotekaInvalidYearInCorrect() {
        PurchasePage.InvalidYearAfter();
        DataSeleKtor.getFormatYear().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит,  ввод неверного формата месяц и год")
    void shouldIpotekaYearMonthIncorrected() {
        PurchasePage.InvalidData();
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат", "Неверный формат"));
    }


    @Test
    @DisplayName("Покупка тура в кредит, некорректное имя")
    void shouldIpotekaInvalidNaimInCorrect() {
        PurchasePage.InvalidName();
        DataSeleKtor.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

     @Test
    @DisplayName("Покупка тура в кредит, некорректный CVV")
    void shouldIpotekaInvalidCVVInCorrect() {
         PurchasePage.InvalidCVV();
         DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }



}
