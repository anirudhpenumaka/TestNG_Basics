package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javax.imageio.ImageIO;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class SS implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public static WebDriver driver;   // will be used for screenshots

    @Override
    public void onStart(ITestContext context) {

       // sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");

    	//C:\Java Workspace\TestNG_Basics\reports
    	sparkReporter = new ExtentSparkReporter("C:/Java Workspace/TestNG_Basics/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Anirudh");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case FAILED: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        try {
            String screenshotPath = captureScreenshot(result.getName());
            test.fail("Screenshot:",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String captureScreenshot(String testName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";
        File dest = new File(path);

        dest.getParentFile().mkdirs(); // create folder if not exists
        src.renameTo(dest);

        return path;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Case SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();   // saves the report to file

        try {
            File htmlFile = new File(System.getProperty("user.dir") + "/reports/myReport.html");
            Desktop.getDesktop().browse(htmlFile.toURI());  // auto-open report
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
