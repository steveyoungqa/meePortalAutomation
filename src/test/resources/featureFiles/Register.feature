@register @regression
Feature: Regression tests for registering a new user

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "dev"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I select the Help icon
    Then I enter an email address of "<email>"
    Then I enter a confirmation email address of "<email>"
#    Then I select the Terms of Use link
#    Then I select the Privacy Policy link
    And I select the Opt In checkbox
#    And I select the Submit button
    And I select the Back button
    Then I Pause for 1 seconds

    Examples:
      | Language           | Firstname | Surname    | Country | day | month  | year | email         |
      | English            | Fred      | Automation | GB      | 10  | August | 1980 | test@test.net |
      | Spanish            | Jose      | Tester     | ES      | 7   | May    | 1956 | test@test.net |
      | Japanese           | Kim       | QA         | JP      | 1   | June   | 1975 | test@test.net |
      | Korean             | Seung     | Tester     | KR      | 24  | Oct    | 1989 | test@test.net |
      | Taiwanese          | Huang     | Selenium   | TW      | 3   | Dec    | 1990 | test@test.net |
      | Vitenamese         | Nguyen    | Automation | VN      | 17  | Feb    | 1997 | test@test.net |
      | Chinese            | Zhang Wei | Robot      | CN      | 28  | July   | 1942 | test@test.net |
      | ChineseTraditional | Liu Fang  | QA         | HK      | 2   | April  | 1980 | test@test.net |


