package codersguru.cucumber;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy (id = "fos_user_registration_form_email")
    private WebElement emailField;

    @FindBy (id = "fos_user_registration_form_name")
    private WebElement nameField;

    @FindBy (id = "fos_user_registration_form_lastname")
    private WebElement lastnameField;

    @FindBy (id = "fos_user_registration_form_plainPassword_first")
    private WebElement passwordField;

    @FindBy (id = "fos_user_registration_form_plainPassword_second")
    private WebElement passwordRepeatField;

    @FindBy (id = "form_city")
    private WebElement cityField;

    @FindBy (id = "form_postal_code")
    private WebElement postcodeField;

    @FindBy (id = "form_street")
    private WebElement streetField;

    @FindBy (id = "form_number")
    private WebElement houseField;

    @FindBy (xpath = "//*[@id=\"registration-main-form\"]/div[12]/input")
    private WebElement checkBox;

    @FindBy (id = "register-submit-btn")
    private WebElement submitButton;

    public void registerUser (String name, String lastname, String pass, String city,
                              String postcode, String street, String house){

        emailField.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username"+ randomInt +"@gmail.com");

        nameField.sendKeys(name);
        lastnameField.sendKeys(lastname);
        passwordField.sendKeys(pass);
        passwordRepeatField.sendKeys(pass);
        cityField.sendKeys(city);
        postcodeField.sendKeys(postcode);
        streetField.sendKeys(street);
        houseField.sendKeys(house);
        checkBox.click();
        submitButton.click();
    }
}





