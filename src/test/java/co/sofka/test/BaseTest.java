package co.sofka.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {



        private WebDriver driver;


        @BeforeEach
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/)");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }

        @AfterEach
        public void tearDown(){ driver.quit(); }

}
