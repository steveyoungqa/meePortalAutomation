@resources
Feature: Login and download the MEE app
  SIN-2108 - Download MEE App

  Scenario Outline: Register a new user

    Given I am on the MEE portal for "test"
    Then I have clicked on the login button
    When I log in as username "<username>" and password "<password>"
    Then I am logged into MEE
    And I select the Add Resource icon
    Then I enter an incorrect Access code
    And I have clicked on the Access code Next button
    Then a message "<validation error>" is displayed
    Then I enter an Access code of "<AccessCode>"
    And I have clicked on the Access code Next button
    Then I should see an Activate message for "<Resource>"
    Then I should see an Activate message for "<Resource2>"
    And I select Activate
    Then a message "Success! Your access code has been activated." is displayed
    Then I log out of MEE


    Examples:
      | username | password  | validation error                                           | AccessCode        | Resource                      | Resource2                       |
      | meeadmin | M4cmillan | Invalid access code. Please check your code and try again. | HFTL1199319198437 | TEST High Five! Level 1 Pupil | TEST High Five! Level 1 Teacher |
