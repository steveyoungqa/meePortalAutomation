@debug
Feature: Debug

  Scenario: Registration Validation Errors Second Page
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    Then I enter a unique Gmail email address
    And I attempt to Paste confirmation of the unique Gmail email address
    Then I Pause for 5 seconds