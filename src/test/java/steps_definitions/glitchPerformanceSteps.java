package steps_definitions;

import co.sofka.controller.LoginController;
import co.sofka.controller.ProductsControllet;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class glitchPerformanceSteps {
    WebDriver driver;
    private LoginController loginController;
    private ProductsControllet productsControllet;


    @Given(": I introduce a problem user")
    public void i_introduce_a_problem_user() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("chrome", "90.0.4430.212");
        driver.get("https://www.saucedemo.com");

    }
    @When(": I introduce a glitch_performance_user user and password")
    public void i_introduce_a_glitch_performance_user_user_and_password() {
        loginController = new LoginController(driver);

        loginController.glitchPerformance();

    }
    @Then(": I can see a list of products")
    public void i_can_see_a_list_of_products(){
        productsControllet = new ProductsControllet(driver);
        int productsSize = productsControllet.sizeOflistOfPorduct();
        assertEquals(6,productsSize);
        driver.quit();

    }
}
