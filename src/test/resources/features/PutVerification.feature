Feature: PUT Verification

  @Test
  Scenario: verifications users send photo
    Given   Serification users send multipart data form photo ktp "ktp.jpg" photo npwp "npwp.jpg" photo selfie "photo.jpg"
    When    Send request verifi