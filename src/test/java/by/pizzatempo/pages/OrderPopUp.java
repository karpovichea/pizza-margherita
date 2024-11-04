package by.pizzatempo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPopUp {
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='popupContent']")
    WebElement popUpContent;

    @FindBy(xpath = "(//div[@class='order-btn'])[last()]")
    WebElement orderButton;

    public OrderPopUp(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickOrderButton() {
        wait.until(ExpectedConditions.visibilityOf(popUpContent));
        orderButton.click();
    }
}
