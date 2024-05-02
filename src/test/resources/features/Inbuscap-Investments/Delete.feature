Feature: Delete Investment
  @Project
  Scenario: Delete data investment with valid proposal id
    Given Delete data investment with valid proposal id 1
    When Send delete investment
    Then Status code should be 200

  @Project
  Scenario: Delete data investment with invalid proposal id
    Given Delete data investment with invalid proposal id "s@tu"
    When Send delete investment
    Then Status code should be 400