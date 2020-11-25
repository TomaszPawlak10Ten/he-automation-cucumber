
Feature: User can preview the print of a website page
  As a user
  I need to be able to print a page of my choice
  So that I can keep it for further reference

  @pagePrinting
  Scenario: Users can print preview the News page
    Given I am on the News page
    When I click on the print button
    Then a print preview should open and I can click cancel


