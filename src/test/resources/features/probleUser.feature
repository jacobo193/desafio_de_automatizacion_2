Feature:problem Login

  As a Swag Labs customer
  I want to log in to the platform
  In order to do some shopping

  Background:
    Given I am on Login page with problem credentials

  Scenario: Login with Problem credentials
    When I enter  username and password
    Then I will sitll able to see the products