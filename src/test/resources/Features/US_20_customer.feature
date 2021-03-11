@AllCustomer
Feature: Validate all customers' info
  @customerapi
  Scenario: Read all customers
    Given user sets all response using api end point "https://www.gmibank.com/api/tp-customers"
    And user deserializes country data as json to java pojo
    Then user validates the data