package by.pizzatempo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
