package phptravels;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReserveAFlightSteps {
    WebDriver driver;

    @Given("^I open site phptravels\\.net$")
    public void iOpenSitePhptravelsNet() {
        System.setProperty("webdriver.gecko.driver",
                "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net//");
    }

    @When("^I choose flight in menu$")
    public void iChooseFlightInMenu() {
        MainPage main = new MainPage(driver);
        main.goToFlights();
        Assert.assertTrue(main.isLoaded());
    }

    @And("^I fill out form to find the flight from \"([^\"]*)\" to \"([^\"]*)\" on \"([^\"]*)\" and come back on \"([^\"]*)\"$")
    public void iFillOutFormToFindTheFlightFromToOnAndComeBackOn(String arg0, String arg1, String arg2, String arg3) {
        // Write code here that turns the phrase above into concrete actions
    }


    @And("^I choose the flight$")
    public void iChooseTheFlight() {
    }


    @And("^I fill out contact data form by \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillOutContactDataFormBy(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5)  {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Flight should be reserved$")
    public void flightShouldBeReserved() {
    }



}
