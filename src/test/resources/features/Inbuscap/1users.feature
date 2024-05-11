Feature: Users
  As user i can use method GET, POST, PUT, AND DELETE for API

  #CREATE ACCOUNT
   #POSITIVE TEST CASE
  @Inbuscap
  Scenario: As user i can add new user with valid json
    Given Create user by json "DataCreateUsers1.json"
    When  Send request create users
    Then  Status code should be 201
    And   Response body message should be "Registered Successfully"
    And   Validate json schema "ValidatePostCreateUsers.json"

   #LOGIN ACCOUNT
  @Inbuscap1
  Scenario Outline: As user i can login with valid email or phone number
    Given Login user by json "<json>"
    When  Send request login users "<role>"
    Then  Status code should be <statusCode>
    And   Response body message should be <msg>
    And   Validate json schema <json1>
    Examples:
      | json                        | statusCode | msg                  | json1                         | role      |
      | UserDataLoginRecipient.json | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | recipient |
      | UserDataLoginAdmin.json     | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | admin     |
      | UserDataLoginInvestor.json  | 200        | "Login Successfully" | "ValidatePostLoginUsers.json" | investor  |


  @Inbuscap1
  #NEGATIVE TEST CASE
  Scenario: As user i cant add new user with invalid json
    Given Create user by json "UserBadData1.json"
    When  Send request create users
    Then Status code should be 400

  @Inbuscap1
  Scenario: As user i cant login by invalid json
    Given  Login user by json "UserBadDataLogin1.json"
    When   Send request login users "recipient"
    Then   Status code should be 404

    #PUT -----------------------------------------------------------------------------------------------------------
  @Inbuscap1
  #POSITIVE TEST CASE
  Scenario: Update users with valid multipart form data
    Given Update data with valid multipart form data; full name "recipient", email "recipient@gmail.com", phone number "080034567813", password "pass12345", ktp "4495457887588821", npwp "2254759868523321", avatar "selfie.jpg"
    When  Send request update data
    Then  Status code should be 200
    And   Response body message should be "Successfully Updated"
    And   Validate json schema "ValidatePutUsers.json"


#NEGATIVE TEST CASE
  @Inbuscap1
  Scenario: Update user with invalid multipart form data
    Given Update data with valid multipart form data; full name "recipient", email "recipient.com", phone number "089334547855", password "pass12345", ktp "3325456987588821", npwp "2254759868523321", avatar "selfie.jpg"
    When Send request update data
    Then Status code should be 400
    And  Validate json schema "ValidatePutInvalidUsers.json"

#GET ---------------------------------------------------------------------------------------------------------
@Inbuscap1
  #POSITIVE TEST CASE
  Scenario: As user i can get user with valid path
    Given Get users with path "users"
    When  Send request get user
    Then  Status code should be 200
    And   Response body message should be "Successfully Get MyProfile"
    And   Validate json schema "ValidateGetUsers.json"

@Inbuscap1
  #NEGATIVE TEST CASE
  Scenario: As user i cant get user with invalid path
    Given Get users with path "usersS"
    When  Send request get user
    Then  Status code should be 404
    And   Validate json schema "ValidateGetInvalidUsers.json"

#

##DELETE --------------------------------------------------------------------------------------------------------
#@Inbuscaps1
#  #POSITIVE TEST CASE
#  Scenario: Delete user with valid path
#    Given Delete user with path "users"
#    When  Send request delete users
#    And   Response body message should be "Successfully Delete User"
#    Then  Status code should be 200
#
#  #NEGATIVE TEST CASE
#@Inbuscap1
#  Scenario: Delete user with invalid path
#    Given   Delete user with path "userS"
#    When    Send request delete users
#    Then    Status code should be 404