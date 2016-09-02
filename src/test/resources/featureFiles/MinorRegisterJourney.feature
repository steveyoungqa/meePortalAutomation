@u16
Feature: Minor Registration Journey
  SIN-2006 - Automation - U16 Registration Journey
  SIN-1936 - U12 Australia and U18 Mexico

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: Minor Registration
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I enter a Parent/Guardian Gmail address
    Then I enter a confirmation of the unique Parent/Guardian email address
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail Minor email address

    Then I should see the Registration Completed screen
    And I select the Close button

    Then I have clicked on the Landing Page login button
    And I select language "<Language>"
    Then I Login with the newly created Minor username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Mikey     | Minor   | GB      | 11  | August | 2004 |
      | English  | Adrian    | Aussie  | AU      | 11  | August | 2005 |
      | English  | Pedro     | Mexico  | MX      | 11  | August | 2004 |

     #Edit Details
  Scenario: Updating the email address of a Minor will log the user out
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created Minor username and password
    And I select the Profile icon
    Then I select Edit Details
    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Submit button
    Then a message "Check your email and click on the link to validate your contact details." is displayed
    And I have clicked on the Continue button
    Then I have clicked on the Landing Page login button
    And I switch Windows back to the MEE Portal

