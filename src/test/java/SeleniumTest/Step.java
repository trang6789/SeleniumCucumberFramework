package SeleniumTest;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Step {
    WebDriver driver;

  @Before
    public void user_is_on_HomePage(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");
    }
    public void he_search_for(String arg1){
        driver.navigate().to("http://shop.demoqa.com/?s=" + arg1 + "&post_type=product");
    }
    public void choose_to_buy_the_first_item(){
        List<WebElement> items= driver.findElements(By.cssSelector(".noo-product-inner"));
        items.get(0).click();

        Select color = new Select(driver.findElement(By.xpath("//*[@class = 'variations']//following::select[@id='pa_color']"))) ;
        color.selectByVisibleText("White");

        Select size = new Select(driver.findElement(By.xpath("//*[@class = 'variations']//following::select[@id='pa_size']"))) ;
        size.selectByVisibleText("Medium");

        WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        addToCart.click();

    }

    public void move_to_checkout_from_mini_cart(){
        WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
        cart.click();

        WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
        continueToCheckout.click();
    }
    public void enter_personal_details_on_checkout_page() throws InterruptedException{
        Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
        firstName.sendKeys("Lakshay");

        WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
        lastName.sendKeys("Sharma");

        WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
        emailAddress.sendKeys("test@gmail.com");

        WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
        phone.sendKeys("07438862327");

        Select countryList = new Select(driver.findElement(By.xpath("//select[@name = 'billing_country']")));
        countryList.selectByVisibleText("India");
        WebElement city = driver.findElement(By.cssSelector("#billing_city"));
        city.sendKeys("Delhi");

        Select address = new Select(driver.findElement(By.xpath("//*[@id='billing_state']")));
        address.selectByVisibleText("Andhra Pradesh");

        WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
        postcode.sendKeys("110088");
    }
    public  void place_the_order(){
        WebElement acceptTC = driver.findElement(By.xpath("//*[@id='terms']"));
        acceptTC.click();

        WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
        placeOrder.submit();
    }

}
