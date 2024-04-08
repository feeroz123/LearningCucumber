package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.time.Duration;

public class Steps {
    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User launches Chrome Browser")
    public void user_launches_chrome_browser() {
        System.out.println("Opening browser");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        System.out.println("Navigating to the URL");
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        System.out.println("Entering email and password");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        System.out.println("Clicking on Login");
        loginPage.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        System.out.println("Verification of the page title");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(title, pageTitle);
    }

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link() {
        System.out.println("Clicking on Logout");
        loginPage.clickLogout();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        System.out.println("Closing the browser");
        driver.quit();
    }

}
