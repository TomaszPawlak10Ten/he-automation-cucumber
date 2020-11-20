package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import pageObjects.SearchPage;


public class Search {

    HomePage homePage;
    SearchPage search;
    SearchResultsPage result;
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
    }

    @Given("I am on the site search page")
    public void i_am_on_the_site_search_page() {
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage();
    }

    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String searchTerm) {
        search = new SearchPage(driver);
        search.enterSearchTerm(searchTerm);
        search.submitSearch();
    }

    @When("I select the first result")
    public void i_select_the_first_result() {
        search.selectFirstResult();
    }
    @When("I select the articles and web pages filter")
    public void i_select_the_articles_and_web_pages_filter() {
        search.clickFilterResultsButton();
        search.selectArticlesAndWebPagesFilterOption();
        search.clickApplyFiltersButton();
    }

    @Then("only article and web page results should return")
    public void only_article_and_web_page_results_should_return() {
        Assert.assertTrue(search.articlesAndWebPagesTextIsDisplayed().contains("Articles and Web Pages"));
        search.articlesAndWebPagesTextIsDisplayed();
    }

    @Then("a list of results should display")
    public void the_search_should_successfully_run() {
        Assert.assertTrue(search.firstResultIsDisplayed().contains("ANDOVER HOUSE AND ESTATE OFFICE"));
    }

    @Then("a new page should open")
    public void a_new_page_should_open() {
        result = new SearchResultsPage(driver);
        result.searchResultPageIsOpen();
    }

    public void tearDown(){
        driver.quit();
    }
}
