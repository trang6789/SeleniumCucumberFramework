package PageObjectManager;

import PageObjectModel.CartPage;
import PageObjectModel.CheckoutPage;
import PageObjectModel.HomePage;
import PageObjectModel.ProductListingPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null)? homePage = new HomePage(driver):homePage;
    }

    public CartPage getCartPage(){
        return (cartPage == null)? cartPage = new CartPage(driver):cartPage;
    }
    public ProductListingPage getProductListingPage(){
        return (productListingPage == null)? productListingPage = new ProductListingPage(driver):productListingPage;
    }

    public CheckoutPage getCheckoutPage(){
        return (checkoutPage == null)? checkoutPage = new CheckoutPage(driver): checkoutPage;
    }
}
