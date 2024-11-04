package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='https://www.pizzatempo.by/menu/pizza.html']")
    WebElement pizzaPageButton;

    @FindBy(xpath = "//a[@href='https://www.pizzatempo.by/menu/order/']")
    WebElement basketPageButton;

    public MainPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickPizzaButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pizzaPageButton));
        pizzaPageButton.click();
    }

    public void clickBasketPageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(basketPageButton));
        basketPageButton.click();
    }
}
