Feature: PUT Verification

  @Inbuscap
  Scenario: Verifications users send photo valid multipart form data
    Given   Verification users send multipart data form photo ktp "ktp.jpg" photo npwp "npwp.jpg" photo selfie "photo.jpg"
    When    Send request verification
    Then    Status code should be 201

  @Inbuscap
  Scenario: Verifications users by valid id
    Given   Verification users by id 7 and json request body "json"
    When    Send request verification user by id
    Then    Status code should be 200


  @Inbuscap
  Scenario: Verifications user by proposals id
    Given   Verification users by proposals id
    When    Request verification user by proposals id
    Then    Status code should be 200

  @Inbuscap
  Scenario: Get verification with valid parameter status and page
    Given   Get verification with valid parameter status 1 and page 1
    When    Send request get verification by status and page
    Then    Status code should be 200
    And     Response body message was "User list sucessfully retrieved"
    And     Validate Top up json schema "GetVerificationSchema.json"


  @Inbuscap
  Scenario: Get verification with invalid parameter status and valid page
    Given   Get verification with valid parameter status "satu" and page "1a"
    When    Send request get verification by status and page
    Then    Status code should be 200
    And     Response body message was "the data sent is incorrect"

  @Inbuscap
  Scenario: Get verification proposal with valid proposal id
    Given   Get verification proposal with valid proposal id 41
    When    Send request get verification by proposal id
    Then    Status code should be 200
    And     Response body message was "success get detail post"
    And     Validate Top up json schema "GetVerificationProposalSchema.json"

  @Inbuscap
  Scenario: Get verification proposal with invalid proposal id
    Given   Get verification proposal with invalid proposal id "-1A"
    When    Send request get verification by proposal id
    Then    Status code should be 200
    And     Response body message was "the data sent is incorrect"

  @Inbuscap
  Scenario: Get verification proposal with valid status and page
    Given   Get verification proposal with valid status 1 and page 1
    When    Send request get verification proposal by status and page
    Then    Status code should be 200
    And     Response body message was "data retrieved successfully"
    And     Validate Top up json schema "GetVerifProposalPSSchema.json"

  @Inbuscap
  Scenario: Get verification proposal with invalid status and page
    Given   Get verification proposal with invalid status "1a" and page "1a"
    When    Send request get verification proposal by status and page
    Then    Status code should be 200
    And     Response body message was "the data sent is incorrect"




