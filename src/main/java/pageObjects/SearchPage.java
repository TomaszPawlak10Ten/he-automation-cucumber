package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "solrSearch")
    private WebElement searchBar;

    @FindBy(how = How.ID, using = "btnQuickSearch")
    private WebElement searchSubmitButton;

    @FindBy(how = How.CSS, using = "a[href*=\"1262080\"]")
    private WebElement firstResult;

    @FindBy(how = How.CSS, using = "#main-content > div:nth-child(3) > div > div > div > dl:nth-child(3) > dd")
    private WebElement listEntryNumber;


    public void enterSearchTerm(String searchTerm) {
        searchBar.sendKeys(searchTerm);
    }

    public void submitSearch(){
        searchSubmitButton.submit();
    }

    public void selectFirstResult(){
        firstResult.click();
    }

    public void getListEntryNumber(){
        listEntryNumber.isDisplayed();
    }
}
