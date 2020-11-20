//package base;
//
//import com.google.common.io.Files;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//
//import java.io.File;
//import java.io.IOException;
//
//public class BaseTests {
//
//    WebDriver driver;
//
//
//    @AfterMethod
//    public void recordFailedTest(ITestResult result){
//
//        if (ITestResult.FAILURE == result.getStatus())
//        {
//            var camera = (TakesScreenshot)driver;
//            File screenshot = camera.getScreenshotAs(OutputType.FILE);
//            try {
//                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//
//
//    }
//
//
//
//}}
