package by.pizzatempo.tests;

import by.pizzatempo.pages.*;
import by.pizzatempo.pages.products.DrinkPage;
import by.pizzatempo.pages.products.PizzaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderProductsTest extends BaseTest {
    private static final String PIZZA_NAME = "Пицца \"Маргарита\"";
    private static final String DRINK_NAME = "Тропический смузи";
    private MenuPage menuPage;
    private PizzaPage pizzaPage;
    private OrderPopUp orderPopUp;
    private BasketPage basketPage;

    @BeforeMethod
    void setUpOderPizzaTests() {
        menuPage = new MenuPage(driver);
        pizzaPage = new PizzaPage(driver);
        orderPopUp = new OrderPopUp(driver);
        basketPage = new BasketPage(driver);
    }

    @Test(description = "Тест: добавление пиццы в корзину")
    public void testAddPizzaToCart() {
        menuPage
                .clickPizzaButton();
        pizzaPage
                .findPizzaByName(PIZZA_NAME)
                .clickOrderButton();
        orderPopUp
                .clickOrderButton();
        menuPage
                .clickBasketPageButton();

        Assert.assertTrue(basketPage.isItemInBasket(PIZZA_NAME), "Пицца в корзине не соответствует добавленной пицце");
    }

    @Test(description = "Тест: добавление пиццы и напитка в корзину")
    public void testAddPizzaAndDrinkToCart() {
        DrinkPage drinkPage = new DrinkPage(driver);

        menuPage
                .clickPizzaButton();
        pizzaPage
                .findPizzaByName(PIZZA_NAME)
                .clickOrderButton();
        orderPopUp
                .clickOrderButton();

        menuPage
                .clickDrinkButton();

        drinkPage
                .findDrinkByName(DRINK_NAME)
                .clickOrderButton();

        menuPage
                .clickBasketPageButton();

        Assert.assertTrue(basketPage.isItemInBasket(PIZZA_NAME), "Пицца в корзине не соответствует добавленной пицце");
        Assert.assertTrue(basketPage.isItemInBasket(DRINK_NAME), "Напиток в корзине не соответствует добавленному напитку");
    }
}
