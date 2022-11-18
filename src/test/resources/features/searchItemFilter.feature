Feature: Amazon Search Item Filter
  As a user
  I should be able to go to filter a searched item

  Background:
    Given a user is at the amazon homepage

  Scenario: User successfully filters an item after search
    When we have searched for an item
    And we are on the results page
    Then we should be able to filter our search items