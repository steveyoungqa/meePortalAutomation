@resources
Feature: Activate an Access code and Access Resource
  SIN-2010 - Add Resources
  SIN-2631 - Sprint 10 Functionality

  Background: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: Register,Login, enter Access code for Resource

    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password
    And I select the Add Resource icon
    Then I enter an incorrect Access code
    And I have clicked on the Access code Next button
    Then a message "This is not a valid access code. Please try again" is displayed
    And I refresh the page

    And I enter a not yet published code of "<NotPubCode>"
    And I have clicked on the Access code Next button
    Then a message "We are sorry but the digital content for this code is not yet available. Your code has not been activated." is displayed
    And I select the Add Resource icon
    Then I enter an Access code of "<AccessCode>"
    And I have clicked on the Access code Next button
    Then I should see an Activate message for "<Resource>"
    Then I should see an Activate message for "<Resource2>"
    And I select Activate
    Then a message "Success! Your access code has been activated." is displayed
    Then I log out of MEE


    Examples:
      | Language           | Firstname | Surname    | Country | day | month  | year |   AccessCode        | Resource                      | Resource2                       | NotPubCode       |
      | English            | Ted       | Tester     | GB      | 7   | May    | 1956 |  HFTL1199319198437 | TEST High Five! Level 1 Pupil | TEST High Five! Level 1 Teacher | TEST395894165646 |
