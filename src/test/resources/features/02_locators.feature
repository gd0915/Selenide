@locators
Feature: locators feature
  Scenario: TC01_locators
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=form-authentication"
    And I wait for 3 seconds
    And I enter username
    And I wait for 3 seconds
    And I enter password
    And I wait for 3 seconds
    And I enter submit button
    And I wait for 3 seconds
    Then verify login is successful
    And I wait for 3 seconds
    And click on logout link
    Then I hold the browser open

#    In Selenide framework, we can find web elements with both Selenide OR Selenium locators.
#  $ character => used to find single element
#  $ character => returns SelenideElement
#       1st way=> public SelenideElement inputField = $(cssSelector:"[name='q']");
#       2nd way=> public SelenideElement inputField = $(By.name=("q"));  => $(By) -> 8 locators
#  $$ character => used to find multiple elements
#  $$ character => returns List<SelenideElement>
#  $$ character => returns also ElementsCollection


#   STEPS
#   1. create feature file
#   2. write test cases
#   3. create stepdefinitions class and type java codes
#   4. create page class under pages package
#   5. find username, password, and submit button