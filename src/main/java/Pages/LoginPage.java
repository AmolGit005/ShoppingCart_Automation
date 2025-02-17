package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage
{
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    private Page page;

    // Constructor
    public LoginPage(Page page)
    {
        this.page = page;
    }

    // Locators
    private String usernameField = "#user-name";
    private String passwordField = "#password";
    private String loginButton = "#login-button";


    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        page.fill(usernameField, username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password: " + password);
        page.fill(passwordField, password);
    }

    public void clickLoginButton() {
        logger.info("Clicking on login button");
        page.click(loginButton);
    }
}
