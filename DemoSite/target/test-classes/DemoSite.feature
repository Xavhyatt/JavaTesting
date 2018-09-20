Feature: Using the Demo Site
  As a person
  I want to create an account and log in
  So that I can use the website
  
  Scenario: Create account
  	Given I want to log in
  	When I Enter correct credentials
  	Then a successful message should appear
  
