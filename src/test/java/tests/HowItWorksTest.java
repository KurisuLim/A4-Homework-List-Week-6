package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/*
A4 – Homework – Lists – Find Elements . – practice
Find Elements:
1. Open Any Trip Listing Page, for example:
  https://deens.com/book/trip/fun-getaway-with-friends-in-london-in-greater-london-county_5be9ecaa7a5b0d2bc5980e0b
take the trip name from each trip on listing page
2. then click to individual trip name link you will be landed on the Trip details page, like:
  https://deens.com/book/accommodation/sohostel-in-london_5bb61189a965f27332f9ea7aYou
  need to verify that trip’s name on Trip details page are equal to the title from Trip Listing page

  Notes for the Code Reviewer:
  I talked to Azat and he told me to use https://testkwidos.tk/
  And please do not expect me to use @BeforeTest @AfterTest methods.
  Since this is not the scope of this work and it will be ask on the next home work.

  Thank you

  So here is the scenario for this Test.
  Scenario: As a User I want to navigate to "How it Works"
  Given I am on https://testkwidos.tk/
  And I click "How it Works"
  Then I should get the "How it Works" Page title
*/
public class HowItWorksTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement howItWorks, pageTitle;

    @Test
    public void getPageTitle(){
        // initialize the chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","--disable-gpu",
                "--whitelisted-ips", "--no-sandbox", "--disable-infobars",
                "--disable-dev-shm-usage", "--disable-browser-side-navigation");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);

        driver.get("https://testkwidos.tk/");

        howItWorks = driver.findElement(By.cssSelector("a[href*='/how-it-works']"));
        wait.until(ExpectedConditions.visibilityOf(howItWorks));
        howItWorks.click();

        pageTitle = driver.findElement(By.cssSelector(".navbar-header a.navbar-brand"));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        Assert.assertEquals(pageTitle.getText(), "HOW IT WORKS");

        //close the browser
        driver.quit();

    }

}
