package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HowItWorksPage extends BasePage {
    public HowItWorksPage(WebDriver driver) {
        super(driver);
    }

    public By pageTitle = By.cssSelector(".navbar-header a.navbar-brand");
}
