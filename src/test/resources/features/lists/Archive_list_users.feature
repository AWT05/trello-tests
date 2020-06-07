@acceptance
Feature: list interactions

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | CheckApp |
    And I invite a member by setting its type with:
      | user2 | normal |
    And I create a "list" with:
      | name    | ToReview   |
      | idBoard | {board.id} |

  @cleanData
  Scenario: Archive a list
    Given I log in with my Trello account as "user2"
    And I navigate to boards menu from header
    And I open the "CheckApp" board
    When I archive the "ToReview" list
    Then I verify that the "ToReview" list has been archived
