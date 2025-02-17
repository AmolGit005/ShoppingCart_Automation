package StepDefinitions;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Configuarations;
import Utilities.ExtentReportManager;
import Utilities.PlaywrightFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;

import java.io.IOException;

public class LoginPageSteps extends BasePage
{
    private static final Logger logger = (Logger) LogManager.getLogger(LoginPageSteps.class);
    private Page page;
    private LoginPage loginPage;
    private HomePage homePage;

    // Create an ExtentTest instance for logging test steps in the report
    private static ExtentReports extent = ExtentReportManager.getExtentReports();
    private ExtentTest test;


    @Given("User launches the swag labs url")
    public void user_launches_the_swag_labs_url() throws IOException, InterruptedException
    {
        test = extent.createTest("Login Test", "User logs in with valid credentials");
        page = PlaywrightFactory.initBrowser();
        logger.info("Navigating to login page");
        test.info("Navigating to login page");
        page.navigate("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(page);

    }
    @When("User insert {string} in username field")
    public void user_insert_in_username_field(String username)
    {
        logger.info("Entering credentials");
        test.info("Entering username");
        loginPage.enterUsername(username);
    }
    @When("User insert the {string} in password field")
    public void user_insert_the_in_password_field(String password)
    {
        logger.info("Entering credentials");
        test.info("Entering Password");
        loginPage.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton()
    {
        logger.info("Clicking login button");
        test.info("Clicking login button");
        loginPage.clickLoginButton();
    }

    @Then("Verify the swag labs products title in home")
    public void verifyTheSwagLabsProductsTitleInHome()
    {
        homePage = new HomePage(page);
        logger.info("Verifying if homepage is displayed");
        test.info("Verifying homepage display");
        Assert.assertTrue("Homepage is not displayed", homePage.isHomePageDisplayed());
        PlaywrightFactory.closeBrowser();
        test.pass("User successfully logged in and homepage is displayed");
    }
}
