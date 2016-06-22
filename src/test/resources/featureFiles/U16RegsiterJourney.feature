@u16
Feature: U16 Registration Journey
  SIN-2006 - Automation - U16 Registration Journey

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: U16 Registration
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a Parent/Guardian Gmail address
    Then I enter a confirmation of the unique Parent/Guardian email address
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail Minor email address

#    Then I switch Windows back to the MEE Portal
    Then I should see the Registration Completed screen
    And I select the Close button

    Then I have clicked on the Landing Page login button
    And I select language "<Language>"
    Then I Login with the newly created username and password
    Then I log out of MEE

    Then I switch back to Gmail
    And I delete the Test Gmail Email
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Mikey     | Minor   | GB      | 11  | August | 2004 |