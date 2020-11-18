package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "solrSearch")
    private WebElement searchBar;

    @FindBy(how = How.ID, using = "btnQuickSearch")
    private WebElement searchSubmitButton;

    @FindBy(how = How.CSS, using = "a[href*=\"1262080\"]")
    private WebElement firstResult;

    @FindBy(how = How.CLASS_NAME, using = "search-banner__filters--filters-results-button")
    private WebElement filterResultsButton;

    @FindBy(how = How.CSS, using = "[title~=\"Articles\"]")
    private WebElement articlesAndWebPagesFilter;

    @FindBy(how = How.ID, using = "filtersubmit")
    private WebElement applyFiltersButton;

    @FindBy(how = How.CLASS_NAME, using = "green-text-bold")
    private WebElement articlesAndWebPagesText;


    public void enterSearchTerm(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public void submitSearch(){
        searchSubmitButton.submit();
    }

    public void firstResultIsDisplayed(){
        firstResult.isDisplayed();
    }

    public void selectFirstResult(){
        firstResult.click();
    }

    public void clickFilterResultsButton(){
        filterResultsButton.click();
    }

    public void selectArticlesAndWebPagesFilterOption(){
        articlesAndWebPagesFilter.click();
    }

    public void clickApplyFiltersButton(){
        applyFiltersButton.click();
    }

    public void articlesAndWebPagesTextIsDisplayed(){
        articlesAndWebPagesText.isDisplayed();
    }
}
