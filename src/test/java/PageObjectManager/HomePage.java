package PageObjectManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.ConfigFileReader;

public class HomePage {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void perform_Search(String search){
        //driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
        driver.navigate().to(configFileReader.getApplicationUrl() + "/?s=" + search + "&post_type=product");
    }
    public void navigateTo_HomePage(){
     //  driver.get("http://www.shop.demoqa.com");
         driver.get(configFileReader.getApplicationUrl());
    }
}
