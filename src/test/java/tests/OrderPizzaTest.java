package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.OrderPopUp;
import pages.PizzaPage;

public class OrderPizzaTest extends BaseTest {
    private static final String PIZZA_NAME = "Пицца \"Маргарита\"";
    private MainPage mainPage;
    private PizzaPage pizzaPage;
    private OrderPopUp orderPopUp;
    private BasketPage basketPage;

    @BeforeMethod
    void setUpOderPizzaTests() {
        mainPage = new MainPage(driver);
        pizzaPage = new PizzaPage(driver);
        orderPopUp = new OrderPopUp(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(description = "Тест: добавление пиццы в корзину")
    public void testAddPizzaToCart() {
        mainPage
                .clickPizzaButton();
        pizzaPage
                .findPizzaByName(PIZZA_NAME)
                .clickOrderButton();
        orderPopUp
                .clickOrderButton();
        mainPage
                .clickBasketPageButton();

        Assert.assertTrue(basketPage.isItemInBasket(PIZZA_NAME), "Пицца в корзине не соответствует добавленной пицце");
    }
}
