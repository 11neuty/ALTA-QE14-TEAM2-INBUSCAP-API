Feature: PUT Users
  As user i can update data user with valid multiple from data

  @Test
  #POSITIVE TEST CASE
  Scenario: Update users with valid multipart form data
  Given Update data with valid multipart form data; full name "Bidadari Sunset", email "merdeka@gmail.com", phone number "085788969887", password "pass12345", ktp "3389785684748889", npwp "3326160801010021", avatar "selfie.jpg"
  When  Send request update data
  Then  Status code should be 200

#NEGATIVE TEST CASE
  Scenario: Update user with invalid multipart form data
    Given Update data with valid multipart form data; full name "bambang sunset", email "merdeka@gmail.com", phone number "085788969887", password "pass12345", ktp "3389785684748889", npwp "3326160801010021", avatar "selfie.jpg"
    When Send request update data
    Then Status code should be 400