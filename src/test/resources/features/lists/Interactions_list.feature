@acceptance
Feature: list interactions

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Test Board |
    And I invite "user2" as member with:
      | type | normal |
    And I create a "list" with:
      | name    | test list  |
      | idBoard | {board.id} |

  @deleteBoard
  Scenario: updating a list from other account
    Given I log in as "user2"
    And I navigate to boards page
    And I open the "Test Board" board
    When I update the "Test list" List with:
      | name | update ui list |
    Then I should have a list updated with:
      | name | update ui list |

  @deleteBoard
  Scenario: archive a list from other account
    Given I log in as "user2"
    And I navigate to boards page
    And I open the "Test Board" board
    When I archive the "test list" list
    Then I verify that the list has been archived

