@debug
Feature: Forgot Password Journey

  Scenario: Register a new user

    Then I check the Test Gmail account for the email

    Then I delete ALL Test Gmail Emails
#    And I delete the Test Gmail Email
    Then I log out of Gmail

