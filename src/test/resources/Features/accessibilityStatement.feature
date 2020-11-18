@accessibilityStatement
Feature: Users can access the Accessibility statement
  As a user
  I need to be able to read the sites Accessibility statement
  So that I am aware of the ongoing accessibility work

  Scenario: User can access the accessibility statement
    As a user
    Given I am on the landing page
    When I scroll down to the bottom of the page
    And I click on the Accessibility link
    Then I should be taken to the Accessibility statement