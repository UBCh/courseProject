package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataBDHelper;
import data.DataSeleKtor;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.LoginPage;
import page.PurchasePage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
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
        open("http://localhost:8080");
        LoginPage.buyPage();
        DataSeleKtor.getHeadingBuy().shouldBe(visible);
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, одобрена банком.")
    void shouldPurchaseApproved() {
        PurchasePage.buyPageFirst();
        DataSeleKtor.getoK().shouldBe(visible);
       var expected = DataBDHelper.stubTest();
        var actual = "APPROVED";
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, отклонена банком.")
    void shouldPurchaseRejected() {
        PurchasePage.BuyPageSecond();
        DataSeleKtor.getError().shouldBe(visible);
        var expected = DataBDHelper.stubTest();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой несуществующей карте, отклонена банком.")
    void shouldPurchaseRejectedFake() {
        PurchasePage.FakerPage();
        DataSeleKtor.getError().shouldBe(visible);
        var expected = DataBDHelper.stubTest();
        var actual = "DECLINED";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой  карте, отправка пустой формы.")
    void shouldPurchaseZero() {
        PurchasePage.InvalidPageZero();
        DataSeleKtor.getNoteCardNumber().shouldBe(visible);
        DataSeleKtor.getNoteManth().shouldBe(visible);
        DataSeleKtor.getNoteYear().shouldBe(visible);
        DataSeleKtor.getNoteOwner().shouldBe(visible);
        DataSeleKtor.getNoteCVV().shouldBe(visible);

    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный номер")
    void shouldPurchaseInvalidNumber() {
        PurchasePage.InvalidNumber();
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));

    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный месяц")
    void shouldPurchaseInvalidMonth() {
        PurchasePage.InvalidMonth();
        DataSeleKtor.getFormatManth().shouldBe(visible);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, истек год")
    void shouldPurchaseInvalidYearExpired() {
        PurchasePage.InvalidYearBefore();
        DataSeleKtor.getFormatYearBefore().shouldBe(visible);
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, неправильный  год")
    void shouldPurchaseInvalidYearIncorrected() {
        PurchasePage.InvalidYearAfter();
        DataSeleKtor.getFormatYear().shouldBe(visible);
    }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, ввод неверного формата месяц и год")
    void shouldPurchaseYearMonthIncorrected() {
        PurchasePage.InvalidData();
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат", "Неверный формат"));
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректное имя ")
    void shouldPurchaseInvalidNaimIncorrected() {
        PurchasePage.InvalidName();
        DataSeleKtor.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректный CVV ")
    void shouldPurchaseInvalidCVVIncorrected() {
        PurchasePage.InvalidCVV();
        DataSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }


}
