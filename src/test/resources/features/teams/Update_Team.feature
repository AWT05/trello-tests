@cleanData
Feature: Team manipulation

  Background: Login to trello and team creation.
    Given I authenticate as "user1"
    And I create a "team" with:
      | displayName | Eternal Empire                                      |
      | desc        | Government based on Zakuul led by Emperor Valkorion |

  @acceptance @softAssert
  Scenario: User is able to update a team
    Given I log in with my Trello account as "user1"
    When I navigate to "Eternal Empire" section
    * I open the boards of the team page
    * I open edit team profile
    * I update the team's information with the following data
      | name        | Eternal Alliance                              |
      | type        | Education                                     |
      | description | Military organization formed by the Outlander |
      | shortName   | eternalalliance18                             |
    Then I should have the team updated with the following data
      | name        | Eternal Alliance                              |
      | description | Military organization formed by the Outlander |
