Feature: Login functionally
@data-drivern
Scenario: Login with valid credentials
Given Navigate to Home page
When user enters username and password
Then user logged in successfully

@data-drivern
Scenario: The one where user pics different product through search functionality
When Lalitha searches below products in the search box:
|Head |
|Travel|
|Laptop|
Then product should be added in the cart if available