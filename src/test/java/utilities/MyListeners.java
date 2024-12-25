package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyListeners implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports commonReport;
    ExtentTest testReports;

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\spark_report" + timeStamp);
        sparkReporter.config().setDocumentTitle("Opencart Report");
        sparkReporter.config().setReportName("Opencart functional testing Report");
        commonReport = new ExtentReports();
        commonReport.attachReporter(sparkReporter);
        commonReport.setSystemInfo("Application", "Opencart");
        commonReport.setSystemInfo("Module", "Home");
        commonReport.setSystemInfo("Username", System.getProperty("user.name"));
        //String os = System.getProperty("os").toLowerCase();
        //String browser = System.getProperty("browser").toLowerCase();
        //commonReport.setSystemInfo("OS", os);
        //commonReport.setSystemInfo("Browser", browser);
        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        List<String> excludedGroups = context.getCurrentXmlTest().getExcludedGroups();
        if (!includedGroups.isEmpty()) {
            commonReport.setSystemInfo("Groups",includedGroups.toString());
        }
        if (!excludedGroups.isEmpty()) {
            commonReport.setSystemInfo("Groups",excludedGroups.toString());
        }

    }
    public void onTestSuccess(ITestResult result) {
        testReports = commonReport.createTest(result.getTestClass().getName());
        testReports.assignCategory(result.getMethod().getMethodName());
        testReports.assignCategory(result.getMethod().getGroups());
        testReports.log(Status.PASS,result.getName()+"executed successfully");
    }
    public void onTestFailure(ITestResult result) {
        testReports = commonReport.createTest(result.getTestClass().getName());
        testReports.assignCategory(result.getMethod().getMethodName());
        testReports.assignCategory(result.getMethod().getGroups());
        testReports.log(Status.FAIL,result.getName()+"executed unsuccessfully");
        try
        {
            String imgPath = new BaseTests().captureScreenshot(result.getName());
            testReports.addScreenCaptureFromPath(imgPath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result) {
        testReports = commonReport.createTest(result.getTestClass().getName());
        testReports.assignCategory(result.getMethod().getMethodName());
        testReports.assignCategory(result.getMethod().getGroups());
        testReports.log(Status.SKIP,result.getName()+"execution skipped");
        testReports.log(Status.SKIP,result.getThrowable().getMessage());
    }
    public void onFinish(ITestContext context) {
        commonReport.flush();
    }
}
