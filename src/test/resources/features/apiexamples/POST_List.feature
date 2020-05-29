Feature: List Controller

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Hello New Board! |

  @deleteBoard
  Scenario: Create a list as a background example
    When I create a "list" with:
      | name    | New list   |
      | idBoard | {board.id} |
