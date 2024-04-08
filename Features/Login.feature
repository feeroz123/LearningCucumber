Feature: Login

  Scenario: Successful login with valid credentials
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser