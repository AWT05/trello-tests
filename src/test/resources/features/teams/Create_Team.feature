@cleanData
Feature: Team manipulation

  Background: Login to trello.
    Given I log in with my Trello account as "user1"

  @acceptance @softAssert
  Scenario: User is able to create a team
    When I create a "team" from header with the following data
      | name        | Sith Empire                                             |
      | type        | Education                                               |
      | description | Ancient monastic and kraterocratic cultist organization |
    And I skip inviting members
    And I save the identifier of the team created
    Then I should have a team created with the following data
      | name | Sith Empire |
    And I navigate to boards home page
    * I navigate to boards menu from header
    * I open the "Sith Empire" team
    * I should have a team created with the following data
      | name | Sith Empire |
    And I navigate to boards home page
    * I navigate to "Sith Empire" section
    * I open the boards of the team page
    * I should have a team created with the following data
      | name | Sith Empire |
