@acceptance @smoke
Feature: Card

  Background: Login and setup environment for card testing
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | UI Testing Board |
    And I create a "list" with:
      | name    | Jacoco     |
      | idBoard | {board.id} |

  @cleanData
  Scenario: Create a card
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "UI Testing Board" board
    When I create a card on "Jacoco" list with:
      | name | Task 1 |
    Then I should have a card on "Jacoco" list with:
      | name | Task 1 |
