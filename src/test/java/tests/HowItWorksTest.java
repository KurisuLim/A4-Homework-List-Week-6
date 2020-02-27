package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowItWorksPage;

public class HowItWorksTest extends BaseTest {

    HomePage homePage = new HomePage(driver);
    HowItWorksPage page = new HowItWorksPage(driver);

    @BeforeTest
    public void howItWorksPage(){
        homePage.openHomePage()
                .goToHowItWorks();
    }

    @Test
    public void getPageTitle(){
        page.waitVisibility(page.pageTitle);
        Assert.assertEquals(page.getText(page.pageTitle), "HOW IT WORKS");
    }
}
