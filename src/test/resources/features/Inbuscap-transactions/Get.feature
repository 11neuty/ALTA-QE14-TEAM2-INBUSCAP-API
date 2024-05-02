Feature: Get Transaction
  @Project
  Scenario: Get available returns from investment with valid path
    Given Get available returns from investment with valid path "returns"
    When Send request get available returns
    Then Status code should be 200

  Scenario: Get available returns from investment with invalid path
    Given Get available returns from investment with invalid path "return"
    When Send request get available returns
    Then Status code should be 404
