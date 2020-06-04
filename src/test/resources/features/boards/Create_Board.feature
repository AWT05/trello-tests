@deleteBoard
Feature: Board context.

  Background: Login in the page
    Given I log in with my Trello account as "user2"

  Scenario: Create a simple personal board from header.
    In order have a personal container of tasks
    As admin I create a board from header and
    I want to have my board visible
    When I create a "board" from header with the following data
      | title | GUI Testing |
      | team  | No team     |
    Then "GUI Testing" board page should be visible
    And I save the identifier of the board created
    And I navigate to boards home page
    * I navigate to "member" section
    * I select "GUI Testing" board
    * "GUI Testing" board page should be visible
    And I navigate to boards menu from header
    * I open the "GUI Testing" board
    * "GUI Testing" board page should be visible