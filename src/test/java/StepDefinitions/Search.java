package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.ResultsPage;
import pageObjects.SearchPage;


public class Search {

    HomePage homePage;
    SearchPage search;
    ResultsPage result;
    WebDriver driver;

    @Given("I am on the site search page")
    public void i_am_on_the_site_search_page() {
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
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
        search.articlesAndWebPagesTextIsDisplayed();
    }

    @Then("a list of results should display")
    public void the_search_should_successfully_run() {
        search.firstResultIsDisplayed();
    }

    @Then("a new page should open")
    public void a_new_page_should_open() {
        result = new ResultsPage(driver);
        result.searchResultPageIsOpen();
        driver.quit();
    }
}
