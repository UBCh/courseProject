package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestService {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Before
    public void clearCache() {
        clearBrowserCache();
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, одобрена банком.")
    void shouldPurchaseApproved() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
       LoginPage.buyPage();
       var expected = SeleKtorPage.getoK().shouldBe(visible);
        //var expected2=  DBPage.stubTest ();
        //var actual2 = "APPROVED";
        //assertEquals(expected2, actual2);
          }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, отклонена банком.")
    void shouldPurchaseRejected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginPage.BuyPage2();
        var expected = SeleKtorPage.getError().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, одобрена банком.")
    void shouldIpotekaApproved() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginPage.buyPage();
        var expected = SeleKtorPage.getoK().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура  кредит, отклонена банком.")
    void shouldIpotekaRejected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginPage.BuyPage2();
        var expected = SeleKtorPage.getError().shouldBe(visible);
    }
    @Test
    @DisplayName("Покупка тура по дебетовой несуществующей карте, отклонена банком.")
    void shouldPurchaseRejectedFake() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginPage.FakerPage();
        // var newNumber = SeleKtorPage.getCardNumber().getText();
        //var expected2 =BDPageFaker.stubTest();
        //var expected = SeleKtorPage.getError().shouldBe(visible);
       //var actual2 = "DECLINED";
        //assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Покупка тура в кредит по несуществующей карте, отклонена банком.")
    void shouldIpotekaRejectedFake() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginPage.FakerPage();
        var expected = SeleKtorPage.getError().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой  карте, отправка пустой формы.")
    void shouldPurchaseZero() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidPageZero();
        var expected1 = SeleKtorPage.getNoteCardNumber().shouldBe(visible);
        var expected2 = SeleKtorPage.getNoteManth().shouldBe(visible);
        var expected3 = SeleKtorPage.getNoteYear().shouldBe(visible);
        var expected4 = SeleKtorPage.getNoteOwner().shouldBe(visible);
        var expected5 = SeleKtorPage.getNoteCVV().shouldBe(visible);

    }
    @Test
    @DisplayName("Покупка тура кредит, отправка пустой формы.")
    void shouldIpotekaZero() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidPageZero();
        var expected1 = SeleKtorPage.getNoteCardNumber().shouldBe(visible);
        var expected2 = SeleKtorPage.getNoteManth().shouldBe(visible);
        var expected3 = SeleKtorPage.getNoteYear().shouldBe(visible);
        var expected4 = SeleKtorPage.getNoteOwner().shouldBe(visible);
        var expected5 = SeleKtorPage.getNoteCVV().shouldBe(visible);

    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный номер")
    void shouldPurchaseInvalidNumber() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidNumber();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат"));
    }

    @Test
    @DisplayName("Покупка тура в кредит, не валидный номер")
    void shouldIpotekaInvalidNumber() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidNumber();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат"));
    }
    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный месяц")
    void shouldPurchaseInvalidMonth() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidMonth();
        var expected = SeleKtorPage.getFormatManth().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, не валидный месяц")
    void shouldIpotekaInvalidMonth() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidMonth();
        var expected = SeleKtorPage.getFormatManth().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, истек год")
    void shouldPurchaseInvalidYearExpired() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidYearBefore();
        var expected = SeleKtorPage.getFormatYearBefore().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура в кредит, истек год")
    void shouldIpotekaInvalidYearExpired() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidYearBefore();
        var expected = SeleKtorPage.getFormatYearBefore().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, неправильный  год")
    void shouldPurchaseInvalidYearIncorrected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidYearAfter();
        var expected = SeleKtorPage.getFormatYear().shouldBe(visible);
    }


    @Test
    @DisplayName("Покупка тура в кредит, неправильный  год")
    void shouldIpotekaInvalidYearInCorrect() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidYearAfter();
        var expected = SeleKtorPage.getFormatYear().shouldBe(visible);
    }
    @Test
    @DisplayName("Покупка тура по дебетовой карте, ввод неверного формата месяц и год")
    void shouldPurchaseYearMonthIncorrected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidData();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат","Неверный формат"));
    }


    @Test
    @DisplayName("Покупка тура в кредит,  ввод неверного формата месяц и год")
    void shouldIpotekaYearMonthIncorrected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidData();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат","Неверный формат"));
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректное имя ")
    void shouldPurchaseInvalidNaimIncorrected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidName();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

    @Test
    @DisplayName("Покупка тура в кредит, некорректное имя")
    void shouldIpotekaInvalidNaimInCorrect() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidName();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректный CVV ")
    void shouldPurchaseInvalidCVVIncorrected() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonBuy().click();
        SeleKtorPage.getHeadingBuy().shouldBe(visible);
        LoginInvalidPage.InvalidCVV();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат"));
    }

    @Test
    @DisplayName("Покупка тура в кредит, некорректный CVV")
    void shouldIpotekaInvalidCVVInCorrect() {
        open("http://localhost:8080");
        SeleKtorPage.getButtonLoan().click();
        SeleKtorPage.getHeadingIpoteka().shouldBe(visible);
        LoginInvalidPage.InvalidCVV();
        var expected = SeleKtorPage.getNote().shouldBe(texts("Неверный формат"));
    }


}
