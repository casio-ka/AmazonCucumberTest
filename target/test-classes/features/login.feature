Feature: Amazon app login
  As a user
  I should be able to login to amazon.com

  Scenario: User login successfully
    Given we are at amazon login page
    When we provide valid credentials
    Then we should see the homepage