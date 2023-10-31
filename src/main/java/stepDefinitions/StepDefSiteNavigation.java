package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.SiteNavigation;

import static com.codeborne.selenide.Selenide.$;
import static pages.HomePage.buttonFiltersCssSelector;

public class StepDefSiteNavigation extends SiteNavigation {

    @When("пользователь переходит в категорию {string}")
    public void goToCategoryElectronics(String category) {
        $(buttonFiltersCssSelector).click();

        $(By.linkText(category)).click();
    }
}