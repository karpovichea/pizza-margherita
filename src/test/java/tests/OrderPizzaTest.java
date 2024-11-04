package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
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

    @BeforeEach
    void setUpOderPizzaTests() {
        mainPage = new MainPage(driver);
        pizzaPage = new PizzaPage(driver);
        orderPopUp = new OrderPopUp(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    @DisplayName("Тест: добавление пиццы в корзину")
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
