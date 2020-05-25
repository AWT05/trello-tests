Feature: Board Controller

  Background: Set the authentication
    Given I set authentication using "user1"

  @deleteTeam
  Scenario: Create a board as a background example
    When I create a "team" with:
      | displayName | new Team test |

