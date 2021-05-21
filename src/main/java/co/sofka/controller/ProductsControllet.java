package co.sofka.controller;

import co.sofka.pages.LoginPage;
import co.sofka.pages.ProductsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsControllet {

    WebDriver driver;
    private List<WebElement> ListOfProducts;

    static Logger log = Logger.getLogger(LoginController.class.getName());

    public ProductsControllet(WebDriver driver) {
        this.driver = driver;
    }

  public int sizeOflistOfPorduct(){


     log.info("cargando productos");
      ProductsPage productsPage = new ProductsPage(driver);
      return productsPage.ListOfProducts().size();

  }

}
