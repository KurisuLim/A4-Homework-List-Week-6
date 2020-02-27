package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/*
A4 – Homework – Refactor your tests using the advantages of TestNG framework:
JAVA AUTOMATION A4  A4 – Homework – Refactor your tests using the advantages of TestNG framework:

Refactor your tests using the advantages of TestNG framework:
1. Create Before Method and After methods to close and open browser
2. Create BaseTest file and move setup and teardown there
*/

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp(){
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

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
