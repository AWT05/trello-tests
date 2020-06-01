@deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given I log in with my Trello account as "user1"

  Scenario: User is able to delete a team
    Given I create a "team" from header with the following data
      | name | My Jedi Council |
      | type | Education       |
    When I delete the team with
      | name | My Jedi Council |
    Then I should not find the team