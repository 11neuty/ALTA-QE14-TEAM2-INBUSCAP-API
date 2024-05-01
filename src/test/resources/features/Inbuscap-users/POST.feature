Feature: POST Users
  As user i can add new user with valid json and login with valid phone number and email

  @Test
  #POSITIVE TEST CASE
  Scenario: As user i can add new user with valid json
    Given Create user by json UserData1.json
    When  Send request create users
    Then  Status code should be 201
    @Test
  Scenario: As user i can login with valid email or phone number
    Given Login user by json UserData1.json
    When  Send request login users
    Then  Status code should be 200

    @Test
  #NEGATIVE TEST CASE
  Scenario: As user i cant add new user with invalid json
    Given Create user by json UserData2.json
    When  Send request create users
    Then Status code should be 400

    @Test
  Scenario: As user i cant login by invalid json
    Given  Login user by json LoginEmail2.json
    When   Send request login users
    Then   Status code should be 400