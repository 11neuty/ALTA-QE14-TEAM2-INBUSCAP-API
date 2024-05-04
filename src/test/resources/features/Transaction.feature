Feature: Transaction

   #TOP UP (+)
  @Project
    Scenario: Top Up with valid data json
    Given Top Up with valid data "TopUpValid.json"
    When Send request Top Up
    Then Status code should be 201
    And Response body message was "transaction is created"
    And Validate Top up json schema "TopUpJsonSchema.json"


  #TOP UP (-)
  @Project
  Scenario Outline: Top Up with invalid payment type
    Given Top Up with invalid payment type "<json>"
    When Send request Top Up
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"
    Examples:
      | json               |
      | TopUpInvalid1.json |
      | TopUpInvalid2.json |

  @Project
  Scenario: Top Up with invalid amount
    Given Top Up with invalid amount "TopUpInvalid3.json"
    When Send request Top Up
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"

  @Project
  Scenario: Top Up with invalid payment_type and amount
    Given Top Up with invalid payment_type and amount "TopUpInvalid4.json"
    When Send request Top Up
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"

  #WITHDRAW (+)
  @Project
  Scenario: Withdraw with valid data json
    Given Withdraw with valid data "WithdrawValid.json"
    When Send request withdraw
    Then Status code should be 201
    And Response body message was "successfully creates request"
    And Validate withdraw json schema "WithdrawJsonSchema.json"

#WITHDRAW (-)
  @Project
  Scenario: Withdraw with invalid bank
    Given Withdraw with invalid bank "WithdrawInvalid1.json"
    When Send request withdraw
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"

  @Project
  Scenario: Withdraw with invalid bank account
    Given Withdraw with invalid bank account "WithdrawInvalid2.json"
    When Send request withdraw
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"


  @Project
  Scenario: Withdraw with invalid amount
    Given Withdraw with invalid amount "WithdrawInvalid3.json"
    When Send request withdraw
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"


  @Project
  Scenario: Withdraw with invalid bank, bank account and amount
    Given Withdraw with invalid bank, bank account and amount "WithdrawInvalid4.json"
    When Send request withdraw
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"

  #GET (+) TRANSACTION
  @Project
  Scenario: Get available returns from investment with valid path
    Given Get available returns from investment with valid path "returns"
    When Send request get available returns
    Then Status code should be 200
    And Response body message was "Returns retrieved successfully"

  #GET (-) TRANSACTION
  @Project
  Scenario: Get available returns from investment with invalid path
    Given Get available returns from investment with invalid path "return"
    When Send request get available returns
    Then Status code should be 404
    And Response body message was "Not Found"



