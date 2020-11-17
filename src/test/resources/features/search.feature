Feature: Search
  As a site user
  I need to use the site search functionality
  So that I can find what I need on the site

  Scenario: The user can conduct a search
    As a user
    Given I am on the site search page
    When I enter a search term into the search bar
    Then a list of results should display

  Scenario: The user can view a search result
    As a user
    Given I am on the site search page
    When I enter a search term into the search bar
    And I select the first result
    Then a new page should open