package Utilities;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PlaywrightFactory
{
    private static final Logger logger = (Logger) LogManager.getLogger(PlaywrightFactory.class);
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page initBrowser() {
        logger.info("Initializing Playwright browser");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public static void closeBrowser() {
        logger.info("Closing browser");
        context.close();
        browser.close();
        playwright.close();
    }

}
