package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginSteps {

    private WebDriver driver;
    private LoginController loginController;





    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        //System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        //driver = new EventFiringWebDriver(new ChromeDriver());
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.get("https://www.saucedemo.com");

    }

    @When("I enter valid username and password")

    public void iEnterValidUsernameAndPassword() {

        loginController = new LoginController(driver);
        loginController.successfulLogin();
    }

    @Then("I should be redirected to Products page")
    public void iShouldBeRedirectedToProductsPage() {
        String productTitle = loginController.getProductTitle();
        assertEquals(productTitle, "PRODUCTS");

        driver.quit();
    }





}
