package co.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;

    @FindBy(css = "*[data-test=\"firstName\"]")
    WebElement firstNameField;

    @FindBy(css = "*[data-test=\"lastName\"]")
    WebElement lastNameField;

    @FindBy(css = "*[data-test=\"postalCode\"]")
    WebElement zipCodeField;


    @FindBy(css = "*[data-test=\"continue\"]")
    WebElement continueButton;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameField(String firstname) {
        firstNameField.sendKeys(firstname);
    }

    public void setLastNameField(String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void setZipCodeField(String zipcode) {
        zipCodeField.sendKeys(zipcode);
    }

    public FinishProcessPage clickContinueButton() {
        continueButton.click();
        return new FinishProcessPage(driver);
    }
}

