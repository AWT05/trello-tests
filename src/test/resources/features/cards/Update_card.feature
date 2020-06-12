@acceptance
Feature: Card

  Background: Login and setup environment for card testing
    Given I authenticate as "user2"
    And I create a "board" with:
      | name | Hero Stack |
    And I create a "list" with:
      | name    | Crystal Maiden |
      | idBoard | {board.id}     |
    And I create a "card" with:
      | name   | Abilities |
      | idList | {list.id} |

  @cleanData
  Scenario: Update the title of a card
    Given I log in with my Trello account as "user2"
    And I navigate to boards menu from header
    And I open the "Hero Stack" board
    When I update the "Abilities" card in the "Crystal Maiden" list with:
      | description | Freezing Field |
    Then I should "Freezing Field" as the card's description
