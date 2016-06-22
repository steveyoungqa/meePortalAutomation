
Feature: Forgot UserName
  SIN-2008 - Automation - Forgot UserName/Password journey
  SIN-2107 - Automation - Forgot User/Pass Validation errors

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  @forgotUsername
  Scenario Outline: Forgotten Username Journey
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Opt In checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal
    Then I click the Forgot username link
    Then I enter a first name of "<Firstname>" and surname of "<Surname>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I enter the newly created Email address
    And I select the Submit button
    And a Success screen that the email has been sent is shown

    Then I open the logged in Gmail page
    And a check is made that the Username reminder is correct
    Then I Login with the forgotten Username details
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname   | Country | day | month  | year |
      | English  | Fred      | Forgetful | GB      | 5   | August | 1976 |
