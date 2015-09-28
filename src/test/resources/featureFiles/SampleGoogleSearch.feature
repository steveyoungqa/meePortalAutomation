Feature: Sample feature file for writing tests
  As an automation tester
  I want to know how to write automation tests in Selenium with Cucumber
  So that I can reduce my manual effort

  Scenario: Opening Google, searching for some text and getting back the page title
    Given I am on "http://www.google.com"
    When I search for "Water on mars"
    Then my web page title is "Water on mars - Google Search"
