package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    public WebDriver driver;

    public AddCustomerPage(WebDriver wdriver) {
        driver = wdriver;
        PageFactory.initElements(driver, this);
    }


    // Locators for web elements
    By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(), 'Customers')]");
    By lnkCustomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List' and contains(@class, 'nav-link')]");

    By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']");

    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");
    By txtFirstName = By.id("FirstName");
    By txtLastName = By.id("LastName");
    By radioGenderMale = By.id("Gender_Male");
    By radioGenderFemale = By.id("Gender_Female");

    By btnSave = By.name("save");

    // Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnCustomersMenu() {
        driver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        driver.findElement(lnkCustomers_menuItem).click();
    }

    public void clickOnAddNew() {
        driver.findElement(btnAddNew).click();
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void setFirstName(String firstName) {
        driver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(txtLastName).sendKeys(lastName);
    }

    public void selectGenderMale() {
        driver.findElement(radioGenderMale).click();
    }

    public void selectGenderFemale() {
        driver.findElement(radioGenderFemale).click();
    }

    public void clickOnSave() {
        driver.findElement(btnSave).click();
    }

}
