package co.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishProcessPage {

    @FindBy(id = "finish")
    WebElement finishButtonTitle;

    public FinishProcessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String finishButtonText() {
        return finishButtonTitle.getText();
    }
}
