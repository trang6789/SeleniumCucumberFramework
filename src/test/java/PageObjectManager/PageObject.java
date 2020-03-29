package PageObjectManager;

import org.openqa.selenium.WebDriver;

public class PageObject {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;

    public PageObject(WebDriver driver){
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
