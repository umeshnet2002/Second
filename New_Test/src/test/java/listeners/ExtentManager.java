package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config().setReportName(
                    "Para Bank Automation Report");

            spark.config().setDocumentTitle(
                    "Automation Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Tester", "Umesh");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + Cucumber + TestNG");
        }

        return extent;
    }
}