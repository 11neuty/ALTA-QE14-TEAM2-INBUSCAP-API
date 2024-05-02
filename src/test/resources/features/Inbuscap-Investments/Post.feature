Feature: Post Investment
  @Project
  Scenario: Add new investment with valid data json
    Given Add new investment with valid data json "AddValidInvestment.json"
    When Send request add new investment
    Then Status code should be 201

  @Project
  Scenario Outline: Add new investment with invalid proposal id
    Given Add new investment with invalid proposal id "<json>"
    When Send request add new investment
    Then Status code should be 201
    Examples:
      | json           |
      |AddInvalid1.json|
      |AddInvalid2.json|
      |AddInvalid3.json|

  @Project
  Scenario Outline: Add new investment with invalid amount
    Given Add new investment with invalid amount "<json>"
    When Send request add new investment
    Then Status code should be 201
    Examples:
      | json           |
      |AddInvalid4.json|
      |AddInvalid5.json|

  @Project
  Scenario Outline: Add new investment with invalid proposal id and amount
    Given Add new investment with invalid proposal id and amount "<json>"
    When Send request add new investment
    Then Status code should be 201
    Examples:
      | json           |
      |AddInvalid6.json|
      |AddInvalid7.json|