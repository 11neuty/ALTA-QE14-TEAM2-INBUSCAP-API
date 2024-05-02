Feature: Post Feature
  Add new proposals by valid multipart data form

  #POSITIVE TEST CASE
  @Test
  Scenario: Create new proposals with valid multipart data form
    Given   Create proposals by multipart data form image "cupangImage.jpg", title "Ikan Cupang Pak Amin", description "Jualan ikan hebat", capital 1000000, share 10, proposal "CupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 201

  Scenario: Create new business report and profit share by valid multipart form data
    Given   Create new report by multipart form data proposal_id 1, date "8 januari", document "cupangReport.pdf", amount 500
    When    Send request create report
    Then    Status code should be 201

  #NEGATIVE TEST CASE
  @Test
  Scenario: Create new proposals with invalid multipart data form
    Given   Create proposals by multipart data form image "cupangImage.jpg", title "Ikan Cupang Pak Amin", description "Jualan ikan hebat", capital 1000000, share 10, proposal "cupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 400

  Scenario: Create new business report and profit share by invalid multipart form data
    Given   Create new report by multipart form data proposal_id 0, date "8 januari", document "cupangReport.pdf", amount 500
    When    Send request create report
    Then    Status code should be 404