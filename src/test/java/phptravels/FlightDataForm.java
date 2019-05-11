package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FlightDataForm {
    WebDriver driver;

    public FlightDataForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//    @FindBy (id = "s2id_location_from")
//    private WebElement fromField;
//
//    @FindBy (className = "form form-control input-lg departureTime")
//    private WebElement ToField;
//
//    @FindBy (className = "form form-control input-lg departureTime")
//    private WebElement dateField;
//
//    @FindBy (className = "btn-primary btn btn-lg btn-block pfb0")
//    private WebElement submitButton;

    Select dprFrom = new Select(driver.findElement(By.className("s2id_location_from")));

    public void fillOutFlightDataForm(){


    }

}


