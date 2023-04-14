@assertions02
Feature: assertions02
  Scenario: TC02_search for tesla
    Given I navigate to "https://google.com"
    When I search for "Tesla"
    Then verify page source contains "Tesla"
    Then verify the result should contain "About" keyword
    Then the first result in the page sections should contain "Tesla"
    Then I hold the browser open

#  Created test case
#  Create page objects in the page folder
#  Create step definitions in stepdefinitions folder