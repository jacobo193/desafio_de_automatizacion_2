package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidLoginSteps {

    private WebDriver driver;

    private LoginController loginController;
    @Given("I am on Login page with invalid credentials")
    public void iAmOnLoginPageWithInvalidCredentials() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.get("https://www.saucedemo.com");
    }
    @When("I enter invalid username and password")
    public void iEnterInvaliduUserNameAndPassword() {
        loginController = new LoginController(driver);
        loginController.incorrectCredentialslogin();

    }
    @Then("I wont  redirected to Products page")
    public void IwontRedirectedToProductsPage() {
        String errorMessage = loginController.ErrorMessage();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
        driver.quit();
    }
}
