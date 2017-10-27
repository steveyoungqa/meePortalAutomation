Feature: Validation Tests

  @validation
  Scenario: Login Validation Errors
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I press the Login button
    Then a message "Please enter your username" is displayed
    Then a message "Please enter your password" is displayed
    Then I click the Forgot username link
    And I select the Submit button
    Then a message "Please enter your first name" is displayed
    Then a message "Please enter your last name" is displayed
    Then a message "Please enter a valid date of birth" is displayed
    Then a message "Email address required" is displayed
    And I click on the Close form icon

  Scenario: Registration Validation Errors
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    #And I have clicked on the Next button
    And I select the Submit button
    Then a message "Please enter your first name" is displayed
    Then a message "Please enter your last name" is displayed
    Then a message "Please select your country of residence" is displayed
    Then a message "Please enter a valid date of birth" is displayed
    Then I register a first name of "Vera&" and surname of "Validation<"
    And I select the Submit button
    #And I have clicked on the Next button
    Then a message "First name must not contain special characters" is displayed
    Then a message "Last name must not contain special characters" is displayed

  Scenario: Registration Validation Errors Second Page
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    Then I register a first name of "Vera" and surname of "Validation"
    And I select a Country of residence of "GB"
    Then I select a date of birth of "3" "Oct" "1994"
    #And I have clicked on the Next button
    Then I Pause for 3 seconds
    And I select the Submit button
    Then a message "Email address required" is displayed
    Then I enter a unique Gmail email address
    And I attempt to Paste confirmation of the unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Submit button
    Then a message "You must agree to the terms and conditions to continue" is displayed

  Scenario: Incorrect Login Validation
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I select language "English"
    When I log in as username "blahblahblah" and password "asdasdasd"
    Then A message is displayed informing the user that the login process has failed

  Scenario Outline: Forgotten Details Login Validation
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then A "<validation error>" is displayed

    Examples:
      | username | password | validation error                                       |
      |          | password | Please enter your username                             |
      | username |          | Please enter your password                             |
      |          |          | Please enter your username, Please enter your password |

  Scenario: Changing the Language resets the Registration from
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "English"
    Then I register a first name of "Change" and surname of "Language"
    And I select a Country of residence of "GB"
    Then I select a date of birth of "8" "May" "1950"
    When I select language "Spanish"
    Then the Registration form should be empty


