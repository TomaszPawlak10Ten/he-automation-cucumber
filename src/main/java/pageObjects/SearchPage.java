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
}
