Feature: PUT Feature
  As user i can edit proposal by id proposal

  @Test
  #POSITIVE TEST CASE

  Scenario: Edit proposal by valid proposal id and valid mulitpart data form
    Given Edit proposal by proposal id 5 and multipart form data image "image.jpg", title "title", description "desc", capital 100, proposal "proposal.pdf"
    When  Send request edit proposal
    Then  Status code should be 201
