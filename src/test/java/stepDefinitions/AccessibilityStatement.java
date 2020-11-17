package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AccessibilityStatementPage;
import pageObjects.HomePage;

public class AccessibilityStatement {

    WebDriver driver;
    HomePage homePage;
    AccessibilityStatementPage accessibilityStatementPage;


    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
    }

    @When("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() {
        homePage.scrollToAccessibilityLink();
    }

    @When("I click on the Accessibility link")
    public void i_click_on_the_accessibility_link(){
        homePage.navigateToAccessibilityPage();
    }

    @Then("I should be taken to the Accessibility statement")
    public void i_should_be_taken_to_the_accessibility_statement() {
        accessibilityStatementPage.verifyAccessibilityPageTitle();
        driver.quit();
    }


}
