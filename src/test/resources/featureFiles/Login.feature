@login
Feature: Regression tests for the login feature

  Scenario Outline: User is diverted to the forgot username webpage (1a)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I select language "<Language>"
    And I click the Forgot username link

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

  Scenario Outline: User is diverted to the forgot username webpage (1b)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I select language "<Language>"
    And I click the Forgot Password link

    Examples:
      | Language           |
      | Japanese           |
      | English            |
      | Spanish            |
      | Korean             |
      | Taiwanese          |
      | Vitenamese         |
      | Chinese            |
      | ChineseTraditional |

  @negative
  Scenario: User failed login attempt (2a)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    And I select language "English"
    When I log in as username "blahblahblah" and password "asdasdasd"
    Then A message is displayed informing the user that the login process has failed

  @negative
  Scenario Outline: User failed login attempt (2b)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then A "<validation error>" is displayed

    Examples:
      | username | password | validation error                                       |
      |          | password | Please enter your username                             |
      | username |          | Please enter your password                             |
      |          |          | Please enter your username, Please enter your password |

  @validation
  Scenario: Forgot User/Pass Validation errors
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    Then I click the Forgot Password link
    And I select the Submit button
    Then a message "Please enter your username" is displayed
    And I click on the Close form icon

  @positive
  Scenario Outline: User successful login attempt (3a)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I log in as username "<username>" and password "<password>"
    Then I am logged into MEE
    Then I log out of MEE

    Examples:
      | username | password  |
      | meeadmin | M4cmillan |
      | meetest  | meetest   |
