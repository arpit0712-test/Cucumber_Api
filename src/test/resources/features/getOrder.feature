Feature: Validate Get Order feature
  I want to get a Paypal order using this feature



  Scenario Outline: Validate Get Order feature with valid details
    Given I want to get access Token from Paypal api
    When I get Order from the paypal api
    And I verify the status code as "<statusCode>"

    Examples:
      | statusCode |
      | 200        |