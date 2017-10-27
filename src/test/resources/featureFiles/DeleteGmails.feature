@delete
Feature: Delete all Gmail Emails - Use before running independant tags

  Scenario: Delete Gmails
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail