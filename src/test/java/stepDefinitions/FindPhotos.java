package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.FindPhotosPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class FindPhotos {

    WebDriver driver;
    HomePage homePage;
    FindPhotosPage findPhotosPage;
    ResultsPage resultsPage;

    @Given("I am on the Find Photos page")
    public void i_am_on_the_find_photos_page() {
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.clickImagesNavigation();
        homePage.clickFindPhotosLink();
    }

    @When("I search for andover")
    public void i_search_for_andover(String searchTerm) {
        findPhotosPage = new FindPhotosPage(driver);
        findPhotosPage.enterSearchTerm(searchTerm);
        findPhotosPage.submitSearch();
    }

    @When("I search for castle")
    public void i_search_for_castle(String searchTerm) {
        findPhotosPage.enterSearchTerm(searchTerm);
        findPhotosPage.submitSearch();
    }

    @When("I search for fish")
    public void i_search_for_fish(String searchTerm) {
        findPhotosPage.enterSearchTerm(searchTerm);
        findPhotosPage.submitSearch();
    }

    @Then("I should be taken to the results page")
    public void i_should_be_taken_to_the_results_page() {
        resultsPage = new ResultsPage(driver);
        resultsPage.photoResultsPageHeadingIsDisplayed();
        driver.quit();
    }

}
