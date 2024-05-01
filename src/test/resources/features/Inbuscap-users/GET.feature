Feature: GET Users
  As user i can get my profile using token

  @Test
  #POSITIVE TEST CASE
  Scenario: As user i can get user with valid path
    Given Get users with path "users"
    When  Send request get user
    Then  Status code should be 200


  #NEGATIVE TEST CASE
  Scenario: As user i cant get user with invalid path
    Given Get users with path "usersS"
    When  Send request get user
    Then  Status code should be 404
