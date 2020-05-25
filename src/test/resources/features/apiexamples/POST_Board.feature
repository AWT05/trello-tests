Feature: Board Controller

  Background: Set the authentication
    Given I set authentication using "user1"

  @deleteBoard
  Scenario: Create a board as a background example
    When I create a "board" with:
      | name | Hello New Board! |

