@appium
Feature: Debug

  Scenario Outline: Registration Validation Errors Second Page
    Given I am using Appium to run automation tests for device "<Device>"
#    And I am using Android version "<Version>"
#    And I have clicked on the Register button
#    Then I enter a unique Gmail email address
#    And I attempt to Paste confirmation of the unique Gmail email address

    Examples:
      | Device          |Version|
      | Nexus_7_API_22  |5.1    |