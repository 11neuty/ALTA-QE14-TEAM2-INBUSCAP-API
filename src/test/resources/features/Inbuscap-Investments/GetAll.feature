Feature: Get Investment
  @Project
  Scenario: Get all investment proposal with valid parameter page
    Given Get all investment proposal with valid parameter page 1
    When Send get investment
    Then Status code should be 200

  @Project
  Scenario Outline: Get all investment proposal with invalid parameter page
    Given Get all investment proposal with invalid parameter page <page>
    When Send get investment
    Then Status code should be 400
    Examples:
      | page |
      | satu |
      | s@tu |