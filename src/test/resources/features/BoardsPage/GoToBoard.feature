@deleteBoard
Feature: Home context

  Background: Log in and created a board
    Given I set authentication using "user2"
    And I create a "board" with:
      | name | Cookie |

  Scenario: Open a board from boards page body
    Given I log in with my Atlassian account as "user2"
    And I navigate to "member" section
    When I select "Cookie" board
    Then "Cookie" board page should be visible