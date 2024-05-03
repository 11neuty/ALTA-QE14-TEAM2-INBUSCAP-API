Feature: Users
  As user i can use method GET, POST, PUT, AND DELETE for API

  #CREATE ACCOUNT
   #POSITIVE TEST CASE
  @Test
  Scenario: As user i can add new user with valid json
    Given Create user by json DataCreateUsers1.json
    When  Send request create users
    Then  Status code should be 201
   #LOGIN ACCOUNT
  @Test
  Scenario: As user i can login with valid email or phone number
    Given Login user by json UserDataLogin3.json
    When  Send request login users
    Then  Status code should be 200


  @Test
  #NEGATIVE TEST CASE
  Scenario: As user i cant add new user with invalid json
    Given Create user by json UserBadData1.json
    When  Send request create users
    Then Status code should be 400

  @Test
  Scenario: As user i cant login by invalid json
    Given  Login user by json UserBadDataLogin1.json
    When   Send request login users
    Then   Status code should be 404

#GET ----------------------------------------------------------------------------------------------------------
  @Test
  #POSITIVE TEST CASE
  Scenario: As user i can get user with valid path
    Given Get users with path "users"
    When  Send request get user
    Then  Status code should be 200
    And   Response body name should be "Nicka" and email should be "neuty@gmail.com"
    And   Validate json schema "ValidateGetUsers.json"


  #NEGATIVE TEST CASE
  Scenario: As user i cant get user with invalid path
    Given Get users with path "usersS"
    When  Send request get user
    Then  Status code should be 404

#PUT -----------------------------------------------------------------------------------------------------------
  @Test
  #POSITIVE TEST CASE
  Scenario: Update users with valid multipart form data
    Given Update data with valid multipart form data; full name "ryan", email "neuty@gmail.com", phone number "085799394557", password "pass12345", ktp "3389785684748889", npwp "3326160801010021", avatar "selfie.jpg"
    When  Send request update data
    Then  Status code should be 200

#NEGATIVE TEST CASE
  Scenario: Update user with invalid multipart form data
    Given Update data with valid multipart form data; full name "ryan", email "jahbs@gmail.com", phone number "085788969887", password "ryan123", ktp "3389785684748889", npwp "3326160801010021", avatar "selfie.jpg"
    When Send request update data
    Then Status code should be 400

#DELETE --------------------------------------------------------------------------------------------------------
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