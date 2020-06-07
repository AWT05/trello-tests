@acceptance
Feature: list interactions

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | ToShareApp |
    And I invite a member by setting its type with:
      | user2 | normal |
    And I create a "list" with:
      | name    | toShare    |
      | idBoard | {board.id} |

  @cleanData
  Scenario: updating a list from other account
    Given I log in with my Trello account as "user2"
    And I navigate to boards menu from header
    And I open the "ToShareApp" board
    When I update the "toShare" List with:
      | name | reName |
    Then I should have a list updated with:
      | name | reName |
