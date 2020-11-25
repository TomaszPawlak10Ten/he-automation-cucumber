package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.ArchiveSearchResultsPage;
import pageObjects.FindPhotosPage;
import pageObjects.HomePage;

/** Not sure why the data table isn't working */

public class FindPhotos {

    WebDriver driver;
    HomePage homePage;
    FindPhotosPage findPhotosPage;
    ArchiveSearchResultsPage archiveSearchResultsPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
    }

    @Given("I am on the Find Photos page")
    public void i_am_on_the_find_photos_page() {
        homePage = new HomePage(driver);
        homePage.clickImagesNavigation();
        homePage.clickFindPhotosLink();
    }

    @When("I search for <search term>")
    public void iSearchForSearchTerm(String searchTerm) {
        findPhotosPage = new FindPhotosPage(driver);
        findPhotosPage.enterSearchTerm(searchTerm);
        findPhotosPage.submitSearch();
    }

//    @When("I search for <search term>")
//    public void i_search_for_search_term(String searchTerm) {
//        findPhotosPage.enterSearchTerm(searchTerm);
//        findPhotosPage.submitSearch();
//    }
//
//    @When("I search for <search term>")
//    public void i_search_for_fish(String searchTerm) {
//       findPhotosPage.enterSearchTerm(searchTerm);
//       findPhotosPage.submitSearch();
//    }

    @Then("I should be taken to the results page")
    public void i_should_be_taken_to_the_results_page() {
        ArchiveSearchResultsPage archiveSearchResultsPage = new ArchiveSearchResultsPage(driver);
        Assert.assertTrue(archiveSearchResultsPage.photoResultsPageHeadingIsDisplayed().contains("Archive search results"));
    }

    public void tearDown(){
        driver.quit();
    }



}
