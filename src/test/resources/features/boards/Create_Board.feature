@deleteBoard @quitDriver
Feature: Board context.

  Background: Login in the page
    Given I log in with my Atlassian account as "user2"

  Scenario: Create a personal simple board from header.
    In order have a personal container of tasks
    As admin I create a board from header and
    I want to have my board visible

  from the creation button in the header's menu.

    When I create a "board" from header with the following data
      | title | GUI Testing |
    Then I should have a board created with the following data
      | title | GUI Testing |
