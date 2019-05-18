package codersguru;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bookADateSteps {
    WebDriver driver;


    @Given("^I open site http://codersguru\\.pl$")
    public void iOpenSiteHttpCodersguruPl() {
        System.setProperty("webdriver.gecko.driver",
                "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/");
    }

    @When("^I click on register a user$")
    public void iClickOnRegisterAUser() {
        WebElement registerbutton = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerbutton.click();
    }

    @And("^I fill registration private form \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillRegistrationPrivateForm(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7){
        // Write code here that turns the phrase above into concrete actions
        RegistrationPage registerUserToBookADate = new RegistrationPage(driver);
        registerUserToBookADate.registerUser(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @And("^I write \"([^\"]*)\" technology and I go to choose mentor$")
    public void iWriteTechnologyAndIGoToChooseMentor(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        chooseTechnology findTheMentor = new chooseTechnology(driver);
        findTheMentor.findMentor();
    }

    @And("^I choose the mentor and I go to reservation window$")
    public void iChooseTheMentorAndIGoToReservationWindow() {
        ChooseMentor goToReservationPage = new ChooseMentor(driver);
        goToReservationPage.goToBookADatePage();
    }

    @And("^I book a date and go to payment window$")
    public void iBookADateAndGoToPaymentWindow() {
        ReservationPage bookADate = new ReservationPage(driver);
        bookADate.printList();
    }

    @And("^I choose visaCard payment$")
    public void iChooseVisaCardPayment() {
        ChooseVisaCardPayment paymentViaCard = new ChooseVisaCardPayment(driver);
        paymentViaCard.goToPaymentViaCard();
    }

    @And("^I fill payment form by \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillPaymentFormBy(String arg0, String arg1){
        // Write code here that turns the phrase above into concrete actions
        PaymentPage fillOutPaymentForm = new PaymentPage(driver);
        fillOutPaymentForm.fillPaymentform(arg0, arg1);
    }

    @Then("^payment should be rejected$")
    public void paymentShouldBeRejected() {
        WebElement errorMessage = driver.findElement
                (By.xpath("//*[@id=\"app\"]/div/div[2]/main/div[2]/article/div/form/div[1]/label[2]/span"));
        String errorText = errorMessage.getText();
        Assert.assertEquals("Invalid card number.", errorText);
        //driver.quit();
    }


}
