Feature: Transaction

   #TOP UP (+)
  @Project
    Scenario: Top Up with valid data json
    Given Top Up with valid data "TopUpValid.json"
    When Send request Top Up
    Then Status code should be 201
    And Response body message was "transaction is created"

  #TOP UP (-)
  @Project
  Scenario Outline: Top Up with valid invalid payment type
    Given Top Up with invalid payment type <json>
    When Send request Top Up
    Then Status code should be 400
    Examples:
      | json               |
      | TopUpInvalid1.json |
      | TopUpInvalid2.json |

  @Project
  Scenario: Top Up with valid invalid amount
    Given Top Up with invalid amount "TopUpInvalid3.json"
    When Send request Top Up
    Then Status code should be 400

  @Project
  Scenario: Top Up with valid invalid payment_type and amount
    Given Top Up with invalid payment_type and amount "TopUpInvalid4.json"
    When Send request Top Up
    Then Status code should be 400

  #WITHDRAW (+)
  @Project
  Scenario: Withdraw with valid data json
    Given Withdraw with valid data "WithdrawValid.json"
    When Send request withdraw
    Then Status code should be 201

#WITHDRAW (-)
  @Project
  Scenario: Withdraw with invalid bank
    Given Withdraw with invalid bank "WithdrawInvalid1.json"
    When Send request withdraw
    Then Status code should be 400

  @Project
  Scenario: Withdraw with invalid bank account
    Given Withdraw with invalid bank account "WithdrawInvalid2.json"
    When Send request withdraw
    Then Status code should be 400

  @Project
  Scenario: Withdraw with invalid amount
    Given Withdraw with invalid amount "WithdrawInvalid3.json"
    When Send request withdraw
    Then Status code should be 400

  @Project
  Scenario: Withdraw with invalid bank, bank account and amount
    Given Withdraw with invalid bank, bank account and amount "WithdrawInvalid4.json"
    When Send request withdraw
    Then Status code should be 400

    #GET (+) TRANSACTION
  @Project
  Scenario: Get available returns from investment with valid path
    Given Get available returns from investment with valid path "returns"
    When Send request get available returns
    Then Status code should be 200

  #GET (-) TRANSACTION
  @Project
  Scenario: Get available returns from investment with invalid path
    Given Get available returns from investment with invalid path "return"
    When Send request get available returns
    Then Status code should be 404



