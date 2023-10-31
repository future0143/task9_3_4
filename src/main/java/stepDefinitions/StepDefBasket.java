package stepDefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import pages.Basket;

import static com.codeborne.selenide.Selenide.$;
import static elements.ListOfProducts.buttonBasket;

public class StepDefBasket extends Basket {

    @Then("в его корзине находится товар {string}")
    public void checkProductNameInBasket(String expectedProductName) {
        $(buttonBasket).click();
        $(nameOfProductInBasket).shouldHave(Condition.text(expectedProductName));
    }
}