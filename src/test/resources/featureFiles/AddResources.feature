@resources @regression
Feature: Activate an Access code and Access Resource
  SIN-2010 - Add Resources
  SIN-2631 - Sprint 10 Functionality

  Scenario Outline: Login, enter Access code for Resource

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then I am logged into MEE
    And I select the Add Resource icon
    Then I enter an incorrect Access code
    And I have clicked on the Access code Next button
    Then a message "Invalid access code. Please check your code and try again." is displayed
    And I refresh the page

    And I enter a not yet published code of "<NotPubCode>"
    And I have clicked on the Access code Next button
    Then a message "The digital content for this code has not yet been published." is displayed
    And I select the Contact our Customer Service Team link

    Then I switch Windows back to the MEE Portal
    Given I am on the MEE portal for "test"
    And I select the Add Resource icon
    Then I enter an Access code of "<AccessCode>"
    And I have clicked on the Access code Next button
    Then I should see an Activate message for "<Resource>"
    Then I should see an Activate message for "<Resource2>"
    And I select Activate
    Then a message "Success! Your access code has been activated." is displayed
    Then I log out of MEE


    Examples:
      | username | password  |  AccessCode        | Resource                      | Resource2                       | NotPubCode       |
      | meeadmin | M4cmillan |  HFTL1199319198437 | TEST High Five! Level 1 Pupil | TEST High Five! Level 1 Teacher | TEST395894165646 |
