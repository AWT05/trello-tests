@cleanData
Feature: Board context

  Background: Log in and create a board
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | Juan Party |

  Scenario: Invite members
    Given I log in with my Trello account as "user1"
    * I navigate to "member" section
    * I select "Juan Party" board
    * I close the board menu
    When I invite the following member
      | user2 |
    Then I log in with my Trello account as "user2"
    And I navigate to notifications
    * I open notification: added to "Juan Party" board
    * "Juan Party" board page should be visible
    And I navigate to boards home page
    * I navigate to "member" section
    * I select "Juan Party" board
    * "Juan Party" board page should be visible
    And I navigate to boards menu from header
    * I open the "Juan Party" board
    * "Juan Party" board page should be visible
