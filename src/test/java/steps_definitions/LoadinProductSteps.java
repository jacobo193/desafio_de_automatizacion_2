package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.controller.ProductsControllet;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadinProductSteps {

    WebDriver driver;
    private LoginController loginController;
    private ProductsControllet productsControllet;


    @Given(": I am in the product page")
    public void iAmInTheProductPage() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.get("https://www.saucedemo.com");

    }
    @When(": I introduce a right user and password")
    public void IIntroduceARightUserAndPassword() {
        loginController = new LoginController(driver);

        loginController.successfulLogin();



    }
    @Then(": I can seee a list of products")
    public void i_can_seee_a_list_of_products()  {
        productsControllet = new ProductsControllet(driver);
        int productsSize = productsControllet.sizeOflistOfPorduct();
        assertEquals(6,productsSize);
        driver.quit();
    }
}
