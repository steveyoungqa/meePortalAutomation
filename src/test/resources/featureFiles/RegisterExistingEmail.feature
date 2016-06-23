@existing
Feature: Existing Account Registered to this Email

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: Register an Existing Email Address
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter an email address of "<email>"
    And I enter a confirmation email address of "<email>"
    Then I select the Terms & Conditions checkbox
    And I select the Submit button
    Then a message "An account with these details already exists in our database." is displayed
    And I select the Submit button

    Then I select the Back button
    Then I register a Unique first name
    And I have clicked on the Next button
    And I select the Submit button

    Then a message "There is an existing account registered with this email address. Please tick the box if you’d like to continue and use the email address again." is displayed
    And I select the Use the Same Email Address checkbox
    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail


    Examples:
      | Language | Firstname | Surname | Country | day | month | year | email                              |
      | English  | Ted       | Tester  | GB      | 7   | May   | 1956 | springertester+testemail@gmail.com |


