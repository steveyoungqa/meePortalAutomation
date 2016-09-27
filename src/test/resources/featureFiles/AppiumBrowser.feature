@appium
Feature: Debug

  Scenario Outline: Registration Validation Errors Second Page
    Given I am using Appium to run automation tests for device "<Device>" and Android version "<Version>"
    And I am using the "<Url>" url for the mobile browser
    Then I register a new user in the mobile browser in language "<Language>"
    And I use a Country of "<Country>" and a First Name of "<Firstname>" and Surname of "<Surname>"
    Then use a date of birth of "<day>" "<month>" "<year>"
    Then I Pause for 5 seconds

    Examples:
      | Device         | Version | Language | Firstname | Surname | Country | day | month | year | Url                                                                  |
      | Nexus_7_API_22 | 5.1     | English  | Ted       | Tester  | GB      | 7   | 5     | 1956 | https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/ |