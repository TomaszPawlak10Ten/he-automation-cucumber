@search
Feature: Users can carry out a search
  As a user
  I need to be able to conduct searches
  So that I can find what I need on the website

  Scenario: User can carry out a search
    Given I am on the site search page
    When I enter "Andover" into the search bar
    Then a list of results should display

  Scenario: User can view a search result
    Given I am on the site search page
    When I enter "Andover" into the search bar
    And I select the first result
    Then a new page should open

  Scenario: User can apply search filters
    Given I am on the site search page
    And I enter "Andover" into the search bar
    When I select the articles and web pages filter
    Then only article and web page results should return