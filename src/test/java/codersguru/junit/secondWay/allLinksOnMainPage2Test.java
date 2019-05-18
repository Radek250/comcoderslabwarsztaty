package codersguru.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class allLinksOnMainPage2Test {

    WebDriver driver;


    @Before

    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://tester.codersguru.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void allLinksTest() {

        WebElement mainLogo = driver.findElement(By.className("header__logo-img"));
        mainLogo.click();
        driver.navigate().back();

        WebElement howItWorks = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/nav/ul/li[1]/a"));
        howItWorks.click();
        driver.navigate().back();

        WebElement priceList = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/nav/ul/li[2]/a"));
        priceList.click();
        driver.navigate().back();

        WebElement becomeAMentor = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/nav/ul/li[3]/a"));
        becomeAMentor.click();
        driver.navigate().back();

        WebElement signIn = driver.findElement(By.className("header__button"));
        signIn.click();
        driver.navigate().back();

        WebElement signUp = driver.findElement(By.className("link main-page-top__email-input-sent"));
        signUp.click();
        driver.navigate().back();

        WebElement email = driver.findElement(By.className("main-page-contact__link link"));
        email.click();
        driver.navigate().back();

        WebElement regulations = driver.findElement(By.className("link link--grey"));
        regulations.click();
        driver.navigate().back();

        WebElement howItWorksDownPage = driver.findElement(By.xpath("/html/body/footer/div/div[1]/a[2]"));
        howItWorksDownPage.click();
        driver.navigate().back();

        WebElement facebook = driver.findElement(By.xpath("/html/body/footer/div/div[2]/a/img"));
        facebook.click();
        driver.navigate().back();

        WebElement coderslab = driver.findElement(By.className("link link--grey"));
        coderslab.click();
        driver.navigate().back();
    }


    @After
    public void tearDown() {
        //driver.quit();
    }

}
