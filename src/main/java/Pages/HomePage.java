package Pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class HomePage
{
    private static final Logger logger = (Logger) LogManager.getLogger(HomePage.class);
    private Page page;

    // Locator
    private String homepageIdentifier = "div.product_label";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isHomePageDisplayed() {
        boolean displayed = page.isVisible(homepageIdentifier);
        logger.info("Homepage is " + (displayed ? "displayed" : "not displayed"));
        return displayed;
    }
}
