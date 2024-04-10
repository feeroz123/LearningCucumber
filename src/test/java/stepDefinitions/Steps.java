package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.time.Duration;


public class Steps extends BaseClass {

    // Login methods
    @Given("User launches Chrome Browser")
    public void user_launches_chrome_browser() {
        logger.info("Launched Chrome Browser");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        loginPage.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
    }

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link() {
        loginPage.clickLogout();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    // Add Customer methods
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCustomerPage = new AddCustomerPage(driver);

        Assert.assertEquals("Dashboard / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User clicks on Customers Menu")
    public void user_clicks_on_customers_menu() {
        addCustomerPage.clickOnCustomersMenu();
    }

    @When("Click on Customers menu item")
    public void click_on_customers_menu_item() {
        addCustomerPage.clickOnCustomersMenuItem();
    }

    @When("Click on Add New button")
    public void click_on_add_new_button() {
        addCustomerPage.clickOnAddNew();
    }

    @Then("User can view Add new Customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User enters customer info")
    public void user_enters_customer_info() {
        String email = randomString() + "@gmail.com";

        addCustomerPage.setEmail(email);
        addCustomerPage.setPassword("test123");
        addCustomerPage.setFirstName("New");
        addCustomerPage.setLastName("User");
        addCustomerPage.selectGenderMale();
    }

    @When("Click on Save button")
    public void click_on_save_button() throws InterruptedException {
        addCustomerPage.clickOnSave();
        Thread.sleep(3000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains(message));
    }

    // Search for a customer using email id
    @When("Enter customer email")
    public void enter_customer_email() {
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setEmail("arthur_holmes@nopCommerce.com");
    }

    @When("Click on Search button")
    public void click_on_search_button() throws InterruptedException {
        searchCustomerPage.clickSearch();
        Thread.sleep(5000);
    }

    @Then("User should find the email in the results table")
    public void user_should_find_the_email_in_the_results_table() {
        Assert.assertTrue(searchCustomerPage.searchCustomerByEmailId("arthur_holmes@nopCommerce.com"));
    }

    // Search customer by FirstName and LastName
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setFirstName("Arthur");
    }

    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchCustomerPage.setLastName("Holmes");
    }

    @Then("User should find the Name in the results table")
    public void user_should_find_the_name_in_the_results_table() {
        Assert.assertTrue(searchCustomerPage.searchCustomerByName("Arthur Holmes"));
    }


}
