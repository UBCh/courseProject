package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageSeleKtor {
    private PageSeleKtor() {
    }

    // поля
    private static ElementsCollection pole = $$(".input__control");
    private static SelenideElement cardNumber = pole.get(0);
    private static SelenideElement month = pole.get(1);
    private static SelenideElement year = pole.get(2);
    private static SelenideElement owner = pole.get(3);
    private static SelenideElement cvv = pole.get(4);

    public static SelenideElement getCardNumber() {
        return cardNumber;
    }

    public static SelenideElement getMonth() {
        return month;
    }

    public static SelenideElement getYear() {
        return year;
    }

    public static SelenideElement getOwner() {
        return owner;
    }

    public static SelenideElement getCvv() {
        return cvv;
    }

    // кнопки
    private static ElementsCollection button = $$(".button__text");
    private static SelenideElement buttonBuy = button.get(0);
    private static SelenideElement buttonLoan = button.get(1);
    private static SelenideElement buttonContinue = button.get(2);

    public static SelenideElement getButtonBuy() {
        return buttonBuy;
    }

    public static SelenideElement getButtonLoan() {
        return buttonLoan;
    }

    public static SelenideElement getButtonContinue() {
        return buttonContinue;
    }

    // статусы
    private static SelenideElement error = $(".notification_status_error");
    private static SelenideElement oK = $(".notification_status_ok");

    public static SelenideElement getError() {
        return error;
    }

    public static SelenideElement getoK() {
        return oK;
    }

    // подстрочники
    private static ElementsCollection note = $$(".input__sub");
    private static SelenideElement noteCardNumber = note.get(3);
    private static SelenideElement noteManth = note.get(0);
    private static SelenideElement noteYear = note.get(1);
    private static SelenideElement noteOwner = note.get(3);
    private static SelenideElement noteCVV = note.get(4);

    public static ElementsCollection getNote() {
        return note;
    }

    public static SelenideElement getNoteCardNumber() {
        return noteCardNumber;
    }

    public static SelenideElement getNoteManth() {
        return noteManth;
    }

    public static SelenideElement getNoteYear() {
        return noteYear;
    }

    public static SelenideElement getNoteOwner() {
        return noteOwner;
    }

    public static SelenideElement getNoteCVV() {
        return noteCVV;
    }


    // подстрочники (неверно указан срок действия карты)

    private static SelenideElement formatYear = $(byText("Неверно указан срок действия карты"));
    private static SelenideElement formatManth = $(byText("Неверно указан срок действия карты"));
    private static SelenideElement formatYearBefore = $(byText("Истёк срок действия карты"));

    public static SelenideElement getFormatManth() {
        return formatManth;
    }

    public static SelenideElement getFormatYear() {
        return formatYear;
    }

    public static SelenideElement getFormatYearBefore() {
        return formatYearBefore;
    }


    // заголовки
    private static SelenideElement headingCard = $(byText("Оплата по карте"));
    private static SelenideElement headingIpoteka = $(byText("Кредит по данным карты"));

    public static SelenideElement getHeadingBuy() {
        return headingCard;
    }

    public static SelenideElement getHeadingIpoteka() {
        return headingIpoteka;
    }


}

