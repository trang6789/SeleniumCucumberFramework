package PageObjectManager;


import PageObjectModel.CartPage;
import PageObjectModel.CheckoutPage;
import PageObjectModel.HomePage;
import PageObjectModel.ProductListingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestPage {
    WebDriver driver;
    HomePage home;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectManager = new PageObjectManager(driver);
        home = pageObjectManager.getHomePage();
        home.navigateTo_Homepage();
        productListingPage = pageObjectManager.getProductListingPage();
        cartPage = pageObjectManager.getCartPage();
        checkoutPage = pageObjectManager.getCheckoutPage();

    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void Test()  throws InterruptedException{
        home.navigateTo_Homepage();
        home.perform_Search();
        productListingPage.fill_ProductDetails();
        Thread.sleep(2000);
        productListingPage.select_Color() ;
        productListingPage.select_Size();
        productListingPage.clickOn_AddToCard();
        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
        checkoutPage.fill_PersonalDetails();
        Thread.sleep(2000);
        checkoutPage.check_TermAndCondition(true);
        checkoutPage.clickOn_PlaceOrder();
    }
}
