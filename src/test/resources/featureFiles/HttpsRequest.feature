@chrome
Feature: Using the HTTPS request

  Background: Establish which environment we are using
    Given I am using the "test" environment of Chromium

  Scenario: 
    Given The user "test" "test" exists
    When I delete the user
    Then I get the response code 204

  @https 
  Scenario Outline: Registering
    Given I register a user "<First Name>", "<Last Name>", "<Email>", "<Date of Birth>", "<Country>", "<Language>"
    And I get the response code 200
    When navigate to the callback URL
    Then my user account is active

    Examples: 
      | First Name | Last Name | Email                  | Date of Birth | Country | Language |
      | Auto       | Delete1   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete2   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete3   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete4   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete5   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete6   | something@blahblah.com | 01-01-2010    | GB      | EN       |
      | Auto       | Delete7   | something@blahblah.com | 01-01-2010    | GB      | EN       |
