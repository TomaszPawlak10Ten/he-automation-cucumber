package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccessibilityStatementPage {

    public AccessibilityStatementPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using = "page-title")
    private WebElement accessibilityPageTitle;

    public void verifyAccessibilityPageTitle(){
        accessibilityPageTitle.isDisplayed();

    }
}
