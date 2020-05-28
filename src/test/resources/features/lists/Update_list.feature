@acceptance
Feature: List

  Background: Set the authentication and crate a list
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Test Board |
    And I create a "list" with:
      | name    | test list  |
      | idBoard | {board.id} |

  @deleteBoard
  Scenario: Update a list name
    Given I log in as "user1"
    And I navigate to boards page
    And I open the "New test board" board
    When I update the "Test list" List with:
      | name | update ui list |
    Then I should have a list updated with:
      | name | update ui list |

  @deleteBoard
  Scenario: Create a copy of the current list
    Given I log in as "user1"
    And I navigate to boards page
    And I open the "New test board" board
    When I create a copy of "Test list" list
    Then I verify the information of the copied list

  @deleteBoard
  Scenario: Archive a list
    Given I log in as "user1"
    And I navigate to boards page
    And I open the "New test board" board
    When I archive the "test list" list
    Then I verify that the list has been archived

  @deleteBoard
  Scenario: Change de list positions
    Given I log in as "user1"
    And I navigate to boards page
    And I open the "New test board" board
    And I create a List with:
      | name | test list two |
    And I navigate to actions in the "test list" list
    When I change the its position with "test list two" list
    Then I verified that the lists have changed positions

