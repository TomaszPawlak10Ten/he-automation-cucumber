package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindPhotosPage {

    public FindPhotosPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "solrSearch")
    private WebElement searchBar;

    @FindBy(how = How.ID, using = "btnQuickSearch")
    private WebElement submitSearchButton;

    public void enterSearchTerm(String searchTerm){
        searchBar.sendKeys(searchTerm);
    }

    public void submitSearch(){
        submitSearchButton.click();
    }
}
