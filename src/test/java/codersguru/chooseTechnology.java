package codersguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class chooseTechnology {
    WebDriver driver;


    public chooseTechnology(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "select-text-desktop")
    private WebElement technologyField;

    //xpath zdefiniowany ponizej wybiera technologię, jesli chcesz ją zmienić - podmień ścieżkę xpath
    @FindBy (xpath = "/html/body/section[3]/div/div[1]/div/ul/li[8]")
    private WebElement chooseTech;

    @FindBy (xpath = "/html/body/section[3]/div/div[1]/input")
    private WebElement findMentorButton;

    public void findMentor(){
        technologyField.click();
        technologyField.click();
        chooseTech.click();
        findMentorButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


}
