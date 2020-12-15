#Author
#Date
#Description

Feature: feature to test Salefish login functionality
	
  Scenario: check login is successful with valid credentials
    Given user is on login page
    When user enters valid "AshishYe!kar3" and valid "3!NwGKk7c"
    And clicks on login button
    Then user is navigated to home page


    