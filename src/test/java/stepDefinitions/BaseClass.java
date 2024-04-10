package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddCustomerPage addCustomerPage;
    public SearchCustomerPage searchCustomerPage;
    public static Logger logger = LogManager.getLogger("nopCommerce");
    public Properties configProp;

    // Generate random string for unique email addresses
    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

}
