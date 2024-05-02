Feature: PUT Feature
  As user i can edit proposal by id proposal

  @Test
  #POSITIVE TEST CASE

  Scenario: Edit proposal by valid proposal id and valid multipart data form
    Given Edit proposal by proposal id 1 and multipart form data image "cupangImage.jpg", title "title", description "desc", capital 100, proposal "cupangProposal.pdf"
    When  Send request edit proposal
    Then  Status code should be 201

    #NEGATIVE TEST CASE
  @Test
  Scenario: Edit proposal by invalid proposal id and invalid multipart data form
    Given   Edit proposal by proposal id 1 and multipart form data image "cupangImage.jpg", title "title", description "desc", capital 100, proposal "cupangProposal.pdf"
    When    Send request edit proposal
    Then    Status code should be 404