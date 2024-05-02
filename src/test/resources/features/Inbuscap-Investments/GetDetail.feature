Feature: Get Detail Invested Proposal
  @Project
  Scenario: Get detail invested proposal with valid proposal id
    Given Get detail invested proposal with valid proposal id 1
    When Send get detail invested proposal
    Then Status code should be 200

  Scenario Outline: Get detail invested proposal with invalid proposal id
    Given Get detail invested proposal with invalid proposal id <proposal_id>
    When Send get detail invested proposal
    Then Status code should be 400
    Examples:
      | proposal_id |
      | satu        |
      | t!ga        |
