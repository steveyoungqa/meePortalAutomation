@profile
Feature: Edit User Profile
  SIN-2009 - Profile, including change password
  Register a new User with unique email address, Login, View Profile and change password
  SIN-2631 - Validation on edit Password for special characters

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
#    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Opt In checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

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

    Then I open the logged in Gmail page
    And a check is made that the Password has been changed
    Then I delete ALL Test Gmail Emails

    #Edit Details
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the forgotten Password details
    And I select the Profile icon
    Then I select Edit Details
    Then the registered first name and surname is validated
    Then the Country of Residence is validated
    And the Date of Birth is validated

    Then I register a first name of "<EditFirstName>" and surname of "<EditSurname>"
    Then I select a date of birth of "<editDay>" "<editMonth>" "<editYear>"
    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    And I select the Opt In checkbox
    And I select the Submit button
    Then a message "Personal details updated" is displayed
    And I log out of MEE
    And I switch Windows back to the MEE Portal

    Then I open the logged in Gmail page
    And a check is made that Details have been changed
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the forgotten Password details
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month | year | EditFirstName | EditSurname | editMonth | editDay | editYear |
      | English  | Bill      | Tester  | GB      | 7   | May   | 1956 | William       | Testor      | Feb       | 18      | 1954     |
