@deleteBoardUi
Feature: Board context.

  Background: Login in the page
    Given I log in with my Trello account as "user1"

  Scenario: Create a personal simple board from header.
    In order have a personal container of tasks
    As admin I create a board from header and
    I want to have my board visible
    When I create a "board" from header with the following data
      | title | GUI Testing |
    Then "GUI Testing" board page should be visible
