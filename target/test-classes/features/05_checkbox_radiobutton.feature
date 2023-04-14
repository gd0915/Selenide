@radio_checkbox
Feature: Checkbox and Radio Button
  @checkbox
  Scenario: TC01_checkbox
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=checkboxes"
    And I click on "Checkbox 1" if not already selected
    And I click on "Checkbox 2" if not already selected
    Then I hold the browser open
  @radioButton01
  Scenario: TC02_radio
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
    And I click on "Red" if not already selected
    Then I hold the browser open
  @radioButton02
  Scenario: TC03_radio
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
    And I click on "Yellow" if not already selected
    Then I hold the browser open
  @radioButton03
  Scenario: TC04_radio
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
    And I click on "Football" if not already selected
    Then I hold the browser open