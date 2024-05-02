Feature: Investment

  #GET ALL +
  @Inbuscap
  Scenario: Get all investment proposal with valid parameter page
    Given Get all investment proposal with valid parameter page 1
    When Send get investment
    Then Status code should be 200

 #GET ALL -
  @Inbuscap
  Scenario Outline: Get all investment proposal with invalid parameter page
    Given Get all investment proposal with invalid parameter page <page>
    When Send get investment
    Then Status code should be 400
    Examples:
      | page |
      | satu |
      | s@tu |

  #GET DETAIL +
  @Inbuscap
  Scenario: Get detail invested proposal with valid proposal id
    Given Get detail invested proposal with valid proposal id 1
    When Send get detail invested proposal
    Then Status code should be 200

  #GET DETAIL -
  @Inbuscap
  Scenario Outline: Get detail invested proposal with invalid proposal id
    Given Get detail invested proposal with invalid proposal id <proposal_id>
    When Send get detail invested proposal
    Then Status code should be 400
    Examples:
      | proposal_id |
      | satu        |
      | t!ga        |

  #POST +
  @Inbuscap
  Scenario: Add new investment with valid data json
    Given Add new investment with valid data json "AddValidInvestment.json"
    When Send request add new investment
    Then Status code should be 201

  #POST -
  @Inbuscap
  Scenario Outline: Add new investment with invalid proposal id
    Given Add new investment with invalid proposal id "<json>"
    When Send request add new investment
    Then Status code should be 400
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
    Examples:
      | json           |
      |AddInvalid4.json|
      |AddInvalid5.json|

  @Inbuscap
  Scenario Outline: Add new investment with invalid proposal id and amount
    Given Add new investment with invalid proposal id and amount "<json>"
    When Send request add new investment
    Then Status code should be 400
    Examples:
      | json           |
      |AddInvalid6.json|
      |AddInvalid7.json|

 #DELETE +
  @Inbuscap
  Scenario: Delete data investment with valid proposal id
    Given Delete data investment with valid proposal id 23
    When Send delete investment
    Then Status code should be 200

  #DELETE -
  @Inbuscap
  Scenario: Delete data investment with invalid proposal id
    Given Delete data investment with invalid proposal id "s@tu"
    When Send delete investment
    Then Status code should be 400