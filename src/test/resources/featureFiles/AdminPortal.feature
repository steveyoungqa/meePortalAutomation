@admin
Feature: As a MEE application administrator I want to be able to perform administratory actions

  Background:
    Given I am using the "test" environment of MEE

  Scenario: As an administrator, I want to test that to automatic HTTP to HTTPS redirect is working (1)
    Given I have navigated to the HTTP version of the admin portal Url
      Then the new Url is in HTTPS format

  Scenario Outline: As an administrator, I want to check that validation is in place for login on the admin portal (2)
    Given I have navigated to the admin portal
    And I have entered a "<Username>" and "<Password>"
    When I click the Log in button
    Then A validation "<Error>" is displayed

    Examples:
      | Username          | Password          | Error                     |
      |                   | incorrectpassword | Username-error            |
      | incorrectusername |                   | Password-error            |
      | wpritchard        | password          | validation-summary-errors |

  Scenario Outline: As an administrator, I want to check all the search fields from the users page (3)
    Given I have navigated to the admin portal
    And I have logged into the admin portal
    And I have navigated to the Users page of the site
    When I enter a search parameter "<Search Parameter>" into a search field "<Search Field>"
    And Click the search button
#    Then appropriate results are displayed

    Examples:
      | Search Parameter     | Search Field |
      | allstudent1@test.com | Email        |
#      | ttester1             | Username     |
#      | tester1              | Firstname    |
#      | tester1              | Lastname     |

