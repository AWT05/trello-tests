@acceptance
Feature: List

  Background: Login and setup environment for card testing
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | New board |
    And I create a "list" with:
      | name | New list |

  @deleteBoard
  Scenario: Create a card
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "New test board" board
    And I open the "New list" list
    When I create a Card with:
      | name | Card 1 |
    Then I should have a list created with:
      | name | Card 1 |

