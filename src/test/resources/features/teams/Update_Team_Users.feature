@cleanData
Feature: Team interactions

  Background: Login to trello and team creation.
    Given I authenticate as "user1"
    And I create a "team" with:
      | displayName | Galactic Republic               |
      | desc        | Ruling government of the galaxy |
    And I add team members with:
      | user2 | normal |

  @acceptance @softAssert
  Scenario: User2 is able to edit a team that he is part of
    Given I log in with my Trello account as "user2"
    When I navigate to "Galactic Republic" section
    * I open the boards of the team page
    * I open edit team profile
    * I update the team's information with the following data
      | name        | Galactic Empire             |
      | type        | Operations                  |
      | description | Unlimited powaaaaaaahhhhhhh |
      | shortName   | dewit19                     |
    Then I should have the team updated with the following data
      | name        | Galactic Empire             |
      | description | Unlimited powaaaaaaahhhhhhh |
