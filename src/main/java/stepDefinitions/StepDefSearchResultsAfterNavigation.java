package stepDefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import pages.SearchResultsAfterNavigation;

import static com.codeborne.selenide.Selenide.$;

public class StepDefSearchResultsAfterNavigation extends SearchResultsAfterNavigation {

    @Then("пользователь видит список товаров категории {string}")
    public void checkProductsOfCategory(String expectedTitle) {
        $(catalogTitleElement).shouldHave(Condition.text(expectedTitle));

        $(catalog).shouldBe(Condition.visible);
    }
}