Feature: As a user I want to validate the login procedure

  Scenario: User failed login attempt (1)
   Given I am using the "test" environment of MEE
    And I have clicked on the login button
    When I enter incorrect user credentials
    Then A message is displayed informing the user that the login process has failed

  Scenario: As a user I want to login to the application (2)
    Given I am using the "test" environment of MEE
    And I have clicked on the login button
    When I enter some valid credentials
    Then I am logged into MEE

  Scenario Outline: As a user, when I try to open PDFs from my device without a PDF viewer installed
    Given that a user has accessed a product that contains PDF files
    When the user clicks on a PDF link without a PDF viewer installed on their '<device>'
    Then the approprate '<error message>' is displayed
    And a link to the app required in the device appropriate app store is displayed
      | device  | error message                                          |
      | iOS     | You need to download iBooks to view PDFs               |
      | Android | You need to download Adobe Acrobat Reader to view PDFs |
