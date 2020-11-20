Feature: Users can filter archive search results
  As a user
  I need to be able to filter my search results
  So that I can get a more accurate search with less results

  @ACOFilter
  Scenario: Archive search results can be filtered
    Given I have searched for 'Castle' in the find photos search bar
    And I click on the Filter Results button
    When I type 'Hampshire' into the County field and select Hampshire from the drop down
    And I type 'Winchester' into the District field and select Winchester from the drop down
    And I type '1990' into the After Date field
    And I type '2020' into the Before Date field
    And I type 'Castle' into the Building Type field and select Castle
    And I click on the Apply Filters button
    Then twenty three results should be returned
