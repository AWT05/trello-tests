@deleteBoardUi @deleteTeam @quitDriver
Feature: Board context.

  Background: Login in the page
    Given I authenticate as "user2"
    And I create a "team" with:
      | displayName | TEAM test |
    And I log in with my Trello account as "user2"

  Scenario: Create a simple Team board from header.
    When I create a "board" from header with the following data
      | title | GUI Testing |
      | team  | TEAM test   |
    Then "GUI Testing" board page should be visible
    And I navigate to boards menu from header
    * I select "GUI Testing" board form the "TEAM test" team
    * "GUI Testing" board page should be visible
    And I navigate to boards home page
    * I navigate to "TEAM test" section
    * I select "GUI Testing" board
    * "GUI Testing" board page should be visible
    And I navigate to boards home page
    * I navigate to "TEAM test" section
    * I open the boards of the team page
    * I open the "GUI Testing" board team
    * "GUI Testing" board page should be visible
