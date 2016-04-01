@register
Feature: Regression tests for registering a new user

  Scenario Outline: Register a new user
    Given I am on the MEE portal for "dev"
    And I have clicked on the Register button
    When I select language "<Language>"
    Then I register a first name of "<Firstname>" and surname of "<Surname>"
    And I select a Country of residence of "<Country>"
    Then I select a date of birth of "<day>" "<month>" "<year>"
    And I have clicked on the Next button
    Then I enter an email address and confirmation of "<email>"
    And I select the marketing checkbox
    Then I select the Submit button
    Then I select the Back button

    Examples:
      | Language           | Firstname | Surname    | Country  | day | month  | year | email         |
      | English            | Fred      | Automation | Spain    | 10  | August | 1980 | test@test.com |
#      | Spanish            | Jose      | Tester     | UK       |     |        |      |               |
#      | Japanese           | Kim       | QA         | Japan    |     |        |      |               |
#      | Korean             | Seung     | Tester     | Korea    |     |        |      |               |
#      | Taiwanese          | Huang     | Selenium   | Taiwan   |     |        |      |               |
#      | Vitenamese         | Nguyen    | Automation | Vietnam  |     |        |      |               |
#      | Chinese            | Zhang Wei | Robot      | China    |     |        |      |               |
#      | ChineseTraditional | Liu Fang  | QA         | HongKong |     |        |      |               |