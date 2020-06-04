@deleteTeam
Feature: Team manipulation

  Background: Login to trello.
    Given I log in with my Trello account as "user2"

  @acceptance
  Scenario: User is able to create a team
    When I create a "team" from header with the following data
      | name | Sith Empire |
      | type | Education   |
    And I skip inviting members
    Then I should have a team created with the following data
      | name | Sith Empire |
    And I save the identifier of the team created
