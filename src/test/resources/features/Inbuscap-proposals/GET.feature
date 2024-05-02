Feature: GET Proposals
  As user i can get proposals by path

  #POSITIVE TEST CASE
  @Test
  Scenario: Get proposals with valid path
    Given   Get proposals with path "proposals"
    When    Send request get proposals
    Then    Status code should be 200

  Scenario: Get my proposals with valid parameter
    Given   Get myproposals with param "page=1"
    When    Send request get myproposals
    Then    Status code should be 200

  Scenario: Get proposals with valid id
    Given   Get proposals with id 1
    When    Send request get proposals by id
    Then    Status code should be 200



    #NEGATIVE TEST CASE
    @Test
  Scenario: Get proposals with invalid path
  Given     Get proposals with path "proposals"
  When      Send request get proposals
  Then      Status code should be 404


  Scenario: Get my proposals with valid parameter
    Given   Get myproposals with param "page=12?"
    When    Send request get myproposals
    Then    Status code should be 404

  Scenario: Get proposals with valid id
    Given   Get proposals with id 1
    When    Send request get proposals by id
    Then    Status code should be 404