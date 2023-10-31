package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.TestProperties;
import elements.SearchLine;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static pages.SearchResultsAfterInput.listOfGoodsInProductCardSelector;

public class StepDefHomePage extends HomePage {

    private final SearchLine searchLine = new SearchLine();

    @Given("пользователь на главной странице магазина")
    public void openHomePage() {
        String url = TestProperties.getValue("test.url");

        Selenide.open(url);

        $(mainContent).should(Condition.visible);
    }

    @When("пользователь вводит {string} в строку поиска")
    public void inputProductInSearchLine(String text) {
        searchLine.inputTextInSearchLine(text);

        $(listOfGoodsInProductCardSelector).shouldBe(Condition.visible);
    }
}