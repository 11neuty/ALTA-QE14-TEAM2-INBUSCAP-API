Feature: DELETE Proposals
  As user i can delete proposals by id

  @Test
  #POSITIVE TEST CASE

  Scenario: Delete user by valid id
    Given   Delete user by id 5
    When    Send request delete proposals
    Then    Status code should be 200


  #NEGATIVE TEST CASE
  Scenario: Delete user by invalid id
    Given   Delete user by id -1
    When    Send request delete proposals
    Then    Status code should be 401