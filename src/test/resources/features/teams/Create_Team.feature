@deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given "user1" logs in with

  Scenario: User is able to create a team
    When "user1" creates a team with the following data:
      | name | My Jedi Team |
      | type | Education    |
    Then verifies the team is created