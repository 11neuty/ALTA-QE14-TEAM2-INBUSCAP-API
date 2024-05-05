Feature: Investment

  #POST +
  @Inbuscap
  Scenario: Add new investment with valid data json
    Given Add new investment with valid data json "AddValidInvestment.json"
    When Send request add new investment
    Then Status code should be 200
    And Response body message was "Successfully Sent Capital"
    And Validate json schema "SendCapitalJsonSchema.json"

  #POST -
  @Inbuscap
  Scenario Outline: Add new investment with invalid proposal id
    Given Add new investment with invalid proposal id "<json>"
    When Send request add new investment
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"
    Examples:
      | json           |
      |AddInvalid1.json|
      |AddInvalid2.json|
      |AddInvalid3.json|

  @Inbuscap
  Scenario Outline: Add new investment with invalid amount
    Given Add new investment with invalid amount "<json>"
    When Send request add new investment
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"
    Examples:
      | json           |
      |AddInvalid4.json|
      |AddInvalid5.json|

  @Inbuscap
  Scenario Outline: Add new investment with invalid proposal id and amount
    Given Add new investment with invalid proposal id and amount "<json>"
    When Send request add new investment
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"
    Examples:
      | json           |
      |AddInvalid6.json|
      |AddInvalid7.json|

    #GET ALL +
  @Inbuscap
  Scenario: Get all investment proposal with valid parameter page
    Given Get all investment proposal with valid parameter page 1
    When Send get investment
    Then Status code should be 200
    And Response body message was "Success Get All Investments"
    And Validate json schema "GetAllInvestmentJsonSchema.json"


 #GET ALL -
  @Inbuscap
  Scenario: Get all investment proposal with invalid parameter page
    Given Get all investment proposal with invalid parameter page "s@tu"
    When Send get investment
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"


  #GET DETAIL +
  @Inbuscap
  Scenario: Get detail invested proposal with valid proposal id
    Given Get detail invested proposal with valid proposal id 41
    When Send get detail invested proposal
    Then Status code should be 200
    And Response body message was "Successfully Get Detail Investment Proposal"
    And Validate json schema "GetDetailInvestedJsonSchema.json"


  #GET DETAIL -
  @Inbuscap
  Scenario: Get detail invested proposal with invalid proposal id
    Given Get detail invested proposal with invalid proposal id "empat puluh satu"
    When Send get detail invested proposal
    Then Status code should be 400
    And Response body message was "the data sent is incorrect"


 #DELETE +
  @Inbuscap
  Scenario: Delete data investment with valid proposal id
    Given Delete data investment with valid proposal id 40
    When Send delete investment
    Then Status code should be 200

  #DELETE -
  @Inbuscap
  Scenario: Delete data investment with invalid proposal id
    Given Delete data investment with invalid proposal id "s@tu"
    When Send delete investment
    Then Status code should be 400