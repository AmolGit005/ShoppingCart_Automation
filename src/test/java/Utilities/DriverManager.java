package Utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class DriverManager
{

    public static Browser browser;

    public static void setUpBrowser() {
        String headless = System.getProperty("headless", "false");
        Boolean enableHeadless = false;
        if(headless.equals("true")) {
            enableHeadless = true;
        }

        Playwright Browser = Playwright.create();
        browser = Browser.chromium().launch(new BrowserType.LaunchOptions().setHeadless(enableHeadless).setTimeout(60000));
    }

    public static void tearDownBrowser() {
        if (browser != null) {
            browser.contexts().clear();
            browser.close();
            browser = null;
        }
    }

    public static Browser getBrowser() {
        return browser;
    }
}
