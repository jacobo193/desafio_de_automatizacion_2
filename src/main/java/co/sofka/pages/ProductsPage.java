package co.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    @FindBy(className = "inventory_item_img")
    List<WebElement> products;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement AddToCartButton;

    @FindBy(className = "title")
    WebElement productTitle;

    @FindBy(id = "shopping_cart_container")
    WebElement cartBadgebutton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductText() {
        return productTitle.getText();
    }

    public void AddtoCart(){
        AddToCartButton.click();
    }

    public YourCartPage cartBadgebutton(){
        cartBadgebutton.click();
        return new YourCartPage(driver);
    }

    public List<WebElement>ListOfProducts(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        List<WebElement> productos = new ArrayList<>();
        for(int i = 0; i<6; i++){
            productos.add(products.get(i));
        }
        return productos;
    }

}
