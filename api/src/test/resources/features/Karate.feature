Feature: Sample API Testing

  Background: 
    * url 'https://api.tmsandbox.co.nz'

  Scenario: Get User Details
    Given path '/v1/Categories/6327/Details.json'
    And path catalogue = false
    When method GET
    Then status 200
    #And match response.name == 'John Doe'
    #And match response.email == 'john.doe@example.com'
