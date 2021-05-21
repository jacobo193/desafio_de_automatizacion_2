package co.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    WebDriver driver;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBadgeCartButton;

    @FindBy(id = "checkout")
    WebElement checkoutbutton;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void RemoveBadgeCartButton() {
        removeBadgeCartButton.click();
    }

    public CheckOutPage clickCheckoutButton() {
        checkoutbutton.click();
        return new CheckOutPage(driver);
    }
}
