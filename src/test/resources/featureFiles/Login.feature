@login
Feature: Regression tests for the login feature

  Scenario Outline: User is diverted to the forgot username webpage (1a)
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
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
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
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
    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
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

  @help
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
    And I have clicked on the Next button
    Then I select the Terms of Use link
    Then I select the Privacy Policy link

    Examples:
      | Language | Firstname | Surname | Country | day | month | year |
      | English  | Private   | Terms   | GB      | 7   | May   | 1956 |

