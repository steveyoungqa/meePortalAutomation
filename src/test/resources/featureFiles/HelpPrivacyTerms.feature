Feature: Regression tests for Help Page Links, Privacy Policy, Terms & Conditions

  @help
  Scenario Outline: Help page Translations
    Given I am on the MEE portal for "test"
    Then I select the Help icon
    And I select the main page language of "<Language>"
    Then I should see a display message of "<Translation>"

    Examples:
      | Language           | Translation            |
      | Spanish            | Requisitos del sistema |
      | Korean             | 시스템 요구사항               |
      | Japanese           | 動作環境                   |
      | Taiwanese          | ความต้องการของระบบ     |
      | Vitenamese         | Yêu cầu hệ thống       |
      | ChineseTraditional | 系統需求                   |
      | English            | System Requirements    |
      | Chinese            | 如何注册？                  |

    Scenario: SIN-2109 Help Page Links Test
    Given I am on the MEE portal for "test"
    Then I select the Help icon
    And I select all of the Help section links


  @privacyTerms
  Scenario Outline: SIN-2423 Privacy Policy and T&C's
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