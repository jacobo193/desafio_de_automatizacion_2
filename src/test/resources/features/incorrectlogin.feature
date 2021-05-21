Feature: incorrect Login

  As a Swag Labs customer
  I want to log in to the platform
  In order to do some shopping

  Background:
    Given I am on Login page with invalid credentials

  Scenario: Login with invalid credentials
    When I enter invalid username and password
    Then I wont  redirected to Products page