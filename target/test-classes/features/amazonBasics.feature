Feature: Amazon Basics
  As a user
  I should be able to go to amazon basics page

  Background:
    Given we are at the amazon homepage

  Scenario: User successfully navigates to amazon basics page
    When we select the amazon basics option
    Then we should see amazon basics page