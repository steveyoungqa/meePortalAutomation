@newPortal
  Feature: New Converged Portal Regression End to End Test Pack

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Scenario: LOGIN VALIDATION ERRORS
    Given I am on the MEE portal for "newUAT"
    Then I have clicked on the New Landing Page login button
    Then a message "Please enter your username" is displayed
    Then a message "Please enter your password" is displayed
    Then I click the Forgot username link
    And I select the New Portal Submit button
    Then I scroll to the Top of the page
    Then a message "Please enter your first name" is displayed
    Then a message "Please enter your last name" is displayed
    Then a message "Please enter a valid date of birth" is displayed
    Then a message "Email address required" is displayed
    And I click on the Cancel link

    Scenario: INCORRECT LOGIN DETAILS VALIDATION
    Given I am on the MEE portal for "newUAT"
    When I New log in as username "noSuchUser" and password "completelyMadeUpRandom"
    Then a message "Your details do not match our database. Please try again or register" is displayed

   @reg
    Scenario Outline: REGISTER A NEW USER (ALL LANGUAGES)
      Given I am on the MEE portal for "newUAT"
      And I have clicked on the New Register button
      When I select language "<Language>" on New Mee Portal
      Then I enter a New Access code of "<AccessCode>"
      And I have clicked on the Access code Next button

      Then I register a first name of "<Firstname>" and surname of "<Surname>"
      And I select a Country of residence of "<Country>"
      Then I select a date of birth of "<day>" "<month>" "<year>"
      Then I enter a unique Gmail email address
      And I enter a confirmation of the unique Gmail email address
      Then I enter a unique Username
      And I enter a unique Password
      And I enter a confirmation of the unique Password
      Then I select the New Terms & Conditions checkbox
#
      And I select Register and Activate Code
      Then I should be logged into the New Mee Portal

      Then I check the Test Gmail account for the email
      And I click on the link to confirm the New Portal Gmail email address
      And the Email should contain the users Registration credentials
      Then I follow the Gmail link to the Login Page
      And I switch Windows back to the MEE Portal
      And I log out of the New MEE Portal
      And I enter Registered credentials to the Login Page
      Then I have clicked on the New Landing Page login button
      And I log out of the New MEE Portal

      Then I switch back to Gmail
      Then I delete ALL Test Gmail Emails
      Then I log out of Gmail

      Examples:
        | Language | Firstname | Surname | Country | day | month | year |AccessCode  |
        | English  | New       | Portal  | GB      | 9   | May   | 1971 |892046730726|
