@regKorean
Feature: Regression tests for registering a new user
  SIN-2078 - Email Address Handling
  Register a new User with unique email address and Login in each language

  Background: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    #And I select the Opt In checkbox
    #Then I select Third Party checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail


    Examples:
      | Language           | Firstname | Surname    | Country | day | month  | year |
      | Korean             | Seung     | Tester     | KR      | 24  | Oct    | 1989 |





