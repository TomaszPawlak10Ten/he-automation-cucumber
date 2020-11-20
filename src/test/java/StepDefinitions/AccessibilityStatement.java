package StepDefinitions;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pageObjects.AccessibilityStatementPage;
import pageObjects.HomePage;

import java.io.File;
import java.io.IOException;

public class AccessibilityStatement {

    WebDriver driver;
    HomePage homePage;
    AccessibilityStatementPage accessibilityStatementPage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://stage.historic-england.org/");
    }

    @When("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() {
        homePage = new HomePage(driver);
        homePage.scrollToAccessibilityLink();
    }

    @When("I click on the Accessibility link")
    public void i_click_on_the_accessibility_link(){
        homePage.navigateToAccessibilityPage();
    }

    @Then("I should be taken to the Accessibility statement")
    public void i_should_be_taken_to_the_accessibility_statement() {
        accessibilityStatementPage = new AccessibilityStatementPage(driver);
        Assert.assertTrue(accessibilityStatementPage.verifyAccessibilityPageTitle().contains("Our Website Accessibility 2+2"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @AfterMethod
    public void recordFailedTest(ITestResult result){

        if (ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

}
}
