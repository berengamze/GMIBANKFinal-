@AllCustomerState
Feature: Validate all customers' state
  @customerstateapi
  Scenario: Read all customers
    Given user sets all response using api end point "https://www.gmibank.com/api/tp-customers"
    And user deserializes customer data as json to java pojo
    Then user validates states