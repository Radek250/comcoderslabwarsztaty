package codersguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseVisaCardPayment {
    WebDriver driver;


    public ChooseVisaCardPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/main/div[2]/article/div/a[2]/div[2]/span")
    private WebElement cardPaymentButton;

    public void goToPaymentViaCard(){
        cardPaymentButton.click();
    }
}
