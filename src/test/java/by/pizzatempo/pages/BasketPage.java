package by.pizzatempo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {

    @FindBy(xpath = "//div[@class='cart-product-name title']")
    private List<WebElement> basketItemNames;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getItemNamesInBasket() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : basketItemNames) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }

    public boolean isItemInBasket(String itemName) {
        for (String name : getItemNamesInBasket()) {
            if (name.contains(itemName)) {
                return true;
            }
        }
        return false;
    }
}
