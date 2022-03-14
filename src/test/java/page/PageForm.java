package page;

import com.codeborne.selenide.SelenideElement;

public class PageForm {


    private PageForm() {}

    private static SelenideElement cardNumber = PageSeleKtor.getCardNumber();
    private static SelenideElement month = PageSeleKtor.getMonth();
    private static SelenideElement year = PageSeleKtor.getYear();
    private static SelenideElement owner = PageSeleKtor.getOwner();
    private static SelenideElement cvv = PageSeleKtor.getCvv();
    private static SelenideElement buttonContinue = PageSeleKtor.getButtonContinue();

    public static void fillingСardNumber( String numberCard) {

        cardNumber.setValue(String.valueOf(numberCard));
    }

    public static void fillingMonth(String mois){
        month.setValue(mois);
    }

     public static void fillingYear( String  an){
         year.setValue(an);
     }

     public static void fillingOwner(String nom){
         owner.setValue(nom);
     }

     public static void fillingCVV(String svv){
         cvv.setValue(svv);
     }

     public static void buttonPress(){
         buttonContinue.click();
     }

}
