package page;

import com.codeborne.selenide.Selenide;
import data.DataSeleKtor;

public class LoginPage {

    public LoginPage() {
    }

    public static void buyPage() {
      DataSeleKtor.getButtonBuy().click();
        Selenide.sleep(7000);

    }

    public static void buyLoan() {
       DataSeleKtor.getButtonLoan().click();
        Selenide.sleep(7000);

    }


}

