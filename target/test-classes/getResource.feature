
@Deutsche
Feature: get the resources

  @Deutsche
  Scenario: Validate get Nace Details service
    Given Get nace details order is called
    Then Status should be 200
    And  response should have different user parameters

  