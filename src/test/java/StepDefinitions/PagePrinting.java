package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.NewsPage;

/** I can't work out where I'm going wrong here. Getting this error: java.lang.NullPointerException:
Cannot invoke "org.openqa.selenium.SearchContext.findElement(org.openqa.selenium.By)" because "this.searchContext" is null
 */

public class PagePrinting {

    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//r2williams//IdeaProjects//historic-england-practice//src//main//resources//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://stage.historic-england.org/");
        driver.manage().window().maximize();
    }

    @Given("I am on the News page")
    public void i_am_on_the_news_page() {
        HomePage homePage = new HomePage(driver);
        homePage.clickWhatsNewNavigation();
        homePage.clickNewsLink();
        NewsPage newsPage = new NewsPage(driver);
        Assert.assertTrue(newsPage.newsPageIsLoaded().contains("News"));
    }


    @When("I click on the print button")
    public void i_click_on_the_print_button() {
        newsPage.clickPrintButton();
    }


    @Then("a print preview should open and I can click cancel")
    public void a_print_preview_should_open_and_i_can_click_cancel() {
        newsPage.switchToPrintPreviewAndCancel();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
