Feature: Login
  Background: User logs in (common steps)
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"

  Scenario: Successful login with valid credentials
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser

  Scenario Outline: Login Data Driven
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser
    Examples:
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |