Feature: Amazon Checkout Filter
  As a user
  I should be able to go to checkout an item

  Background:
    Given a user is on the amazon homepage

  Scenario: User successfully adds an item to checkout
    When we searched for an item
    And we are redirected to the results page
    And we have filtered the item
    Then we should be able to checkout our preferred item