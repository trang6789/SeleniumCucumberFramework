package SeleniumTest;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class E2E_Test {
    private static WebDriver driver;

    public static  void main(String[]args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");
        driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

        List<WebElement> items= driver.findElements(By.cssSelector(".noo-product-inner"));
        items.get(0).click();

        Select color = new Select(driver.findElement(By.xpath("//*[@class = 'variations']//following::select[@id='pa_color']"))) ;
        color.selectByVisibleText("White");

        Select size = new Select(driver.findElement(By.xpath("//*[@class = 'variations']//following::select[@id='pa_size']"))) ;
        size.selectByVisibleText("Medium");

        WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        addToCart.click();

        WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
        cart.click();

        WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
        continueToCheckout.click();

        Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
        firstName.sendKeys("Lakshay");

        WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
        lastName.sendKeys("Sharma");

        WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
        emailAddress.sendKeys("test@gmail.com");

        WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
        phone.sendKeys("07438862327");

       //WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
       //WebElement countryDropDown = driver.findElement(By.xpath("//*[@id='billing_country_field']//following::span[@class='select2-selection__arrow']"));
       // WebElement countryDropDown = driver.findElement(By.xpath("//*[@role='combobox']//following::b[@role='presentation']"));
        //WebElement countryDropDown = driver.findElement(By.xpath("//*[@id='billing_country_field']//following::span[@title='Vietnam']"));
        //Select countryDropDown  = new Select(driver.findElement(By.xpath("//*[@id='billing_country_field']//following::span[@title='Vietnam']")));
        //countryDropDown.selectByVisibleText("Vietnam");
        //countryDropDown.click();
        //Thread.sleep(2000);

        //List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
        Select countryList = new Select(driver.findElement(By.xpath("//select[@name = 'billing_country']")));
        countryList.selectByVisibleText("India");
        //noinspection ControlFlowStatementWithoutBraces
        //for(WebElement country:countryList)
        //    if (country.getText().equals("India")) {
         //       country.click();
         //       Thread.sleep(3000);
         //       break;
         //   }

        WebElement city = driver.findElement(By.cssSelector("#billing_city"));
        city.sendKeys("Delhi");

        Select address = new Select(driver.findElement(By.xpath("//*[@id='billing_state']")));
        address.selectByVisibleText("Andhra Pradesh");

        WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
        postcode.sendKeys("110088");

        //Thread.sleep(3000);
        //WebElement shipToDifferetAddress  = driver.findElement(By.xpath("//*[@id='terms']"));
        //shipToDifferetAddress.click();
        //Thread.sleep(3000);

        //List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
        //paymentMethod.get(0).click();

        Thread.sleep(5000);
        WebElement acceptTC = driver.findElement(By.xpath("//*[@id='terms']"));
        acceptTC.click();

        WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
        placeOrder.submit();

        driver.quit();





    }
}
