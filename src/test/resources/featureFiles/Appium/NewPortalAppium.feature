Feature: Appium Automation on New MEE Portal

  @appiumNewPortal
  Scenario Outline: Register a New User on a Mobile Device (Chrome)
    Given I am using Appium to run Mobile Browser automation tests for device "<Device>" and Android version "<Version>"
    And I am using the "<Url>" url for the mobile browser
    And I have clicked on the New Register button for mobile browser
    Then I enter a New Access code of "<AccessCode>" for mobile browser
    And I have clicked on the Access code Next button for mobile browser
    Then I register a first name of "<Firstname>" and surname of "<Surname>" for mobile browser
    And I select a Country of residence of "<Country>" for mobile browser
#    Then I select a date of birth of "<day>" "<month>" "<year>"
#    Then I enter a unique Gmail email address
#    And I enter a confirmation of the unique Gmail email address
#    Then I select the New Terms & Conditions checkbox
    Then I Pause for 5 seconds
#    And I close the Mobile Browser

    Examples:
      | Device                        | Version | Url                                                                  | Firstname | Surname | Country | day | month | year | AccessCode   |
      | Nexus_7_API_22                | 5.1     | http://converged-uat.macmillan.education/                            | Ted       | Tester  | GB      | 7   | 5     | 1956 | 892046730726 |
#      | Nexus_7_API_22                | 5.1     | https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/ | English   | Ted     | Tester  | GB  | 7     | 5    | 1956         |
#      | Galaxy_Tab_4.0_API_22         | 5.1     | https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/ | English   | Ted     | Tester  | GB  | 7     | 5    | 1956         |
#      | Samsung_Galaxy_S7_Edge_API_22 | 5.1     | https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/ | English   | Ted     | Tester  | GB  | 7     | 5    | 1956         |
