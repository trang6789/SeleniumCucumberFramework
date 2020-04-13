package PageObjectManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ConfigFileReader;
import utility.FileReaderManager;
import utility.WebDriverManager;


import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class TestPage {
    WebDriver driver;
    HomePage homePage;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageObject pageObjectManager;
    ConfigFileReader configFileReader;
    WebDriverManager webDriverManager;


    @Before
    public void start() throws FileNotFoundException {
        //ChromeOptions options = new ChromeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //driver = new ChromeDriver(options);

        //configFileReader = new ConfigFileReader();
       // System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
        //System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);

        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObject(driver);

        homePage = pageObjectManager.getHomePage();
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
        //driver.get(configFileReader.getApplicationUrl());
        //driver.navigate().to(configFileReader.getApplicationUrl() + "?s=dress&post_type=product");
        homePage.navigateTo_HomePage();
        homePage.perform_Search("dress");

        productListingPage.fill_ProductDetails();
        Thread.sleep(2000);
        productListingPage.select_Color() ;
        productListingPage.select_Size();
        productListingPage.clickOn_AddToCard();
        Thread.sleep(2000);

        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();

        checkoutPage.fill_PersonalDetails();
        Thread.sleep(2000);
        checkoutPage.check_TermAndCondition(true);
        checkoutPage.clickOn_PlaceOrder();
    }
}
