@now
Feature: As a user I want to validate the login procedure

  Scenario: User login for application
    Given I have open the application
    When I login
    Then I am presented with the welcome page


  Scenario: Webpage scenario
    Given I have opened a "webpage"
    When I check for something
    Then something is present
