package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListingPage {
    public ProductListingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    public WebElement btn_AddToCart;

    @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
    public List<WebElement> prd_List;

    @FindBy(how = How.XPATH, using = "//*[@class = 'variations']//following::select[@id='pa_color']")
    public WebElement drpdwn_Color;

    @FindBy(how = How.XPATH, using = "//*[@class = 'variations']//following::select[@id='pa_size']")
    public WebElement drpdwn_Size;

    public void clickOn_AddToCard(){
        btn_AddToCart.click();
    }

    public void select_Product(int productNumber){
        prd_List.get(productNumber).click();
    }
    public void select_Color() throws InterruptedException {
       Select select = new Select(drpdwn_Color);
       select.selectByVisibleText("White");
       Thread.sleep(1500);
        //drpdwn_Color.getFirstSelectedOption();
    }
    public void select_Size() throws InterruptedException {
        Select select = new Select(drpdwn_Size);
        select.selectByVisibleText("Medium");
        Thread.sleep(1500);
    }
    public void fill_ProductDetails() {
        select_Product(0);

//        select_Color("White");
//        select_Size("Medium");
    }

}
