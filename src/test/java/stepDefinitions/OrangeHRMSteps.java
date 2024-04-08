package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrangeHRMSteps {
    WebDriver driver;

    @Given("I launch Chrome browser")
    public void i_launch_chrome_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Launching Chrome browser");
    }

    @When("I open OrangeHRM Home Page")
    public void i_open_orange_hrm_home_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Opening OrangeHRM Home Page");
    }

    @Then("I verify the presence of logo present on the page")
    public void i_verify_the_presence_of_logo_present_on_the_page() {
        WebElement logo = driver.findElement(By.xpath("//img[contains(@src, 'ohrm_branding')]"));
        logo.click();
        System.out.println("Verifying presence of logo present on the page");
        Assert.assertTrue(logo.isDisplayed());
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
        System.out.println("Closing browser");
    }

}
