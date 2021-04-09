//package utils;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Calendar;
//
//public class TestListener implements ITestListener {
//
//    public ThreadLocal<WebDriver> driver;
//
//    protected WebDriver webDriver() {
//        return driver.get();
//    }
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//        Log.info("## " + getTestMethodName(iTestResult) + " test method started.");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//        Log.info("## " + getTestMethodName(iTestResult) + " test method succeed.");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        Log.info("## " + getTestMethodName(iTestResult) + " test method failed.");
//        File file = new File("src/test/resources/" + "screenshot.png");
//        BufferedImage screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(webDriver()).getImage();
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult iTestResult) {
//        Log.info("## " + getTestMethodName(iTestResult) + " test method skipped.");
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//
//    }
//
//    private static String getTestMethodName(ITestResult result) {
//        return result.getMethod().getConstructorOrMethod().getName();
//    }
//}
