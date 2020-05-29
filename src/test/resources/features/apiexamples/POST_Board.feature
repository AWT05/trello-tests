Feature: Board Controller

  Background: Set the authentication
    Given I authenticate as "user1"

  @deleteBoard
  Scenario: Create a board as a background example
    When I create a "board" with:
      | name | Hello New Board! |

