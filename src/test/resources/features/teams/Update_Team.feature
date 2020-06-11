@cleanData
Feature: Team manipulation

  Background: Login to trello.
    Given I authenticate as "user1"
    And I create a "team" with:
      | displayName | Eternal Empire                                      |
      | desc        | Government based on Zakuul led by Emperor Valkorion |

  Scenario: User is able to update a team
    Given I log in with my Trello account as "user1"
    When I navigate to boards menu from header
    And I open the "Eternal Empire" team
    When I open edit team profile
    And I update the team's information with:
      | name        | Eternal Alliance                              |
      | description | Military organization formed by the Outlander |
      | shortName   | eternalalliance18                             |
    Then I should have the team with shortname "eternalalliance18"
    And I should have the team updated with:
      | name        | Eternal Alliance                              |
      | description | Military organization formed by the Outlander |
