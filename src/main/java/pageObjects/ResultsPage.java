package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    WebDriver driver;

    public ResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#main-content > div:nth-child(3) > div > div > h2")
    private WebElement searchResultsOverviewHeading;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement photoResultsPageHeading;

    @FindBy(how = How.CSS, using = ".nhle-list-entry__items-container dl:nth-child(3) dd")
    private WebElement listEntryNumber;

    public void searchResultPageIsOpen(){
        searchResultsOverviewHeading.isDisplayed();
    }

    public void photoResultsPageHeadingIsDisplayed(){
        photoResultsPageHeading.isDisplayed();
    }

}
