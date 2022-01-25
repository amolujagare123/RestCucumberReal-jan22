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


  @createUserSingle @chat
  Scenario: create a user for chat server
    Given Add user payload is created
    When User calls "CreateUser" request using "POST" method with userId ""
    #When User calls CreateUser request using POST method with <username> , <password>, <name>,<surname>
    Then the API call got success with status code "200"
    Then "error" should be "false";


 @GetUser @chat
  Scenario: Fetch the specific user from chat server
    Given Get user Base is created
    When User calls "GetUser" request using "GET" method with userId "57"
    Then the API call got success with status code "200"
    Then "result.username" should be "amarT1";

  @DeleteUser @chat
  Scenario: delete the specific user from chat server
    Given delete user Base is created
    When User calls "DeleteUser" request using "DELETE" method with userId "57"
    Then the API call got success with status code "200"
    Then "error" should be "false";
    Then "result" should be "true";



