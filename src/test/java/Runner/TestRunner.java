package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        tags = "@LoginTest",
        plugin = {
                "pretty", // Console output
                "html:Reports/HTMLReports/cucumber-reports.html", // HTML report
                "json:Reports/JSONReports/cucumber-reports.json", // JSON report
                "junit:Reports/XMLReports/cucumber-reports.xml" // JUnit XML report
                },
        monochrome = true,
        dryRun = false
       )

public class TestRunner
{

}
