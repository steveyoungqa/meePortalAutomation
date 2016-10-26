@regression
Feature: Regression End to End Test Pack
  SIN-2255 - Regression Test Pack

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  Scenario: LOGIN VALIDATION ERRORS
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

  Scenario: INCORRECT LOGIN DETAILS VALIDATION
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I select language "English"
    When I log in as username "noSuchUser" and password "completelyMadeUpRandom"
    Then A message is displayed informing the user that the login process has failed


  Scenario Outline: REGISTER A NEW USER (ALL LANGUAGES)
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    #And I select the Opt In checkbox
    #Then I select Third Party checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

    Then I Login with the newly created username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname | Country | day | month | year |
      | English  | Ted       | Tester  | GB      | 7   | May   | 1956 |

  Scenario Outline: Register,Login, enter Access code for Resource. Download APP tests

    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password
    And I select the Add Resource icon
    Then I enter an incorrect Access code
    And I have clicked on the Access code Next button
    Then a message "This is not a valid access code. Please try again" is displayed
    And I refresh the page

    And I enter a not yet published code of "<NotPubCode>"
    And I have clicked on the Access code Next button
    Then a message "We are sorry but the digital content for this code is not yet available. Your code has not been activated." is displayed
    And I select the Add Resource icon
    Then I enter an Access code of "<AccessCode>"
    And I have clicked on the Access code Next button
    Then I should see an Activate message for "<Resource>"
    Then I should see an Activate message for "<Resource2>"
    Then I Pause for 3 seconds
    And I select Activate
    Then a message "Success! Your access code has been activated." is displayed
    And I click on the Close form icon
    And I confirm the Download is functioning for "Windows"
    And I confirm the Download is functioning for "MAC"
    And I confirm the Download is functioning for "Linux32"
    And I confirm the Download is functioning for "Linux64"
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail


    Examples:
      | Language | Firstname | Surname | Country | day | month | year | AccessCode        | Resource                      | Resource2                       | NotPubCode       |
      | English  | Ted       | Tester  | GB      | 7   | May   | 1956 | HFTL1199319198437 | TEST High Five! Level 1 Pupil | TEST High Five! Level 1 Teacher | TEST395894165646 |

  Scenario Outline: U16 REGISTRATION JOURNEY
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I enter a Parent/Guardian Gmail address
    Then I enter a confirmation of the unique Parent/Guardian email address
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail Minor email address

    Then I should see the Registration Completed screen
    And I select the Close button

    Then I have clicked on the Landing Page login button
    And I select language "<Language>"
    Then I Login with the newly created Minor username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Mikey     | Minor   | GB      | 11  | August | 2004 |
      | English  | Adrian    | Aussie  | AU      | 11  | August | 2005 |
      | English  | Pedro     | Mexico  | MX      | 11  | August | 2004 |

  Scenario Outline: T&C'S, PRIVACY, COOKIES
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I select the Terms of Use link
    Then I select the Privacy Policy link
    And I select the Cookie Policy link

    Examples:
      | Language | Firstname | Surname | Country | day | month | year |
      | English  | Private   | Terms   | GB      | 7   | May   | 1956 |

#
  Scenario Outline: PROFILE FEATURE
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
#    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    #And I select the Opt In checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal

    #LogIn with new UserName & Password
#    Given I am on the MEE portal for "test"
#    Then I have clicked on the Landing Page login button
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
    #And I select the Opt In checkbox
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


  @forgotPassword
  Scenario Outline: FORGOTTEN PASSWORD JOURNEY
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    #And I select the Opt In checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    And I Pause for 10 seconds
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal
    Then I click the Forgot Password link
    And I enter then newly created Username
    And I select the Submit button
    And a Success screen that the password reset link has been sent is shown

    And I Pause for 5 seconds
    Then I open the logged in Gmail page
    And I click the Gmail Reset Password link
    Then I Login and change my Password
    And I select the Close button
    Then I have clicked on the Landing Page login button
    And I Login with the forgotten Password details
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Larry     | Lost    | GB      | 11  | August | 1943 |

  Scenario: Delete ALL existing GMAIL's (if any)
    Given I check the Test Gmail account for the email
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

  @forgotUsername
  Scenario Outline: FORGOTTEN USERNAME JOURNEY
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
#    #And I have clicked on the Next button
    Then I enter a unique Gmail email address
    And I enter a confirmation of the unique Gmail email address
    #And I select the Opt In checkbox
    Then I select the Terms & Conditions checkbox

    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address

    And I switch Windows back to the MEE Portal
    Then I click the Forgot username link
    Then I enter a first name of "<Firstname>" and surname of "<Surname>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I enter the newly created Email address
    And I select the Submit button
    And a Success screen that the email has been sent is shown

    Then I open the logged in Gmail page
    And a check is made that the Username reminder is correct
    Then I Login with the forgotten Username details
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Firstname | Surname   | Country | day | month  | year |
      | English  | Fred      | Forgetful | GB      | 5   | August | 1976 |


  Scenario Outline: REGISTER AN EXISTING EMAIL ADDRESS
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a Unique first name
    And I register a Unique Surname
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    Then I enter an email address of "<email>"
    And I enter a confirmation email address of "<email>"
    Then I select the Terms & Conditions checkbox
    And I select the Submit button
    And I Pause for 5 seconds
    Then a message "There is an existing account registered with this email address." is displayed
    And I select the Use the Same Email Address checkbox
    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Test Gmail account for the email
    And I click on the link to confirm the Gmail email address resgistered with unique First and Last names

    And I switch Windows back to the MEE Portal

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created Minor username and password
    Then I log out of MEE

    Then I switch back to Gmail
    Then I delete ALL Test Gmail Emails
    Then I log out of Gmail

    Examples:
      | Language | Country | day | month | year | email                              |
      | English  | GB      | 7   | May   | 1956 | springertester+testemail@gmail.com |

  Scenario: REGISTRATION VALIDATION ERRORS
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

  Scenario Outline: MANDATORY FIELDS LOGIN VALIDATION
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then A "<validation error>" is displayed

    Examples:
      | username | password | validation error                                       |
      |          | password | Please enter your username                             |
      | username |          | Please enter your password                             |
      |          |          | Please enter your username, Please enter your password |