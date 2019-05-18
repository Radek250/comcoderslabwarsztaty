package codersguru.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class allLinkOnMainPageTest {
    // zadanie #1 w którym stosujemy tylko JUnit
    WebDriver driver;
    HttpURLConnection huc = null;
    int respCode = 200;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "/home/radek/IdeaProjects/comcoderslabwarsztaty/src/resource/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testAllLinks() throws InterruptedException {
        driver.get("https://tester.codersguru.pl/");
        // tu zbieramy wszystkie linki



        List<String> links = new ArrayList<String>();
        List<WebElement> allLinkElements = driver.findElements(By.tagName("a"));
        // pozniej w nie klikamy i
        // sprawdzamy czy przekierowały nas na istniejącą stronę
        for (WebElement e : allLinkElements) {
            String link = e.getAttribute("href");
            if (!link.startsWith("mailto:")) {
                links.add(link);
            } else {
                if (isValid(link.split(":")[1])) {
                    System.out.println("Mail jest ok: " + link);
                } else {
                    System.out.println("Ooooooo nie! Nie działa ten link: " + link);
                }

            }
        }

        for (String link : links) {
            // driver.get(link);
            // sprawdz czy strona załadowałą się poprawnie
            // skopiowane z: https://www.guru99.com/find-broken-links-selenium-webdriver.html
            try {
                huc = (HttpURLConnection) (new URL(link).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();

                if (respCode >= 300) {
                    System.out.println("Ooooooo nie! Nie działa ten link: " + link);
                } else {
                    System.out.println(link + " is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        WebElement submitbutton = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        submitbutton.click();
        Thread.sleep(2000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://tester.codersguru.pl/register/");


    }

    // metoda pomocnicza z owasp
    // https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }





}