Feature: PUT Verification

  @Test
  Scenario: Verifications users send photo valid multipart form data
    Given   Verification users send multipart data form photo ktp "ktp.jpg" photo npwp "npwp.jpg" photo selfie "photo.jpg"
    When    Send request verification
    Then    Status code should be 201

  @Test
  Scenario: Verifications users by valid id
    Given   Verification users by id 7 and json request body "json"
    When    Send request verification user by id
    Then    Status code should be 200

  @Test
  Scenario: Verifications user by proposals id
    Given   Verification users by proposals id
    When    Request verification user by proposals id
    Then    Status code should be 200
