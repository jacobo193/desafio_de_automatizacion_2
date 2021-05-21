package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.controller.ProductsControllet;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemUserSteps {

    WebDriver driver;
    private LoginController loginController;
    private ProductsControllet productsControllet;

    @Given("I am on Login page with problem credentials")
    public void IAmOnLoginPageWithProblemCredentials() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.get("https://www.saucedemo.com");


    }
    @When("I enter  username and password")
    public void IEnterUsernameAndPassword() {
        loginController = new LoginController(driver);

        loginController.problemUser();
    }
    @Then("I will sitll able to see the products")
    public void IwillSitllAbleToSeeTheProducts() {
        productsControllet = new ProductsControllet(driver);
        int productsSize = productsControllet.sizeOflistOfPorduct();
        assertEquals(6,productsSize);
        driver.quit();

    }
}
