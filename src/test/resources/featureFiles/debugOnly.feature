
Feature: Forgot Password Journey

  Scenario Outline: User is diverted to the forgot username webpage (1a)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I select language "<Language>"
    And I click the Forgot username link

    Examples:
      | Language           |
      | Spanish            |
