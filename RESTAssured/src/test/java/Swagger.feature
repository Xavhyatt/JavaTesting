Feature: Testing Swagger

Scenario Outline: Testing the post method
	Given that you are on the Swagger Page
	When the details "<city>" city, "<description>" description, "<name>" name, "<rating>" rating are entered
	And the details are submitted
	Then the details should be retrievable

Examples:
	|city	|description	|name	|rating|
	|Birmingham	|test	|Rob	|7,5,6,6	|
	|Warwick	|test1	|Matt	|5,6,7,6	|
	|Cardiff	|test2	|Scott	|8,9,8,7	|