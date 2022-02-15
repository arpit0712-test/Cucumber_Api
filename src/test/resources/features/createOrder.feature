Feature: Validate Create Order feature
  This feature is used to create a feature

  Scenario Outline: Validate Create Order feature with valid details
    Given I want to get access Token from Paypal api
    When I set currency code as "<currencyCode>" and value as "<currencyValue>"
    And I verify the status of CREATED

    Examples:
      | currencyCode | currencyValue |
      | USD          | 500.00        |
      | INR          | 567.67        |
      | CAD          | 456.34        |
      | EUR          | 234.43        |


