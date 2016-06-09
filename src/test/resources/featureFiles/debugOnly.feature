Feature: Forgot Password Journey

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Opt In checkbox
    And I select the Submit button

    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address
    Then I Pause for 10 seconds
#
#    Given I am on the MEE portal for "test"
#    Then I have clicked on the Landing Page login button
#    Then I Login with the newly created username and password
#    Then I log out of MEE





    Examples:
      | Language | Firstname | Surname | Country | day | month | year |
      | English  | Ted       | Tester  | GB      | 7   | May   | 1956 |
