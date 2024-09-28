Feature: Example

  Scenario: Open Swag Labs website
    When I navigate to Swag Labs website
    Then I verify the page title contains "Swag Labs"

  Scenario: Simple login
    Given I am at Swag Labs login page
    When I log in using "USER_1" account
    Then I am at the inventory page

  Scenario: Login with empty email
    Given I am at Swag Labs login page
    When I log in with empty email
    Then I get error login "Username is required"

  Scenario: Login with empty password
    Given I am at Swag Labs login page
    When I log in with empty password
    Then I get error login "Password is required"
