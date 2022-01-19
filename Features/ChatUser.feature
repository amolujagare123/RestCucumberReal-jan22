Feature: all chat user scenarios.

  @createUser
  Scenario: create a user for chat server
    Given Add user payload is created
    When User calls CreateUser request using POST method
    Then the API call got success with status code "200"
    Then "error" should be "false";

