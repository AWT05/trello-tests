@cleanData
Feature: Team manipulation

  Background: Login to trello.
    Given "user1" logs in with
    And creates a team with the following data:
      | name | My Sith Team |
      | type | Education    |
    And adds "user2" as a team member

  Scenario: User is able to add a member to a team
    When "user2" logs in
    Then should access the team settings from sidebar menu
    And navigates to boards page
    And should access the team settings
