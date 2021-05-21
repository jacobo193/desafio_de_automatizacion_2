Feature: lockout Login

  As a Swag Labs customer
  I want to log in to the platform
  In order to do some shopping

  Background:
    Given I am on Login page with lockout credentials

  Scenario: Login with lockout credentials
    When I enter lockout username and password
    Then I  cannot be able to enter to Products page