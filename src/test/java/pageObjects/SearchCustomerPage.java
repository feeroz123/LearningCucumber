package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver driver;
    WaitHelper waitHelper;
    // Locators of web elements
    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;
    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;
    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;
    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;
    @FindBy(how = How.ID, using = "customers-grid")
    @CacheLookup
    WebElement tblCustomers;
    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tblRows;
    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tblColumns;

    public SearchCustomerPage(WebDriver wdriver) {
        driver = wdriver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    // Actions
    public void setEmail(String email) {
        waitHelper.WaitForElement(txtEmail, 2);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstName) {
        waitHelper.WaitForElement(txtFirstName, 2);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitHelper.WaitForElement(txtLastName, 2);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void clickSearch() {
        btnSearch.click();
        waitHelper.WaitForElement(btnSearch, 10);
    }

    public int getNoOfRows() {
        return tblRows.size();
    }

    public int getNoOfColumns() {
        return tblColumns.size();
    }

    public boolean searchCustomerByEmailId(String email) {
        boolean flag = false;

        for (int i = 1; i <= getNoOfRows(); i++) {
            String foundEmail = tblCustomers.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]")).getText();
            if (foundEmail.equals(email)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean searchCustomerByName(String name) {
        boolean flag = false;

        String[] expectedNames = name.split(" ");

        for (int i = 1; i <= getNoOfRows(); i++) {
            String foundName = tblCustomers.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]")).getText();
            String[] foundNames = foundName.split(" ");

            if (foundNames[0].equals(expectedNames[0]) && foundNames[1].equals(expectedNames[1])) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
