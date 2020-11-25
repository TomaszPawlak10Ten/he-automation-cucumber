package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.CLASS_NAME, using = "header-bar__search-button-link")
    private WebElement searchTheSiteButton;

    @FindBy(how = How.CSS, using = "a[href*=\"/access/\"]")
    private WebElement accessibilityLink;

    @FindBy(how = How.CSS, using = ".navigation-primary__level-1 a[href*=\"/images-books/\"]")
    private WebElement imagesAndBooksNavLink;

    @FindBy(how = How.CSS, using = "#navigation-primary__level-2--images-books > div > div:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement findPhotosLink;

    @FindBy(how = How.CSS, using = "#navigation-primary > ul > li:nth-child(8) > div.navigation-primary__level-1 > a")
    private WebElement whatsNewNavLink;

    @FindBy(how = How.CSS, using = ".navigation-primary__level-2-list-item a[href=\"/whats-new/news/\"]")
    private WebElement newsLink;

    public void navigateToSearchPage(){
        searchTheSiteButton.click();
    }

    public void scrollToAccessibilityLink(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", accessibilityLink);
    }

    public void navigateToAccessibilityPage(){
        accessibilityLink.click();
    }

    public void clickImagesNavigation(){
        imagesAndBooksNavLink.click();
    }

    public void clickFindPhotosLink(){
        findPhotosLink.click();
    }

    public void clickWhatsNewNavigation(){
        whatsNewNavLink.click();
    }

    public void clickNewsLink(){
        newsLink.click();
    }

}
