Feature: glitch loading products
  as a client
  I want to see the of products

  Background:
    Given : I introduce a problem user

  Scenario: problem login
    When : I introduce a glitch_performance_user user and password
    Then : I can see a list of products
