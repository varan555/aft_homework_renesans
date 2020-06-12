package steps;

import io.cucumber.java.en.When;
import pages.MainPage;

public class MainPageSteps {


    @When("выбрано меню {string}:")
    public void chooseElementMainMenu(String elementMainMenu) {
        MainPage mainPage = new MainPage();
        mainPage.chooseService(elementMainMenu);
    }
}
