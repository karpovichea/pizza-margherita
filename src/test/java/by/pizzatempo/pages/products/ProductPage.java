package by.pizzatempo.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ProductPage {
    protected WebDriverWait wait;
    protected WebElement selectedProduct;

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    protected void findProductByName(List<WebElement> products, String name) {
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        for (WebElement product : products) {
            if (product.getText().contains(name)) {
                selectedProduct = product;
                return;
            }
        }
        throw new NoSuchElementException("Продукт с заданным названием не найден");
    }

    protected void clickOrderButton(String orderButtonXpath) {
        WebElement orderButton = selectedProduct.findElement(By.xpath(orderButtonXpath));
        orderButton.click();
    }
}
