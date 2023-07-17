Feature: API Automaton using Rest Assured Library in Cucumber Framework

  Scenario Outline: Validate if API response meet the Acceptance Criteria 
    Given the Base URL is "<url>"
    When the parameter is "<paramKey>" = "<paramValue>"
    And the user sends GET request to "<resource>"
    Then the status code is <statusCode>
    And the Name is "<name>"
    And the CanRelist is "<canRelist>"
    And the Promotions element with Name "<promotionName>" has a Description that contains "<description>"

    Examples: 
      | url                          | paramKey  | paramValue | resource                        | statusCode | name           | canRelist | promotionName | description               |
      | https://api.tmsandbox.co.nz/ | catalogue | false      | v1/Categories/6327/Details.json |        200 | Carbon credits | true      | Gallery       | Good position in category |
