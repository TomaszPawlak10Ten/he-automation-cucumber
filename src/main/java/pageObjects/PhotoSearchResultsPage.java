package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PhotoSearchResultsPage {

    WebDriver driver;

    public PhotoSearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement photoResultsPageHeading;

    public void photoResultsPageHeadingIsDisplayed(){
        photoResultsPageHeading.isDisplayed();
    }

}
