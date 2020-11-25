package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArchiveSearchResultsPage {


    WebDriver driver;

    public ArchiveSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "archive-search-open-filter-button")
    private WebElement filterResultsButton;

    @FindBy(how = How.ID, using = "facet_hid_county")
    private WebElement countyFilter;

    @FindBy(how = How.ID, using = "facet_hid_district")
    private WebElement districtFilter;

    @FindBy(how = How.ID, using = "facet_hid_dateFrom")
    private WebElement afterDateField;

    @FindBy(how = How.ID, using = "facet_hid_dateTo")
    private WebElement beforeDateField;

    @FindBy(how = How.ID, using = "archive-search-filters__input-building-type")
    private WebElement buildingTypeField;

    @FindBy(how = How.CSS, using = "#archive-search-filters-container > form > div:nth-child(10) > button.archive-search-filters__filter-button.archive-search-filters__filter-button--apply.btn")
    private WebElement applyFiltersButton;

    @FindBy(how = How.ID, using = "archive-search-results-count")
    private WebElement numberOfResults;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement photoResultsPageHeading;

    @FindBy(how = How.CSS, using = "a[href*=\"09831/32\"]")
    private WebElement imageDetailsPageLink;


    public void clickFilterResultsButton(){
        filterResultsButton.click();
    }

    public void enterSearchTermIntoCountyFilter(String searchTerm){
        countyFilter.sendKeys(searchTerm);
    }

    public void enterSearchTermIntoDistrictFilter(String searchTerm){
        districtFilter.sendKeys(searchTerm);
    }

    public void enterAfterDate(String date){
        afterDateField.sendKeys(date);
    }

    public void enterBeforeDate(String date){
        beforeDateField.sendKeys(date);
    }

    public void enterSearchTermIntoBuildingTypeFilter(String buildingType){
        buildingTypeField.sendKeys(buildingType);
    }

    public void clickApplyFiltersButton(){
        applyFiltersButton.click();
    }

    public String verifyNumberOfSearchResults(){
        return numberOfResults.getText();
    }

    public String photoResultsPageHeadingIsDisplayed(){
        return photoResultsPageHeading.getText();
    }

    public void clickImageDetailsPageLink(){
         imageDetailsPageLink.click();
    }


}