@deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given "user1" logs in with

  Scenario: User is able to update a team's short name
    Given "user1" creates a team with the following data:
      | name | My Sith Team |
      | type | Education    |
    When "user1" changes short name to "sithempire"
    Then new short name should be "sithempire"