@OrangeHRMLogin
Feature: OrangeHRM Login

  Scenario: Logo presence on OrangeHRM Home Page
    Given I launch Chrome browser
    When I open OrangeHRM Home Page
    Then I verify the presence of logo present on the page
    And I close the browser
