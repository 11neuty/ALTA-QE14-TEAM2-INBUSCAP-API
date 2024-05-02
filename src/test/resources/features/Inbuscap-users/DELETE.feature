Feature: DELETE Users
  As user i can delete my account

  @Test
  #POSITIVE TEST CASE
  Scenario: Delete user with valid path
    Given Delete user with path "users"
    When  Send request delete users
    Then  Status code should be 200

  #NEGATIVE TEST CASE
  Scenario: Delete user with invalid path
    Given   Delete user with path "userS"
    When    Send request delete users
    Then    Status code should be 404