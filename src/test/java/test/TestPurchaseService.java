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
        PurchasePage.getOk();
       var expected = DataBDHelper.stubTestPurshase();
        var actual = "APPROVED";
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте №2, одобрена банком.")
    void shouldPurchaseRejected() {
        PurchasePage.BuyPageSecond();
        PurchasePage.getOk();
        var expected = DataBDHelper.stubTestPurshase();
        var actual = "APPROVED";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой несуществующей карте, отклонена банком.")
    void shouldPurchaseRejectedFake() {
        PurchasePage.FakerPage();
        PurchasePage.getError();
       // var expected = DataBDHelper.stubTest();
       // var actual = "DECLINED";
       // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Покупка тура по дебетовой  карте, отправка пустой формы.")
    void shouldPurchaseZero() {
        PurchasePage.InvalidPageZero();
        PurchasePage.getNote();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный номер")
    void shouldPurchaseInvalidNumber() {
        PurchasePage.InvalidNumber();
       PurchasePage.getNoteNumber();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, не валидный месяц")
    void shouldPurchaseInvalidMonth() {
        PurchasePage.InvalidMonth();
       PurchasePage.getNoteManth();
    }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, истек год")
    void shouldPurchaseInvalidYearExpired() {
        PurchasePage.InvalidYearBefore();
        PurchasePage.getNoteFormatYearBefore();
           }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, неправильный  год")
    void shouldPurchaseInvalidYearIncorrected() {
        PurchasePage.InvalidYearAfter();
        PurchasePage.getNoteFormatYearAfter();
          }


    @Test
    @DisplayName("Покупка тура по дебетовой карте, ввод неверного формата месяц и год")
    void shouldPurchaseYearMonthIncorrected() {
        PurchasePage.InvalidData();
        PurchasePage.getNoteInvalidData();
            }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректное имя ")
    void shouldPurchaseInvalidNaimIncorrected() {
        PurchasePage.InvalidName();
        PurchasePage.getNoteInvalidName();
           }

    @Test
    @DisplayName("Покупка тура по дебетовой карте, некорректный CVV ")
    void shouldPurchaseInvalidCVVIncorrected() {
        PurchasePage.InvalidCVV();
        PurchasePage.getNoteInvalidCVV();
           }


}
