package steps_definitions;

import co.sofka.conexion.PersonasJDBC;
import co.sofka.controller.LoginController;
import co.sofka.controller.ShoppingController;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingSteps {

    private WebDriver driver;
    private ShoppingController shoppingController;
    private LoginController loginController;




    @Given(": I want to buy a product")
    public void i_want_to_buy_a_product() {

        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("firefox", "88.0.12");
        driver.get("https://www.saucedemo.com");
        loginController = new LoginController(driver);
        shoppingController = new ShoppingController(new PersonasJDBC(), driver);

    }

    @When(": I add to a cart")
    public void i_add_to_a_cart() {
        loginController.successfulLogin();
        shoppingController.successfulShoppingProcess();

    }

    @Then(": I Finish the process")
    public void i_finish_the_process() {
        String finishTitle = shoppingController.getFinishTitle();
        assertEquals(finishTitle, "FINISH");
        driver.quit();

    }


}
