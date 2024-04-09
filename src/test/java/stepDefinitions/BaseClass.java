package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddCustomerPage addCustomerPage;

    // Generate random string for unique email addresses
    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

}
