@regression
Feature: Forgot Password Journey
  SIN-2008 - Automation - Forgot UserName/Password journey

  @forgotPassword
  Scenario Outline: Forgotten Password Journey
    Given I am on the MEE portal for "dev"
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

    Then I check the Mailinator account for the email
    And I click on the link to confirm the email address
    Then I should see the Registration Completed screen
    And I select the Close button

    And I have clicked on the login button
    And I select language "<Language>"
    Then I select the Forgot Password link
    Then I enter then newly created Username
    And I select the Submit button
    And a Success screen that the password reset link has been sent is shown

    Then I check the Mailinator account for the email
    And I reset the password by following the link and Login
    And I select the Submit button
    And I select the Close button

    And I have clicked on the login button
    And I select language "<Language>"
    Then I Login with the username and edited password
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Larry     | Lost    | GB      | 11  | August | 1943 |