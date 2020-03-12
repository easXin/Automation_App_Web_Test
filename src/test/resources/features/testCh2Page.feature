@test 
Feature: To test functionality of the ch2 page 
Scenario: Validate functionality of all six buttons 
	Given I am on the home page 
	When I click on chapter2 
	Then I will be redirected to the ch2 page 
	When I enter ch2 page, I will encounter six buttons 
	Then I click on each one of them 
	But nothing has changed except I clicked all the element once 
	Then close browser 
	
Scenario: Click on the index will redirect current page to main page 
	Given I am on the home page 
	When I click on chapter2 
	Then I will be redirected to the ch2 page 
	Then I see an index hyperlink on the ch2 page 
	When I click on the index 
	Then I should be taken back to the main page