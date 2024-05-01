Feature: PUT Users
  As user i can update data user with valid multiple from data

  @Test
  #POSITIVE TEST CASE
  Scenario: Update users with valid multipart form data
  Given Update data with valid multipart form data; phone number "085744568992", password "ryan123", ktp "3326160801010001", npwp "3325123635352225", avatar "selfie.jpg"
  When  Send request update data
  Then  Status code should be 200

#NEGATIVE TEST CASE
  Scenario: Update user with invalid multipart form data
    Given Update data with valid multipart form data; phone number "", password "ryan123", ktp "qwertyuipop", npwp "qwertyuio", avatar "selfie.jpg"
    When Send request update data
    Then Status code should be 400