package codersguru.cucumber.companyUserRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegistrationCompanyPage {

    WebDriver driver;


    public RegistrationCompanyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(id = "fos_user_registration_form_email")
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

    @FindBy (id = "fos_user_registration_form_company_name")
    private WebElement companyField;

    @FindBy (xpath = "//*[@id=\"registration-main-form\"]/div[12]/input")
    private WebElement checkBox;

    @FindBy (id = "fos_user_registration_form_nip")
    private WebElement NIPField;

    @FindBy (id = "register-submit-btn")
    private WebElement submitButton;


    public void registerCompanyUser (String name, String lastname, String pass, String city,
                              String postcode, String street, String house, String company){

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
        companyField.sendKeys(company);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://generatory.it");

        WebElement nipText = driver.findElement(By.id("nipBox"));
        String nip = nipText.getText();
        System.out.println(nip);
        NIPField.sendKeys(nip);

        checkBox.click();
        submitButton.click();
    }




}
