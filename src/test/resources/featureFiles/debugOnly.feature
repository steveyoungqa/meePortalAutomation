@debug

  Feature: New Converged Portal Regression End to End Test Pack

  Scenario: LOGIN VALIDATION ERRORS
    Given I am on the MEE portal for "newUAT"
    Then I have clicked on the New Landing Page login button


# Run locally in Terminal to use correct chromedriverOSX
#  mvn clean test -Dwebdriver.chrome.driver=selenium/chromedriverOSX -Dcucumber.tags=@debug