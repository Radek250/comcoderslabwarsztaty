package codersguru.cucumber.privateUserRegistration;

import codersguru.cucumber.RegistrationPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class PrivateUserSteps {
    WebDriver driver;

    @Given("^I open site codersguru$")
    public void iOpenSiteCodersguru() {
        System.setProperty("webdriver.gecko.driver",
                "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/");
    }

    @When("^I click on register new user$")
    public void iClickOnRegisterNewUser() throws InterruptedException {
        WebElement registerbutton = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerbutton.click();
    }

    @And("^I fill private form \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillPrivateForm(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
        // Write code here that turns the phrase above into concrete actions
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Then("^User should be succesfully registered$")
    public void userShouldBeSuccesfullyRegistered() {

        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://tester.codersguru.pl/register/confirmed", currentURL);
    }
}
