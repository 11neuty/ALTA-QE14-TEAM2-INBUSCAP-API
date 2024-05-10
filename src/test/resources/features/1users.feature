Feature: Users
  As user i can use method GET, POST, PUT, AND DELETE for API

  #CREATE ACCOUNT
   #POSITIVE TEST CASE
  @Inbuscap1
  Scenario: As user i can add new user with valid json
    Given Create user by json DataCreateUsers2.json
    When  Send request create users
    Then  Status code should be 201
    And   Response body message should be "Successful user registration"
    And   Validate json schema "ValidatePostCreateUsers.json"

   #LOGIN ACCOUNT
  @Inbuscap1
  Scenario Outline: As user i can login with valid email or phone number
    Given Login user by json <json>
    When Send request login users "<role>"
    Then Status code should be <statusCode>
    And Response body message should be <msg>
    And Validate json schema <json1>
    Examples:
      | json                          | statusCode | msg                  | json1                         | role      |
      | "UserDataLoginRecipient.json" | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | recipient |
      | "UserDataLoginAdmin.json"     | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | admin     |
      | "UserDataLoginInvestor.json"  | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | investor  |
      | "UserDataLoginDelete.json"    | 200        | "Login Successfully" | "ValidatePostLoginUser.json"  | delete    |


  @Inbuscap
  #NEGATIVE TEST CASE
  Scenario: As user i cant add new user with invalid json
    Given Create user by json UserBadData1.json
    When  Send request create users
    Then Status code should be 400

  @Inbuscap
  Scenario: As user i cant login by invalid json
    Given  Login user by json "UserBadDataLogin1.json"
    When   Send request login users "recipient"
    Then   Status code should be 404

#GET ----------------------------------------------------------------------------------------------------------
@Inbuscap
  #POSITIVE TEST CASE
  Scenario: As user i can get user with valid path
    Given Get users with path "users"
    When  Send request get user
    Then  Status code should be 200
    And   Response body message should be "Successfully Get MyProfile"
    And   Validate json schema "ValidateGetUsers.json"

@Inbuscap
  #NEGATIVE TEST CASE
  Scenario: As user i cant get user with invalid path
    Given Get users with path "usersS"
    When  Send request get user
    Then  Status code should be 404
    And   Validate json schema "ValidateGetInvalidUsers.json"

##PUT -----------------------------------------------------------------------------------------------------------
@Inbuscap
  #POSITIVE TEST CASE
  Scenario: Update users with valid multipart form data
    Given Update data with valid multipart form data; full name "Lisa Cantik", email "recipient@gmail.com", phone number "081234567890", password "pass12345", ktp "3325456987588845", npwp "2254759868523332", avatar "selfie.jpg"
    When  Send request update data
    Then  Status code should be 200
    And   Response body message should be "successfully updated user"
    And   Validate json schema "ValidatePutUsers.json"


#NEGATIVE TEST CASE
@Inbuscap
  Scenario: Update user with invalid multipart form data
    Given Update data with valid multipart form data; full name "ryan", email "jugonggmail.com", phone number "085788969887", password "ryan123", ktp "3389785684748889", npwp "3326160801010021", avatar "selfie.jpg"
    When Send request update data
    Then Status code should be 400
    And  Validate json schema "ValidatePutInvalidUsers.json"

#DELETE --------------------------------------------------------------------------------------------------------
@Inbuscaps
  #POSITIVE TEST CASE
  Scenario: Delete user with valid path
    Given Delete user with path "users"
    When  Send request delete users
    And   Response body message should be "Successfully Delete User"
    Then  Status code should be 200

  #NEGATIVE TEST CASE
@Inbuscap
  Scenario: Delete user with invalid path
    Given   Delete user with path "userS"
    When    Send request delete users
    Then    Status code should be 404