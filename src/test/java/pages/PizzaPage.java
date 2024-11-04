package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PizzaPage {
    private WebDriverWait wait;
    private WebElement selectedPizza;

    @FindBy(xpath = "//div[@id='pizza_products']//div[contains(@class, 'item group')]")
    List<WebElement> pizzaProducts;

    public PizzaPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public PizzaPage findPizzaByName(String name) {
        wait.until(ExpectedConditions.visibilityOfAllElements(pizzaProducts));
        for (WebElement pizza : pizzaProducts) {
            if (pizza.getText().contains(name)) {
                selectedPizza = pizza;
            }
        }
        return this;
    }

    public void clickOrderButton() {
        WebElement orderButton = selectedPizza.findElement(By.xpath(".//div[@class='order-btn']"));
        orderButton.click();
    }
}
