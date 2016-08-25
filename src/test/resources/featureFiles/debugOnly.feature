@debug
Feature: Debug

  Scenario: Registration Validation Errors Second Page
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
#    Then I register a first name of "Vera" and surname of "Validation"
    And I select a Country of residence of "GB"
    Then I select a date of birth of "3" "Oct" "1994"
    Then I Pause for 3 seconds
    Then I enter a unique Gmail email address
    And I attempt to Paste confirmation of the unique Gmail email address
    Then I Pause for 5 seconds