package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //constructor
    public HomePage (WebDriver driver){
        super(driver);
    }
    //base url
    final String BASE_URL = "https://testkwidos.tk/";

    //page elements
    private By howItWorks = By.cssSelector("a[href*='/how-it-works']");

    public HomePage openHomePage() {
        driver.get(BASE_URL);
        return this;
    }

    public HowItWorksPage goToHowItWorks(){
        waitForClick(howItWorks);
        return new HowItWorksPage(driver);
    }
}
