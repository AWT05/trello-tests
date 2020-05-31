@deleteBoard @deleteTeam
Feature: Home context

  Background: Log in and created a board in a team
    Given I authenticate as "user2"
    And I create a "team" with:
      | displayName | Team Cookie |
    And I create a "board" with:
      | name           | Cookie    |
      | idOrganization | {team.id} |

  Scenario: Open a team's board from boards page body
    Given I log in with my Trello account as "user2"
    And I navigate to "Team Cookie" section
    When I select "Cookie" board
    Then "Cookie" board page should be visible
