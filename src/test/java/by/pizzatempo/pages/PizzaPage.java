package by.pizzatempo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PizzaPage extends ProductPage {

    @FindBy(xpath = "//div[@id='pizza_products']//div[contains(@class, 'item group')]")
    List<WebElement> pizzaProducts;

    public PizzaPage(WebDriver driver) {
        super(driver);
    }

    public PizzaPage findPizzaByName(String name) {
        findProductByName(pizzaProducts, name);
        return this;
    }

    public void clickOrderButton() {
        clickOrderButton(".//div[@class='order-btn']");
    }
}
