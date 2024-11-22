package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AEPage {
    public AEPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath =" //i[@class='fa fa-lock']")
    public WebElement signUp;

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    public WebElement registerName;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    public WebElement registermail;

    @FindBy (xpath = "//input[@data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy (id = "id_gender1")
    public WebElement gender1;

    @FindBy (xpath = "//input[@data-qa='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@data-qa='first-name']")
    public WebElement first;

    @FindBy(xpath = "//input[@data-qa='last-name']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@data-qa='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@data-qa='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    public WebElement mobilnumber;

    @FindBy(xpath = "//select[@data-qa='country']")
    public WebElement country;




}
