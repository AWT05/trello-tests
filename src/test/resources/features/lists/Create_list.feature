@acceptance
Feature: List

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | New test board |

#  @deleteBoard
  Scenario: Create a list
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "New test board" board
    When I create a List with:
      | name | test ui list |
    Then I should have a list created with:
      | name | test ui list |
