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

import java.util.concurrent.TimeUnit;

public class CompanyUserSteps {
    WebDriver driver;

    @Given("^I open site codersguru\\.pl$")
    public void iOpenSiteCodersguruPl() {
        System.setProperty("webdriver.gecko.driver",
               "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/");
    }

    @When("^I click on register a new user$")
    public void iClickOnRegisterANewUser() {
        WebElement registerbutton = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerbutton.click();
    }

    @And("^I ckick on company button$")
    public void iCkickOnCompanyButton() {
        WebElement companyButton = driver.findElement(By.id("company"));
        companyButton.click();
    }

    @And("^I fill company form \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillCompanyForm(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        // Write code here that turns the phrase above into concrete actions
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerCompanyUser(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);

    }

    @Then("^Company user should be succesfully registered$")
    public void companyUserShouldBeSuccesfullyRegistered() {
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://tester.codersguru.pl/register/confirmed", currentURL);
    }
}
