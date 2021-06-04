package co.sofka.controller;

import co.sofka.pages.ProductsPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class LogOutController {

    private final WebDriver driver;
    private String loginButtonText;

    public LogOutController(WebDriver driver) {
        this.driver = driver;
        this.loginButtonText = "";

    }

    static Logger log = Logger.getLogger(LoginController.class.getName());

    public void logOutAction () throws IOException {

        final ProductsPage productsPage = new ProductsPage(driver);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./images/logOut/BurgerButton.png"));

        log.info("despeglando menu");
        productsPage.burgerMenu();

        file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./images/logOut/logOut.png"));
        log.info("logOutButton");
        productsPage.LogOutButton();

        try{

        }catch (Exception ex){

        }

    }

    public String getLoginText (){
        return this.loginButtonText;
    }
}
