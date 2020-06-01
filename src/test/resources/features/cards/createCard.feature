@acceptance
Feature: Card

  Background: Login and setup environment for card testing
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | New board |
    And I create a "list" with:
      | name    | Jacoco   |
      | idBoard | {board.id} |

  @deleteBoard
  Scenario: Create a card
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "New board" board
    When In the "Jacoco" list I create a Card with:
      | name | Task 1 |
    Then In the "Jacoco" I should have a card with:
      | name | Task 1 |
