@acceptance
Feature: List

  Background: Set the authentication and crate a list
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | WorldNews |
    And I create a "list" with:
      | name    | testing    |
      | idBoard | {board.id} |

  @cleanData
  Scenario: Update a list name
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "WorldNews" board
    When I update the "testing" List with:
      | name | reviewed |
    Then I should have a list updated with:
      | name | reviewed |
