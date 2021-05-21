package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LockOutSteps {

    private WebDriver driver;
    private LoginController loginController;

    @Given("I am on Login page with lockout credentials")
    public void i_am_on_login_page_with_lockout_credentials() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("firefox", "88.0.12");
        driver.get("https://www.saucedemo.com");

    }
    @When("I enter lockout username and password")
    public void i_enter_lockout_username_and_password() {
        loginController = new LoginController(driver);
        loginController.lockOutLogin();

    }
    @Then("I  cannot be able to enter to Products page")
    public void i_cannot_be_able_to_enter_to_products_page() {
        String errorMessage = loginController.ErrorMessage();
        assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");

        driver.quit();

    }
}
