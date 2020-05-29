@quitDriver @deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given I log in with my Trello account as "user1"

  Scenario: User is able to create a team
    When I create a "team" from header with the following data
      | name | Sith Empire |
      | type | Education   |
    Then I skip inviting members
    And I should have a team created with the following data
      | name | Sith Empire |