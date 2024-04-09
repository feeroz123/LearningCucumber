Feature: Customers

  Scenario: Add a new Customer
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on Customers Menu
    And Click on Customers menu item
    And Click on Add New button
    Then User can view Add new Customer page
    When User enters customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close the browser

  Scenario: Search customer using email id
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on Customers Menu
    And Click on Customers menu item
    And Enter customer email
    When Click on Search button
    Then User should find the email in the results table
    And Close the browser

  Scenario: Search customer using First Name and Last Name
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on Customers Menu
    And Click on Customers menu item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on Search button
    Then User should find the Name in the results table
    And Close the browser