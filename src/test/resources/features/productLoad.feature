Feature: loading products
  as a client
  I want to see de products

  Background:
    Given : I am in the product page

    Scenario: successful load products
      When : I introduce a right user and password
      Then : I can seee a list of products
