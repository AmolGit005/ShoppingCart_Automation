package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager
{
    private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports()
    {
        if (extent == null) {
            // Create ExtentHtmlReporter and attach it to ExtentReports
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static void flushReports()
    {
        if (extent != null) {
            extent.flush();
        }
    }
}
