package reportings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class SetUp implements ITestListener {
    private static ExtentReports extentReports;


    public void onStart(ITestContext context) {
        extentReports = ExtentReportManager.getInstance();
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public void onTestStart(ITestResult result) {
        if (extentReports == null) {
            extentReports = ExtentReportManager.getInstance();
        }
        String testName = result.getTestClass().getName() + "-" + result.getMethod().getMethodName();
        ExtentReportManager.startTest(testName);
    }

    public void onTestFailure(ITestResult result) {
        // ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedTrace = "<details>\n" +
                "  <summary>Click here to view the exception details</summary>\n" +
                "  " + stackTrace + "\n" +
                "</details>\n";

        //ExtentReportManager.logFailureDetails(formattedTrace);
        ExtentReportManager.logFailureException(formattedTrace);


    }

}
