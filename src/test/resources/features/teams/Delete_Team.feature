Feature: Team manipulation

  Background: Login to trello and team creation.
    Given I authenticate as "user1"
    And I create a "team" with:
      | displayName | Eternal Empire |

  @acceptance
  Scenario: User is able to delete a team
    Given I log in with my Trello account as "user1"
    When I navigate to boards menu from header
    And I open the "Eternal Empire" team
    And I open settings
    And I delete the team
    Then I navigate to "Eternal Empire" section
    And I should not find the team
