@login @regression
Feature: Regression tests for the login feature

  Scenario Outline: User is diverted to the forgot username webpage (1a)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot username link

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
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot password link

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

  Scenario Outline: User is diverted to the forgot username webpage (1c)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I select language "<Language>"
    And I click the forgot username and password link

    Examples:
      | Language           |
      | Korean             |
      | English            |
      | Spanish            |
      | Japanese           |
      | Taiwanese          |
      | Vitenamese         |
      | Chinese            |
      | ChineseTraditional |

@negative
  Scenario: User failed login attempt (2a)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    And I select language "English"
    When I log in as username "blahblahblah" and password "asdasdasd"
    Then A message is displayed informing the user that the login process has failed

@negative
  Scenario Outline: User failed login attempt (2b)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I log in as username "<username>" and password "<password>"
    Then A "<validation error>" is displayed

    Examples:
      | username | password | validation error                                       |
      |          | password | Please enter your username                             |
      | username |          | Please enter your password                             |
      |          |          | Please enter your username, Please enter your password |

@postive
  Scenario Outline: User successful login attempt (3a)
    Given I am on the MEE portal for "dev"
    And I have clicked on the login button
    When I log in as username "<username>" and password "<password>"
    Then I am logged into MEE
    Then I log out of MEE

    Examples:
      | username | password  |
      | meeadmin | M4cmillan |
      | meetest  | meetest   |
      | tmomoh4  | QWnjAZpg  |

