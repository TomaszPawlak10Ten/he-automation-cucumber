package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#main-content > div:nth-child(3) > div > div > h2")
    private WebElement overviewHeading;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement photoResultsPageHeading;

    public void searchResultPageIsOpen(){
        overviewHeading.isDisplayed();
    }

    public void photoResultsPageHeadingIsDisplayed(){
        photoResultsPageHeading.isDisplayed();
    }



}