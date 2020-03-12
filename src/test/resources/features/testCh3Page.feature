@test
Feature: To test functionality of the ch3 page
Scenario: Click on the index will redirect current page to main page 
	Given I am on the home page 
	When I click on chapter3 
	Then I will be redirected to the ch3 page 
	Then I see an index hyperlink on the ch3 page 
	When I click on the index on ch3 page
	Then I should be taken back to the main page
