@deleteBoard @quitDriver
Feature: Board context.

  Background: Login in the page
    Given I am logged with my Atlassian account as "user2"

  Scenario: Create a personal simple board from header.
  I can create a personal board with the minimum required data
  from the creation button in the header's menu.

    When I create a "board" from header with the following data
      | title | GUI Testing |
    Then I should have a board created with the following data
      | title | GUI Testing |
