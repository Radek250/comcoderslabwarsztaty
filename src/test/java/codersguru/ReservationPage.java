package codersguru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservationPage {
    WebDriver driver;

    public ReservationPage(WebDriver driver){

        this.driver = driver;
    }

    private By chooseDate = By.xpath("//*[@id=\"dateSelect\"]/ul/li[3]");
    private By chooseHour = By.xpath("//*[@id=\"hourSelect\"]/ul/li[2]");
    private By messageBox = By.className("reservation__modal-textarea");
    private By submitButton = By.xpath("//*[@id=\"reservationModal\"]/div/div/div[2]/div[2]/div[3]/a/button");

    public void printList(){
            WebElement bookADate = driver.findElement(chooseDate);
            bookADate.click();

            WebElement hourOfLesson = driver.findElement(chooseHour);
            hourOfLesson.click();

            WebElement describeProblem = driver.findElement(messageBox);
            describeProblem.sendKeys("I am going to study hard!");

            WebElement reserveAndPay = driver.findElement(submitButton);
            reserveAndPay.click();
    }

}
