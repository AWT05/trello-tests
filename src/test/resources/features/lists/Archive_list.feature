@acceptance
Feature: List

  Background: Set the authentication and crate a list
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | ImproveDesign |
    And I create a "list" with:
      | name    | newDesign  |
      | idBoard | {board.id} |

  @cleanData
  Scenario: Archive a list
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "ImproveDesign" board
    When I archive the "newDesign" list
    Then I verify that the "newDesign" list has been archived
