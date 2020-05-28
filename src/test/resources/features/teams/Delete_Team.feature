@deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given "user1" logs in with

  Scenario: User is able to delete a team
    Given "user1" creates a team with the following data:
      | name | My Jedi Council |
      | type | Education       |
    When "user1" deletes the team
    Then "user1" cannot find the team created