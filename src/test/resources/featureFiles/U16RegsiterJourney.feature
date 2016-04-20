@regression @u16
Feature: U16 Registration Journey
  SIN-2006 - Automation - U16 Registration Journey

  @u16
  Scenario Outline: U16 Registration
    Given I am on the MEE portal for "dev"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a Parent/Guardian email address
    Then I enter a confirmation of the unique Parent/Guardian email address
    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Parent/Guardian Mailinator account for the email
    And I click on the link to confirm the email address
    Then I should see the Registration Completed screen
    And I select the Close button

    And I have clicked on the login button
    And I select language "<Language>"
    Then I Login with the newly created username and password
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Mikey     | Minor   | GB      | 11  | August | 2004 |