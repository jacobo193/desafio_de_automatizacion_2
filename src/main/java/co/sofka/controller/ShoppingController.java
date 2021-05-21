package co.sofka.controller;

import co.sofka.conexion.PersonaRepository;
import co.sofka.domain.PersonaDTO;
import co.sofka.pages.CheckOutPage;
import co.sofka.pages.FinishProcessPage;
import co.sofka.pages.ProductsPage;
import co.sofka.pages.YourCartPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Random;

public class ShoppingController {

    private final PersonaRepository personaRepository;
    private final WebDriver driver;
    private String finishButtonTitle;
    static Logger log = Logger.getLogger(LoginController.class.getName());

    public ShoppingController(PersonaRepository personaRepository, WebDriver driver) {
        this.personaRepository = personaRepository;
        this.driver = driver;
        this.finishButtonTitle = "";
    }

    public void successfulShoppingProcess() {

        try {

            ProductsPage productsPage = new ProductsPage(driver);
            YourCartPage yourCartPage = new YourCartPage(driver);
            CheckOutPage checkOutPage = new CheckOutPage(driver);

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/shopping/cartBadge.png"));
            log.info("clickeando cart badgebutton");
            productsPage.cartBadgebutton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/shopping/checkout.png"));
            log.info("clickeando el boton de check out");
            yourCartPage.clickCheckoutButton();

            log.info("introduciendo datos requeridos para el checkout");

            final PersonaDTO userDataFromDataBase = getUserDataFromDataBase();
            checkOutPage.setFirstNameField(userDataFromDataBase.getFirstName());
            checkOutPage.setLastNameField(userDataFromDataBase.getLastName());
            checkOutPage.setZipCodeField(userDataFromDataBase.getZipcode());

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/shopping/setData.png"));

            log.info("click en el boton de continue");
            checkOutPage.clickContinueButton();

            file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./images/shopping/finish.png"));
            this.finishButtonTitle = new FinishProcessPage(driver).finishButtonText();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    public String getFinishTitle() {
        return this.finishButtonTitle;
    }

    private PersonaDTO getUserDataFromDataBase() {
        final List<PersonaDTO> personaDTOS = personaRepository.getAllPersonas();
        final Random rand = new Random();
        int numeroRandom = rand.nextInt(personaDTOS.size());

        return personaDTOS.get(numeroRandom);
    }
}
