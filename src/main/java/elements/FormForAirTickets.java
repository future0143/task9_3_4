package elements;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SearchResultsOfAviaTickets;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormForAirTickets {

    public static By fieldFromForInput = By.id("rc_select_0");
    public static By fieldWhereForInput = By.id("rc_select_1");
    public static By fieldDateThere = By.cssSelector("div.ant-picker.selector-form-date input[name='dateFrom']");
    public static By dateContainerSelector = By.className("ant-picker-panels");
    public static By attributeForDates = By.cssSelector("td[title]");
    public static By buttonPassengers = By.cssSelector("div.ant-dropdown-trigger");
    public static By buttonCounter = By.cssSelector("svg[class*='_button-module__icon']");
    public static By buttonSearchTickets = By.cssSelector("button[class*='_button-module__button'][class*='_selector-form-module__button']");


    public FormForAirTickets enterCityFrom(String text) {
        $(fieldFromForInput).sendKeys(text);
        $(By.xpath("//div[contains(@label, '" + text + "')]")).click();

        return this;
    }

    public FormForAirTickets enterCityWhere(String text) {
        $(fieldWhereForInput).sendKeys(text);
        $(By.xpath("//div[contains(@label, '" + text + "')]")).click();

        return this;
    }

    public FormForAirTickets chooseDateInField() {
        LocalDate nowDate = LocalDate.now();
        LocalDate dateForInput = nowDate.plusDays(2);
        String dateForInputString = dateForInput.toString();

        $(fieldDateThere).click();
        ElementsCollection dateElements = $(dateContainerSelector).$$(attributeForDates);

        for (WebElement dateElement : dateElements) {
            if (dateElement.getAttribute("title").equals(dateForInputString)) {
                dateElement.click();
            }
        }
        return this;
    }

    public FormForAirTickets clickPassengers() {
        $(buttonPassengers).click();

        return this;
    }

    public FormForAirTickets chooseAdults() {
        $$(buttonCounter).get(1).click();

        return this;
    }

    public SearchResultsOfAviaTickets clickSearchTickets() {
        $(buttonSearchTickets).click();

        return new SearchResultsOfAviaTickets();
    }
}