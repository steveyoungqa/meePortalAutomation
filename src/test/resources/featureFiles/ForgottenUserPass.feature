
Feature: Forgot UserName & Password Journey
  SIN-2008 - Automation - Forgot UserName/Password journey

  @forgotUserAndPass
  Scenario Outline: Forgotten UserName & Password Journey
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

    Then I check the Mailinator account for the email
    And I click on the link to confirm the email address

    Then I switch Windows back to the MEE Portal
    And I select language "<Language>"
    Then I select the Forgot UserName and Password link
    Then I enter a first name of "<Firstname>" and surname of "<Surname>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I enter the newly created Email address
    And I select the Submit button
    And a Success screen that the email with the username and password has been sent is shown

    Then I check the Mailinator account for the email
    And I reset the password by following the link and Login
    And I select the Submit button
    And I select the Close button

    And I have clicked on the login button
    And I select language "<Language>"
    Then I Login with the username and edited password
    Then I log out of MEE
    Then I Pause for 10 seconds

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Nigel     | NoIdea  | GB      | 1   | August | 1958 |