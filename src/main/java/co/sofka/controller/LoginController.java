package co.sofka.controller;

import co.sofka.pages.LoginPage;
import co.sofka.pages.ProductsPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class LoginController {

    private final WebDriver driver;
    private String productTitle;
    private String loginErrorMessage;

    static Logger log = Logger.getLogger(LoginController.class.getName());

    public LoginController(WebDriver driver) {
        this.productTitle = "";
        this.driver = driver;
        this.loginErrorMessage = "";
    }

    public void successfulLogin() {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/login/Login.png"));

            final LoginPage loginPage = new LoginPage(driver);


            log.info("Se introduce el nombre de usuario: standard_user");
            loginPage.setUsernameField("standard_user");

            log.info("Se introduce el contraseña: secret_sauce");
            loginPage.setPasswordField("secret_sauce");

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/login/SetCredentialLogin.png"));


            log.info("Se da click en el botón de LOGIN");
            loginPage.clickLoginButton();
            this.productTitle = new ProductsPage(driver).getProductText();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/login/LoginSuccessful.png"));

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    public void incorrectCredentialslogin() {
        try {

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/loginIncorrect/Login.png"));
            log.info("Se introduce el nombre de usuario: user");
            final LoginPage loginPage = new LoginPage(driver);
            loginPage.setUsernameField("user");

            log.info("Se introduce el password: user");
            loginPage.setPasswordField("user");


            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/loginIncorrect/SetCredentialLogin.png"));
            log.info("Se da click en el boton de login");
            loginPage.clickLoginButton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/loginIncorrect/LoginFail.png"));
            this.loginErrorMessage = new LoginPage(driver).getLoginErrorMessage();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public String ErrorMessage() {
        return this.loginErrorMessage;
    }

    public void lockOutLogin() {
        try {
            final LoginPage loginPage = new LoginPage(driver);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/Loginlockout/Login.png"));


            log.info("Se introduce el nombre de usuario: locked_out_user" );

            loginPage.setUsernameField("locked_out_user");

            log.info("Se introduce el password: secret_sauce");
            loginPage.setPasswordField("secret_sauce");

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/Loginlockout/SetCredentialLogin.png"));

            log.info("Se da click en el boton de login");
            loginPage.clickLoginButton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/Loginlockout/loginLockout.png"));
            this.loginErrorMessage = new LoginPage(driver).getLoginErrorMessage();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void glitchPerformance() {
        try {
            final LoginPage loginPage = new LoginPage(driver);

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/Glitch/Login.png"));
            log.info("Se introduce el nombre de usuario: performance_glitch_user" );
            loginPage.setUsernameField("performance_glitch_user");

            log.info("Se introduce el password: secret_sauce");
            loginPage.setPasswordField("secret_sauce");

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/glitch/SetCredentialLogin.png"));

            log.info("Se da click en el boton de login");
            loginPage.clickLoginButton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/glitch/loginSucessGlitch.png"));

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    public void problemUser() {
        try {
            final LoginPage loginPage = new LoginPage(driver);

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/ProblemUser/Login.png"));

            log.info("Se introduce el nombre de usuario: problem_user" );
            loginPage.setUsernameField("problem_user");

            log.info("Se introduce el password: secret_sauce");
            loginPage.setPasswordField("secret_sauce");

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/ProblemUser/SetCredentialLogin.png"));


            log.info("Se da click en el boton de login");
            loginPage.clickLoginButton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/ProblemUSer/loginSucessProblem.png"));

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
