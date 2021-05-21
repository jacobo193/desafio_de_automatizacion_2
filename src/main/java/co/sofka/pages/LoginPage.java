package co.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;
    private final String URL = "https://www.saucedemo.com";

    @FindBy(css = "*[data-test=\"username\"]")
    WebElement usernameField;

    @FindBy(css = "*[data-test=\"password\"]")
    WebElement passwordField;

    @FindBy(css = "h3")
    WebElement loginErrorMessage;

    @FindBy (css="div#login_button_container h3")
    WebElement alertUserBlock;

    @FindBy(id = "login-button")
    WebElement loginButton;

    //private By loginButton = By.id("login-button");
    private final By pageName = By.className("product_label");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsernameField(String user) {
        usernameField.sendKeys(user);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.submit();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

}



