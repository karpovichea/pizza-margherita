package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.pizzatempo.by/");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
