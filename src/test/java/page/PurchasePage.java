package page;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;

public class PurchasePage {

    private PurchasePage() {
    }


    public static void getDebet(){
        PageSeleKtor.getHeadingBuy().shouldBe(visible);
    }
    public static void getKredit(){
        PageSeleKtor.getHeadingIpoteka().shouldBe(visible);
    }

    public static void getOk() {
        PageSeleKtor.getoK().shouldBe(visible, Duration.ofMillis(30000));
    }

    public static void getError() {
        PageSeleKtor.getError().shouldBe(visible,Duration.ofMillis(30000) );
    }

    public static void getNote() {
        PageSeleKtor.getNoteCardNumber().shouldBe(visible);
        PageSeleKtor.getNoteManth().shouldBe(visible);
        PageSeleKtor.getNoteYear().shouldBe(visible);
        PageSeleKtor.getNoteOwner().shouldBe(visible);
        PageSeleKtor.getNoteCVV().shouldBe(visible);
    }

    public static void getNoteNumber() {
        PageSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }

    public static void getNoteManth() {
        PageSeleKtor.getFormatManth().shouldBe(visible);
    }

    public static void getNoteFormatYearBefore() {
        PageSeleKtor.getFormatYearBefore().shouldBe(visible);
    }

    public static void getNoteFormatYearAfter() {

        PageSeleKtor.getFormatYear().shouldBe(visible);
    }

    public static void getNoteInvalidData() {
        PageSeleKtor.getNote().shouldBe(texts("Неверный формат", "Неверный формат"));
    }

    public static void getNoteInvalidName() {
        PageSeleKtor.getNote().shouldBe(texts("Поле обязательно для заполнения"));
    }

    public static void getNoteInvalidCVV() {

        PageSeleKtor.getNote().shouldBe(texts("Неверный формат"));
    }



}

