Feature: Card Controller

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Hello New Board! |
    And I create a "list" with:
      | name    | New list   |
      | idBoard | {board.id} |

  @deleteCard @deleteBoard
  Scenario: Create a Card as a background example
    When I create a "card" with:
      | name   | New card  |
      | idList | {list.id} |
