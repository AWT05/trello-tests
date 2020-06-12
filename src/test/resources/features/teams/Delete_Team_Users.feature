Feature: Team manipulation

  Background: Login to trello and team creation.
    Given I authenticate as "user1"
    And I create a "team" with:
      | displayName | Yuuzhan Vong    |
      | desc        | The Chosen Race |
    And I add team members with:
      | user2 | admin |

  Scenario: User2 is able to delete a team he is part of
    Given I log in with my Trello account as "user2"
    When I navigate to boards menu from header
    And I open the "Yuuzhan Vong" team
    And I open settings
    And I delete the team
    Then I navigate to "Yuuzhan Vong" section
    And I should not find the team
