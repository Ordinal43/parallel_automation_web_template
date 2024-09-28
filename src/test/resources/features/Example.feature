Feature: Example

  Scenario: Simple login
    When I navigate to "https://github.com/"
    Then I verify the page title contains "GitHub"
