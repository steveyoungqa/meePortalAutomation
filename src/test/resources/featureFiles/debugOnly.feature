
Feature: Forgot Password Journey

  Scenario Outline:
     #LogIn with new UserName & Password
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password

    #Change Password in Profile section
    And I select the Profile icon
    Then I select Change Password
    And I select the Submit button
    Then a message "Please enter your password" is displayed
    Then a message "New password required" is displayed
    Then a message "New confirm password required" is displayed
    And I try to change the new password to include invalid characters
    Then a message "Password must not contain special characters" is displayed
    And I refresh the page
    Then I select Change Password
    And I change the current password to a new one and confirm
    And I select the Submit button
    Then I should see the Password changed Success message
    And I select the Close button




    Examples:
      | Language           |
      | Spanish            |
