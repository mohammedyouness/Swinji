Feature: Testing Bored API

  Scenario : Verify Bored API Status Code
    Given GET Bored API
    When I request a random activity from the Bored API
    Then The response status code should be 200
#    Then The response should contain property "<property>"
#    Examples:
#      | property      |
#      | activity      |
#      | type          |
#      | participants  |
#      | price         |
#      | link          |
#      | key           |
#      | accessibility |