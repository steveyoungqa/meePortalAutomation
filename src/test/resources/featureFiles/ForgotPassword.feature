
Feature: Forgot Password Journey
  SIN-2008 - Automation - Forgot UserName/Password journey
  SIN-2107 - Automation - Forgot User/Pass Validation errors

  @validation
  Scenario: Forgot User/Pass Validation errors
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I click the Forgot Password link
    And I select the Submit button
    Then a message "Please enter your username" is displayed
    And I click on the Close form icon

  @forgotPassword
  Scenario Outline: Forgotten Password Journey
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a unique email address
    Then I enter a confirmation of the unique email address
    And I select the Opt In checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Mailinator account for the email
    And I click on the link to confirm the email address

    Then I click the Forgot Password link
    And I enter then newly created Username
    And I select the Submit button
    And a Success screen that the password reset link has been sent is shown

    Then I check the Mailinator account for the Reset Password email
    And I click the Reset Password link
    Then I Login and change my Password
    And I select the Close button
    Then I have clicked on the Landing Page login button
    And I Login with the forgotten Password details
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Larry     | Lost    | GB      | 11  | August | 1943 |