@download
Feature: Login and download the MEE app
  SIN-2108 - Download MEE App
#DO NOT USE THIS FEATURE OF MEEADMIN LOGON
  Scenario Outline: Download App

    Given I am on the MEE portal for "test"
    Then I have clicked on the Landing Page login button
    When I select language "<Language>"
    When I log in as username "<username>" and password "<password>"
    Then I am logged into MEE

    #Check the Download Links are working
    Then I should be redirected to the Download App page
    And I confirm the Download is functioning for "Windows"
    And I confirm the Download is functioning for "MAC"
    And I confirm the Download is functioning for "Linux32"
    And I confirm the Download is functioning for "Linux64"
    Then I log out of MEE


    Examples:
      | Language | username | password  |
      | English  | meeadmin | M4cmillan |
