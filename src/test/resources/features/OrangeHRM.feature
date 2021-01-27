Feature: OrangeHRM Login

  Scenario: Logo is present on OrangeHRM home page
    Given I launch chrome browser
    When I open OrangeHRM home page
    Then I verify logo is present on home page
    And  I close browser
