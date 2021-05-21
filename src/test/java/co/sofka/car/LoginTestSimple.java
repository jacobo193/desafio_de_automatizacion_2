package co.sofka.car;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTestSimple {


    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSawgLabs() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
    }
}
