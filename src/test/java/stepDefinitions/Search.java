package stepDefinitions;

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
        homePage.navigateToSearchPage();
    }

    @When("I enter a search term into the search bar")
    public void i_enter_into_the_search_bar(String searchTerm) {
        search.enterSearchTerm(searchTerm);
        search.submitSearch();
    }

    @When("I select the first result")
    public void i_select_the_first_result() {
        search.selectFirstResult();
    }

    @Then("a list of results should display")
    public void the_search_should_successfully_run() {
        search.getListEntryNumber();
    }
    @Then("a new page should open")
    public void a_new_page_should_open() {
        result.searchResultPageIsOpen();
        driver.quit();
    }
}
