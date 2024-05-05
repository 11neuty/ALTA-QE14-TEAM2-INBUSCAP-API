Feature: PROPOSALS
  Endpoint POST, GET, PUT, DELETE

  #POST

  #POSITIVE TEST CASE
  @Test
  Scenario: Create new proposals with valid multipart data form
    Given   Create proposals by multipart data form image "cupangImage.jpg", title "Ikan Lele Oji", description "Jualan ikan hebat", capital 100000000, share 10, proposal "CupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 200
    And     Response body message should be "success create post"
    And     Validate json schema proposals "ValidatePostProposals.json"

  Scenario: Create new business report and profit share by valid multipart form data
    Given   Create new report by multipart form data proposal_id 41, date "8 januari", document "cupangReport.pdf", amount 500
    When    Send request create report
    Then    Status code should be 201
    And     Response body message should be "New Report Added Successfully"
    And     Validate json schema proposals "ValidatePostReport.json"

  #NEGATIVE TEST CASE
  @Test
  Scenario: Create new proposals with invalid multipart data form
    Given   Create proposals by multipart data form image "cupangImage.jpg", title "Ikan Cupang Pak Amin", description "Jualan ikan hebat", capital 1000000, share 10, proposal "cupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 400
    And     Validate json schema proposals "ValidateInvalidPostProposal.json"

  Scenario: Create new business report and profit share by invalid multipart form data
    Given   Create new report by multipart form data proposal_id 0, date "8 januari", document "cupangReport.pdf", amount 500
    When    Send request create report
    Then    Status code should be 404
    And     Validate json schema proposals "ValidateInvalidPostReport.json"

    #GET
    #POSITIVE TEST CASE
  @Test
  Scenario: Get proposals with valid param
    Given   Get proposals with parameters page 1
    When    Send request get proposals
    Then    Status code should be 200
    And     Response body message should be "Successfully Get All Proposals"
    And     Validate json schema proposals "ValidateGetProposals.json"

  Scenario: Get my proposals with valid parameter
    Given   Get myproposals with param 1
    When    Send request get myproposals
    Then    Status code should be 200
    And     Response body message should be "Successfully Get All MyProposals"
    And     Validate json schema proposals "ValidateGetMyProposals.json"

  Scenario: Get proposals with valid proposals id
    Given   Get proposals with id 41
    When    Send request get proposals by id
    Then    Status code should be 200
    And     Response body message should be "success get detail post"
    And     Validate json schema proposals "ValidateGetProposalsById.json"



    #NEGATIVE TEST CASE
  @Test
  Scenario: Get proposals with invalid path
    Given     Get proposals with parameters page 0
    When      Send request get proposals
    Then      Status code should be 404


  Scenario: Get my proposals with valid parameter
    Given   Get myproposals with param 2
    When    Send request get myproposals
    Then    Status code should be 404

  Scenario: Get proposals with valid id
    Given   Get proposals with id 1
    When    Send request get proposals by id
    Then    Status code should be 404


    #PUT -----------------------------------------------------------------------------------------------------
  @Test
  #POSITIVE TEST CASE

  Scenario: Edit proposal by valid proposal id and valid multipart data form
    Given Edit proposal by proposal id 1 and multipart form data image "cupangImage.jpg", title "title", description "desc", capital 100, proposal "cupangProposal.pdf"
    When  Send request edit proposal
    Then  Status code should be 201
    And   Response body message should be "Successfully Edit Proposal"
    And   Validate json schema proposals "ValidatePutProposalsById.json"

    #NEGATIVE TEST CASE
  @Test
  Scenario: Edit proposal by invalid proposal id and invalid multipart data form
    Given   Edit proposal by proposal id 1 and multipart form data image "cupangImage.jpg", title "title", description "desc", capital 100, proposal "cupangProposal.pdf"
    When    Send request edit proposal
    Then    Status code should be 404

    #DELETE-----------------------------------------------------------------------------------------------------
  @Test
    #POSITIVE TEST CASE
  Scenario: Delete proposals by valid id
    Given   Delete user by id 5
    When    Send request delete proposals
    And     Response body message should be "Successfully Delete Proposal"
    Then    Status code should be 200


  #NEGATIVE TEST CASE
  @Test
  Scenario: Delete user by invalid id
    Given   Delete user by id -1
    When    Send request delete proposals
    Then    Status code should be 401