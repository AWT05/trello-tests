@acceptance @smoke
Feature: Card

  Background: Login and setup environment for card testing
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Hero Stack 1 |
    And I create a "list" with:
      | name    | Chaos Knight |
      | idBoard | {board.id}   |

  @cleanData
  Scenario: Create a card
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "Hero Stack 1" board
    When I create a card on "Chaos Knight" list with:
      | name | Equipment |
    Then I should have a card on "Chaos Knight" list with:
      | name | Equipment |
