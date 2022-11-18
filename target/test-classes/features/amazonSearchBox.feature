Feature: Amazon Search Box
  As a user
  I should be able to go to search for an item

  Background:
    Given user is at the amazon homepage

  Scenario: User successfully searches for an item on amazon
    When we search for an item
    Then we should see the search page with matching results