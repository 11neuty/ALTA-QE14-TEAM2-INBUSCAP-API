Feature: PROPOSALS
  Endpoint POST, GET, PUT, DELETE

  #POST

  #POSITIVE TEST CASE
  @Inbuscap
  Scenario: Create new proposals with valid multipart data form
    Given   Create proposals by multipart data form image "cupangImage.jpg", title "Jual Laptoppop", description "Lenovo, Samsung, Logitech", capital 100000000, share 10, proposal "CupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 200
    And     Response body message should be "success create post"
    And     Validate json schema proposals "ValidatePostProposals.json"
  @Inbuscap
  Scenario: Create new business report and profit share by valid multipart form data
    Given   Create new report by multipart form data proposal_id 88, date "8 januari", document "cupangReport.pdf", amount 100000000
    When    Send request create report
    Then    Status code should be 201
    And     Response body message should be "New Report Added Successfully"
    And     Validate json schema proposals "ValidatePostReport.json"

  #NEGATIVE TEST CASE
  @Inbuscap
  Scenario: Create new proposals with invalid multipart data form
    Given   Create proposals by invalid multipart data form image "cupangImage.jpg", title 666, description "12221", capital 1000000, share 10, proposal "cupangProposal.pdf"
    When    Send request create proposal
    Then    Status code should be 400
    And     Validate json schema proposals "ValidateInvalidPostProposal.json"
  @Inbuscap
  Scenario: Create new business report and profit share by invalid multipart form data
    Given   Create new report by multipart form data proposal_id 88, date "8 januari", document "cupangReport.pdf", amount 500
    When    Send request create report
    Then    Status code should be 404
    And     Validate json schema proposals "ValidateInvalidPostReport.json"

    #GET
    #POSITIVE TEST CASE
  @Inbuscap
  Scenario: Get proposals with valid param
    Given   Get proposals with parameters page 1
    When    Send request get proposals
    Then    Status code should be 200
    And     Response body message should be "Successfully Get All Proposals"
    And     Validate json schema proposals "ValidateGetProposals.json"
  @Inbuscap
  Scenario: Get my proposals with valid parameter
    Given   Get myproposals with param 1
    When    Send request get myproposals
    Then    Status code should be 200
    And     Response body message should be "Successfully Get All MyProposals"
    And     Validate json schema proposals "ValidateGetMyProposals.json"
  @Inbuscap
  Scenario: Get proposals with valid proposals id
    Given   Get proposals with id 88
    When    Send request get proposals by id
    Then    Status code should be 200
    And     Response body message should be "success get detail post"
    And     Validate json schema proposals "ValidateGetProposalsById.json"



    #NEGATIVE TEST CASE
  @Inbuscap
  Scenario: Get proposals with invalid path
    Given     Get proposals with invalid parameters page "sa"
    When      Send request get proposals
    Then      Status code should be 400

  @Inbuscap
  Scenario: Get my proposals with invalid parameter
    Given   Get myproposals with invalid param "as"
    When    Send request get myproposals
    Then    Status code should be 400
  @Inbuscap
  Scenario: Get proposals with invalid id
    Given   Get proposals with id 00
    When    Send request get proposals by id
    Then    Status code should be 404


    #PUT -----------------------------------------------------------------------------------------------------

  #POSITIVE TEST CASE
  @Inbuscap
  Scenario: Edit proposal by valid proposal id and valid multipart data form
    Given Edit proposal by proposal id 88 and multipart form data image "cupangImage.jpg", title "Jualan Es Teh", description "jualan murah meriah", capital 100000000, share 10, proposal "CupangProposal.pdf"
    When  Send request edit proposal
    Then  Status code should be 200
    And   Response body message should be "success update post"
    And   Validate json schema proposals "ValidatePutProposalsById.json"

    #NEGATIVE TEST CASE
  @Inbuscap
  Scenario: Edit proposal by invalid proposal id and invalid multipart data form
    Given   Edit proposal by invalid proposal id 1 and multipart form data image "cupangImage.jpg", title 5, description "desc", capital 100, proposal "cupangProposal.pdf"
    When    Send request edit proposal
    Then    Status code should be 400

    #DELETE-----------------------------------------------------------------------------------------------------
#  @Inbuscap
#    #POSITIVE TEST CASE
#  Scenario: Delete proposals by valid id
#    Given   Delete user by id 91
#    When    Send request delete proposals
#    And     Response body message should be "Successfully Delete Proposal"
#    Then    Status code should be 200
#
#
#  #NEGATIVE TEST CASE
#  @Inbuscap
#  Scenario: Delete user by invalid id
#    Given   Delete user by id -1
#    When    Send request delete proposals
#    Then    Status code should be 401