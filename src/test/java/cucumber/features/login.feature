Feature: Login to the application

  Scenario: Login to application as valid user
    Given User in on kasirAja login page
    When User enter the valid credentials
    And Click on Login
    Then Home Page should be displayed

  Scenario: Login to application as Invalid user
    Given User in on kasirAja login page
    When User enter the Invalid credentials
    And Click on Login
    Then Error Message Should be displayed