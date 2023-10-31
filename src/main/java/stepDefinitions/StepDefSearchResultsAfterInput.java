package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsAfterInput;
import elements.ListOfProducts;

import static com.codeborne.selenide.Selenide.$$;

public class StepDefSearchResultsAfterInput extends SearchResultsAfterInput {

    private ListOfProducts listOfProducts = new ListOfProducts();

    @Then("пользователь видит товар {string} в результатах поиска")
    public void checkProductInSearchResults(String nameOfProduct) {
        SelenideElement element = $$(listOfGoodsInProductCardSelector)
                .filter(Condition.text(nameOfProduct))
                .first()
                .shouldBe(Condition.visible);
        element.hover();
    }

    @When("пользователь добавляет товар в корзину")
    public void addProductToBasket() {
        listOfProducts.addToBasket();
    }
}