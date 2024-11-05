package by.pizzatempo.pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DrinkPage extends ProductPage {

    @FindBy(xpath = "//div[contains(@class, 'item item_product ')]")
    List<WebElement> drinkProducts;

    public DrinkPage(WebDriver driver) {
        super(driver);
    }

    public DrinkPage findDrinkByName(String name) {
        findProductByName(drinkProducts, name);
        return this;
    }

    public void clickOrderButton() {
        clickOrderButton(".//button[@class='orderButton orderProductsButton btn button']");
    }
}
