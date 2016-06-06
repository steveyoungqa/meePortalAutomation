@end2end
Feature: Regression End to End Test Pack
  SIN-2255 - Regression Test Pack

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
    And I have clicked on the Next button
    Then a message "Please enter your first name" is displayed
    Then a message "Please enter your last name" is displayed
    Then a message "Please select your country of residence" is displayed
    Then a message "Please enter a valid date of birth" is displayed
    Then I register a first name of "Vera&" and surname of "Validation<"
    And I have clicked on the Next button
    Then a message "First name must not contain special characters" is displayed
    Then a message "Last name must not contain special characters" is displayed

    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    Then I register a first name of "Vera" and surname of "Validation"
    And I select a Country of residence of "GB"
    Then I select a date of birth of "3" "Oct" "1994"
    And I have clicked on the Next button
    Then I Pause for 3 seconds
    And I select the Submit button
    Then a message "Email address required" is displayed


  Scenario Outline: Mandatory fields Login validation
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then A "<validation error>" is displayed

    Examples:
      | username | password | validation error                                       |
      |          | password | Please enter your username                             |
      | username |          | Please enter your password                             |
      |          |          | Please enter your username, Please enter your password |

  Scenario: Incorrect Login details validation
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I select language "English"
    When I log in as username "noSuchUser" and password "completelyMadeUpRandom"
    Then A message is displayed informing the user that the login process has failed

  Scenario Outline: Forgotten Username, Password validation
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I select language "<Language>"
    And I click the Forgot username link
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I click the Forgot Password link
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I click the forgot username and password link

    Examples:
      | Language           |
      | Spanish            |
      | English            |
      | Japanese           |
      | Korean             |
      | Taiwanese          |
      | Vitenamese         |
      | Chinese            |
      | ChineseTraditional |

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

#    Download App Links & File content Verification
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I Login with the newly created username and password
    Then I should be redirected to the Download App page
    And I confirm the Download is functioning for "Windows"
    And I confirm the Download is functioning for "MAC"
    And I confirm the Download is functioning for "Linux32"
    And I confirm the Download is functioning for "Linux64"

    #    Add Resource, Redeem & Activate
    And I select the Add Resource icon
    Then I enter an incorrect Access code
    And I have clicked on the Access code Next button
    Then a message "Invalid access code. Please check your code and try again." is displayed
    Then I enter an Access code of "<AccessCode>"
    And I have clicked on the Access code Next button
    Then I should see an Activate message for "<Resource>"
    Then I should see an Activate message for "<Resource2>"
    And I select Activate
    Then a message "Success! Your access code has been activated." is displayed

#    Edit Personal Details
    And I select the Profile icon
    Then I select Edit Details
    Then I register a first name of "EditFirstName" and surname of "EditSurname"
    Then I select a date of birth of "1" "Jan" "1943"
    And I have clicked on the Next button
    And I select the Submit button
    Then a message "Personal details updated" is displayed

#    Edit Personal Details back to the original values
    And I select the Profile icon
    Then I select Edit Details
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    And I select the Submit button
    Then a message "Personal details updated" is displayed
    And I log out of MEE

    Examples:
      | Language | Firstname | Surname    | Country | day | month | year | AccessCode        | Resource                      | Resource2                       |
      | English  | Roger     | Regression | GB      | 7   | May   | 1956 | HFTL1199319198437 | TEST High Five! Level 1 Pupil | TEST High Five! Level 1 Teacher |


  Scenario Outline: U16 Registration
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter a Parent/Guardian email address
    Then I enter a confirmation of the unique Parent/Guardian email address
    And I select the Submit button
    Then I should see the Email sent confirmation page

    Then I check the Parent/Guardian Mailinator account for the email
    Then I switch Windows back to the MEE Portal
    Then I should see the Registration Completed screen
    And I select the Close button

    Then I have clicked on the Landing Page login button
    And I select language "<Language>"
    Then I Login with the newly created username and password
    Then I log out of MEE

    Examples:
      | Language | Firstname | Surname | Country | day | month  | year |
      | English  | Mikey     | Minor   | GB      | 11  | August | 2004 |

  Scenario: SIN-2109 Help Page Links Test
    Given I am on the MEE portal for "test"
    Then I select the Help icon
    And I select all of the Help section links

  Scenario Outline: SIN-2423 Privacy Policy and T&C's
    Given I am on the MEE portal for "test"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I select the Terms of Use link
    Then I select the Privacy Policy link

    Examples:
      | Language | Firstname | Surname | Country | day | month | year |
      | English  | Private   | Terms   | GB      | 7   | May   | 1956 |