package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    public  CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.CSS, using = "#billing_first_name")
    public WebElement txtbx_FirstName;

    @FindBy(how= How.CSS, using = "#billing_last_name")
    public WebElement txtbx_LastName;

    @FindBy(how= How.CSS, using = "#billing_email")
    public WebElement txtbx_Email;

    @FindBy(how= How.CSS, using = "#billing_phone")
    public WebElement txtbx_Phone;

    @FindBy(how = How.XPATH, using = "//select[@name = 'billing_country']")
    public WebElement country_List;

    @FindBy(how= How.CSS, using = "#billing_city")
    public WebElement txtbx_City;

    @FindBy(how= How.XPATH, using = "//*[@placeholder='House number and street name']")
    public WebElement txtbx_House;

    @FindBy(how= How.XPATH, using = "//*[@id='billing_state']")
    public WebElement Address;

    @FindBy(how= How.CSS, using = "#billing_postcode")
    public WebElement txtbx_PostCode;

    @FindBy(how= How.XPATH, using = "//*[@id='terms']")
    public WebElement chkbx_AcceptTermsAndCondition;

    @FindBy(how= How.CSS, using = "#place_order")
    public WebElement btn_PlaceOrder;

    public void enter_Name(String name){
        txtbx_FirstName.sendKeys(name);
    }

    public void enter_LastName(String lastName){
        txtbx_LastName.sendKeys(lastName);
    }

    public void enter_Email(String email){
        txtbx_Email.sendKeys(email);
    }

    public void enter_Phone(String phone){
        txtbx_Phone.sendKeys(phone);
    }

    public void enter_City(String city){
        txtbx_City.sendKeys(city);
    }

    public void enter_House(String address){
        txtbx_House.sendKeys(address);
    }
    public void select_Address(String address){
        Select select = new Select(Address);
        select.selectByVisibleText(address);
    }

    public void enter_PostCode(String postcode){
        txtbx_PostCode.sendKeys(postcode);
    }

    public void select_Country(String countryName){
        Select select = new Select(country_List);
        select.selectByVisibleText(countryName);
    }

    public void check_TermAndCondition(boolean value){
        if(value) chkbx_AcceptTermsAndCondition.click();
    }

    public void clickOn_PlaceOrder(){
        btn_PlaceOrder.submit();
    }

    public void fill_PersonalDetails(){
        enter_Name("Trang");
        enter_LastName("Nguyen");
        enter_Phone("1234567890");
        enter_Email("Automation@gmail.com");
        select_Country("India");
        enter_City("Delhi");
        enter_House("abc");
        select_Address("Andhra Pradesh");
        enter_PostCode("110088");
        enter_City("Delhi");
    }

}
