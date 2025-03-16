package reportings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    private  static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("UTF-8");

        extentReports =  new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static synchronized ExtentReports getInstance(){
        if( extentReports == null){
            initializeReport();
        }
        return extentReports;
    }

    private static void initializeReport(){
        String fileName =getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir")+"/target/extentReports/" + fileName;
        createInstance(fullReportPath,"Test API Automation Report","Test Execution details");
    }

    public static void startTest(String testName) {
        ExtentTest test = getInstance().createTest(testName);
        extentTest.set(test);
    }

    private static ExtentTest getTest(){
        ExtentTest test = extentTest.get();
        if(test== null){
            throw  new IllegalStateException("ExtentTest is not initialized. Ensure onTestStart() is setting the test instance");
        }
        return test;
    }

    public static String getReportNameWithTimeStamp(){
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatedDateTime= dateTimeFormatter.format(localDateTime);
        String reportName = "TestReports"+ formatedDateTime +".html";
        return reportName;
    }

    public static void logPassDetails(String log){
        getTest().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailureDetails(String log){
        getTest().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfoDetails(String log){
        getTest().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logWarningDetails(String log){
        getTest().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }


}
