package steps_definitions;

import co.sofka.conexion.PersonasJDBC;
import co.sofka.controller.LogOutController;
import co.sofka.controller.LoginController;
import co.sofka.controller.ProductsControllet;
import co.sofka.controller.ShoppingController;
import co.sofka.managerbrowser.Manager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOut {

    WebDriver driver;
    private LoginController loginController;
    private LogOutController logOutController;
    @Given(": I want to log out")
    public void i_want_to_log_out() {
        Manager manager = new Manager(driver);
        driver = manager.selectBrowser("firefox", "88.0.12");
        driver.get("https://www.saucedemo.com");
        loginController = new LoginController(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @When(": I click in te burger menu an click in log out button")
    public void i_click_in_te_burger_menu_an_click_in_log_out_button() throws IOException {
        loginController = new LoginController(driver);
        logOutController = new LogOutController(driver);
        loginController.successfulLogin();
        logOutController.logOutAction();

    }
    @Then(": I return to Login Page")
    public void i_return_to_login_page() {
      assertThat(logOutController.getLoginText(), true);
        driver.quit();
    }
}
