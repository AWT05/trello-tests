@cleanData
Feature: Board context.

  Background: Login in the page
    Given I log in with my Trello account as "user1"

  Scenario: Create a simple personal board from header.
    When I create a "board" from header with the following data
      | title | Trello  |
      | team  | No team |
    And I save the identifier of the board created
    Then "Trello" board page should be visible
    And I navigate to boards home page
    * I navigate to "member" section
    * I select "Trello" board
    * "Trello" board page should be visible
    And I navigate to boards menu from header
    * I open the "Trello" board
    * "Trello" board page should be visible
