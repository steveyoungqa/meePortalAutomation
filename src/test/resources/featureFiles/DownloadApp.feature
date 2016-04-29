@download @regression
Feature: Register a new user, Login and download the MEE app
  SIN-2108 - Download MEE App

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a unique email address
    Then I enter a confirmation of the unique email address
    And I select the Opt In checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page
    And I select the Close button
#    Then I switch Windows back to the MEE Portal

    Then I check the Mailinator account for the email
    And I click on the link to confirm the email address

    #LogIn with new UserName & Password
#    Then I switch Windows back to the MEE Portal
    Given I am on the MEE portal for "test"
    Then I have clicked on the login button
    Then I Login with the newly created username and password

    #Check the Download Links are working
    Then I should be redirected to the Download App page
    And I confirm the Download for Windows is functioning
    Then I log out of MEE


    Examples:
      | Language | Firstname | Surname  | Country | day | month | year |
      | English  | Donald    | Download | GB      | 6   | Dec   | 1983 |
