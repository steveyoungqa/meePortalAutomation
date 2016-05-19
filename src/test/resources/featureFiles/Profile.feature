@profile
Feature: Edit User Profile
  SIN-2009 - Profile, including change password
  Register a new User with unique email address, Login, View Profile and change password

#  This Test opens up multiple Mailinator windows and is problematic if run with other Tags
#  So run on its own @profile tag only

  Scenario Outline: Register a new user
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
    And I switch Windows back to the MEE Portal

    #LogIn with new UserName & Password
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password

    #Change Password in Profile section
    And I select the Profile icon
    Then I select Change Password
    And I change the current password to a new one and confirm
    And I select the Submit button
    Then I should see the Password changed Success message
    And I select the Close button

    #Edit Details
    Then I Login with the username and edited password
    And I select the Profile icon
    Then I select Edit Details
    Then I register a first name of "<EditFirstName>" and surname of "<EditSurname>"
    Then I select a date of birth of "<editDay>" "<editMonth>" "<editYear>"
    And I have clicked on the Next button
    Then I enter a unique email address
    Then I enter a confirmation of the unique email address
    And I select the Opt In checkbox
    And I select the Submit button
    Then a message "Personal details updated" is displayed
    And I log out of MEE
    And I switch Windows back to the MEE Portal

    Then I check the Mailinator account for the email
    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the username and edited password
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month | year | EditFirstName | EditSurname | editMonth | editDay | editYear |
      | English  | Bill      | Tester  | GB      | 7   | May   | 1956 | William       | Testor      | Feb       | 18      | 1954     |
