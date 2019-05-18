package codersguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "card-number")
    private WebElement cardNumber;
    @FindBy(id = "card-cvv")
    private WebElement cvvNumber;
    @FindBy(id = "card-date")
    private WebElement expireDate;
    @FindBy(id = "card-name")
    private WebElement nameAndLastName;
    @FindBy(id = "card-email")
    private WebElement emailField;
    @FindBy(name = "submit")
    private WebElement submitButton;

    public void fillPaymentform(String arg0, String arg1){

        //Losowe generowanie numeru karty kredytowej
        long x = 1000000000000000l;
        long y = 1999999999999999l;
        Random visaCard = new Random();
        long visaCardNumber = x+((long)(visaCard.nextDouble()*(y-x)));
        String visaStringNumber = String.valueOf(visaCardNumber);

        //Losowe generowanie numeru cvv dla karty kredytowej
        int a = 100;
        int b = 998;
        Random cvvCard = new Random();
        int cvvCardNumber = cvvCard.nextInt(b-a+1)+a;
        String cvvStringNumber = String.valueOf(cvvCardNumber);

        //Losowe generowanie adresu Email dla płatności
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        cardNumber.sendKeys(visaStringNumber);
        cvvNumber.sendKeys(cvvStringNumber);
        expireDate.sendKeys(arg0);
        nameAndLastName.sendKeys(arg1);
        emailField.sendKeys("user"+ randomInt +"@gmail.com");
        submitButton.click();
    }
}
