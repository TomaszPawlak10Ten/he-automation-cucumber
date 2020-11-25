package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {

    WebDriver driver;

    public NewsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "h1")
    private WebElement newsPageHeading;

    @FindBy(how = How.CSS, using = "#main > div.outer-container > div > div > div > div > div > button")
    private WebElement printButton;

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement printPreviewHeading;


    public String newsPageIsLoaded(){
        return newsPageHeading.getText();
    }

    public void clickPrintButton(){
        printButton.click();
    }

    public void switchToPrintPreviewAndCancel(){
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar').ShadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cancel-button').click();");

    }





}
