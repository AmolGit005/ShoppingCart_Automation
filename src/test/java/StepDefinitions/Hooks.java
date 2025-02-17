package StepDefinitions;

import Pages.BasePage;
import Utilities.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Hooks extends BasePage
{
    private static final Logger logger = (Logger) LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("Test execution started");
        // Optionally, initialize additional reporting setup
        ExtentReportManager.getExtentReports();
    }

    @After
    public void tearDown() {
        logger.info("Test execution finished");
        ExtentReportManager.flushReports();
    }
}
