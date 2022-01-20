Feature: all chat user scenarios.

  @createUser
  Scenario Outline: create a user for chat server
    Given Add user payload is created
    #When User calls CreateUser request using POST method
    When User calls CreateUser request using POST method with <username> , <password>, <name>,<surname>
    Then the API call got success with status code "200"
    Then "error" should be "false";
    Examples:
      | username  | password  | name | surname  |
      | amarT1    | a123      | amol | tulse    |
      | chetanG1  | c123      | name | G        |
      | amolU1    | a123      | name | Ujagare  |



