@findPhotos
Feature: Users can search for photos
  As a user
  I need to use the find photos search bar
  So that I can search for historical photos


  # This test won't run and I'm not sure why; it won't accept the data table.

  Scenario Outline: searching for photos
    Given I am on the Find Photos page
    When I search for <search term>
    Then I should be taken to the results page
    Examples:
      | search term |
      | Andover     |
      | Castle      |
      | Fish        |




