package StepDefinitions;

import io.cucumber.java.After;
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

public class ArchiveSearchResults {

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

    @Given("I have searched for {string} in the find photos search bar")
    public void i_have_searched_for_in_the_find_photos_search_bar(String string) {
        homePage = new HomePage(driver);
        homePage.clickImagesNavigation();
        homePage.clickFindPhotosLink();

        findPhotosPage = new FindPhotosPage(driver);
        findPhotosPage.enterSearchTerm(string);
        findPhotosPage.submitSearch();
    }

    @Given("I click on the Filter Results button")
    public void i_click_on_the_filter_results_button() {
        archiveSearchResultsPage = new ArchiveSearchResultsPage(driver);
        archiveSearchResultsPage.clickFilterResultsButton();
    }

    @When("I type {string} into the County field and select Hampshire from the drop down")
    public void i_type_into_the_county_unitary_authority_field_and_select_hampshire_from_the_drop_down(String searchTerm) {
        archiveSearchResultsPage.enterSearchTermIntoCountyFilter(searchTerm);
    }

    @When("I type {string} into the District field and select Winchester from the drop down")
    public void i_type_into_the_district_borough_field_and_select_winchester_from_the_drop_down(String searchTerm) {
        archiveSearchResultsPage.enterSearchTermIntoDistrictFilter(searchTerm);
    }

    @When("I type {string} into the After Date field")
    public void i_type_into_the_after_date_field(String date) {
        archiveSearchResultsPage.enterAfterDate(date);
    }

    @When("I type {string} into the Before Date field")
    public void i_type_into_the_before_date_field(String date) {
        archiveSearchResultsPage.enterBeforeDate(date);
    }

    @When("I type {string} into the Building Type field and select Castle")
    public void i_type_into_the_building_type_field_and_select_castle(String buildingType) {
        archiveSearchResultsPage.enterSearchTermIntoBuildingTypeFilter(buildingType);
    }

    @When("I click on the Apply Filters button")
    public void i_click_on_the_apply_filters_button() {
        archiveSearchResultsPage.clickApplyFiltersButton();
    }

    @Then("twenty three results should be returned")
    public void results_should_be_returned() {
        Assert.assertTrue(archiveSearchResultsPage.verifyNumberOfSearchResults().contains("23"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
