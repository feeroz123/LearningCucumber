package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class Steps extends BaseClass {

    // Setup method
    @Before
    public void setup() {
        //Reading properties
        configProp = new Properties();
        try {
            FileInputStream configPropFile = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
            configProp.load(configPropFile);
        } catch (Exception e) {
            logger.error("Error loading the properties file");
            e.printStackTrace();
        }

        // Deciding the browser to launch
        String browserName = configProp.getProperty("browser");
        switch (browserName) {
            case "chrome":
                logger.info("Launching Chrome browser");
                driver = new ChromeDriver();
                break;
            case "firefox":
                logger.info("Launching Firefox browser");
                driver = new FirefoxDriver();
                break;
            case "edge":
                logger.info("Launching Edge browser");
                driver = new EdgeDriver();
                break;
            default:
                logger.error("Invalid browser name: {}", browserName);
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Login methods
    @Given("User launches Chrome Browser")
    public void user_launches_chrome_browser() {
        // The browser selection is done in the Setup method above
        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("Opening application URL");
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        logger.info("Started login process");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        logger.info("Clicked on Login");
        loginPage.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        logger.info("Checking page title");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
    }

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link() {
        logger.info("Clicked on Logout link");
        loginPage.clickLogout();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        logger.info("Closing browser");
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
        logger.info("Entering customer details");

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
        logger.info("Checking confirmation message");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains(message));
    }

    // Search for a customer using email id
    @When("Enter customer email")
    public void enter_customer_email() {
        logger.info("Entering customer email");
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setEmail("arthur_holmes@nopCommerce.com");
    }

    @When("Click on Search button")
    public void click_on_search_button() throws InterruptedException {
        logger.info("Clicking on Search button");
        searchCustomerPage.clickSearch();
        Thread.sleep(5000);
    }

    @Then("User should find the email in the results table")
    public void user_should_find_the_email_in_the_results_table() {
        logger.info("Checking if customer is found using email");
        Assert.assertTrue(searchCustomerPage.searchCustomerByEmailId("arthur_holmes@nopCommerce.com"));
    }

    // Search customer by FirstName and LastName
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        logger.info("Entering customer FirstName");
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setFirstName("Arthur");
    }

    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        logger.info("Entering customer LastName");
        searchCustomerPage.setLastName("Holmes");
    }

    @Then("User should find the Name in the results table")
    public void user_should_find_the_name_in_the_results_table() {
        logger.info("Checking if customer is found using FirstName and LastName");
        Assert.assertTrue(searchCustomerPage.searchCustomerByName("Arthur Holmes"));
    }


}
