package codersguru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class ChooseMentor {
    WebDriver driver;

    public ChooseMentor(WebDriver driver){

        this.driver = driver;
    }

    public void goToBookADatePage(){

        WebElement goToReservationPage = driver.findElement
                (By.xpath("/html/body/main/div[2]/div/div[8]/div/div[2]/div[2]/button"));
        goToReservationPage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
