Feature: Post Feature
  Add new proposals by valid multipart data form

  #POSITIVE TEST CASE
  @Test
  Scenario: Create new proposals with valid multipart data form
    Given   Create proposals by multipart data form image "cupang.jpg", title "Ikan Cupang Pak Amin", description "Jualan ikan hebat", capital 1000000, share 10, proposal "cupang.pdf"
    When    Send request create proposal
    Then    Status code should be 201



  #NEGATIVE TEST CASE
  @Test
  Scenario: Create new proposals with invalid multipart data form
    Given   Create proposals by multipart data form image "cupang.jpg", title "Ikan Cupang Pak Amin", description "Jualan ikan hebat", capital 1000000, share 10, proposal "cupang.pdf"
    When    Send request create proposal
    Then    Status code should be 400