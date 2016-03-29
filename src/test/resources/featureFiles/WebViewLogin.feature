@meeportal
Feature: Regression tests for the login feature

#  These scenarios will be handled in the webview (chrome)
  Scenario Outline: User is diverted to the forgot username webpage (1a)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot username link
#    Then to user is navigated to the correct "<Link>"

    Examples:
      | Language           | Link                         |
      | Spanish            | es/Forgot/ForgotUsername     |
      | English            | en/Forgot/ForgotUsername     |
      | Japanese           | ja/Forgot/ForgotUsername     |
      | Korean             | ko/Forgot/ForgotUsername     |
      | Taiwanese          | th/Forgot/ForgotUsername     |
      | Vitenamese         | vi/Forgot/ForgotUsername     |
      | Chinese            | zh-chs/Forgot/ForgotUsername |
      | ChineseTraditional | zh-cht/Forgot/ForgotUsername |

  Scenario Outline: User is diverted to the forgot username webpage (1b)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot password link
#    Then to user is navigated to the correct "<Link>"

    Examples:
      | Language           | Link                         |
      | Japanese           | ja/Forgot/ForgotPassword     |
      | English            | en/Forgot/ForgotPassword     |
      | Spanish            | es/Forgot/ForgotPassword     |
      | Korean             | ko/Forgot/ForgotPassword     |
      | Taiwanese          | th/Forgot/ForgotPassword     |
      | Vitenamese         | vi/Forgot/ForgotPassword     |
      | Chinese            | zh-chs/Forgot/ForgotPassword |
      | ChineseTraditional | zh-cht/Forgot/ForgotPassword |

  Scenario Outline: User is diverted to the forgot username webpage (1c)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot username and password link
#    Then to user is navigate d to the correct "<Link>"

    Examples:
      | Language           | Link                                    |
      | Korean             | ko/Forgot/ForgotUsernameAndPassword     |
      | English            | en/Forgot/ForgotUsernameAndPassword     |
      | Spanish            | es/Forgot/ForgotUsernameAndPassword     |
      | Japanese           | ja/Forgot/ForgotUsernameAndPassword     |
      | Taiwanese          | th/Forgot/ForgotUsernameAndPassword     |
      | Vitenamese         | vi/Forgot/ForgotUsernameAndPassword     |
      | Chinese            | zh-chs/Forgot/ForgotUsernameAndPassword |
      | ChineseTraditional | zh-cht/Forgot/ForgotUsernameAndPassword |

  Scenario: User failed login attempt (2a)
    Given I am on the MEE portal for "dev"
    And I select language "English"
    When I log in as username "blahblahblah" and password "asdasdasd"
    Then A message is displayed informing the user that the login process has failed
#
#  Scenario Outline: User failed login attempt (2b)
#    Given I am on the MEE portal for "UAT"
#    When I log in as username "<username>" and password "<password>"
#    Then A "<validation error>" is displayed
#
#    Examples:
#      | username | password | validation error   |
#      |          | password | Username           |
#      | username |          | Password           |
#      |          |          | Username, Password |
#
#  Scenario Outline: User successful login attempt (3a)
#    Given I am on the MEE portal for "dev"
#    When I log in as username "<username>" and password "<password>"
#    Then I am logged into MEE
#
#    Examples:
#      | username    | password    |
#      | test        | test        |
#      | 鱼鱼鱼鱼鱼鱼 | 鱼鱼鱼鱼鱼鱼 |
#      | 起起起起起起 | JaGXYxwA    |
#
