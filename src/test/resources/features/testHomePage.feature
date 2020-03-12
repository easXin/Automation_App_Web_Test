@test 
Feature: To test functionality of the main site 
Scenario: Check hyperlink is validated 
	Given I see five hyperlinks on the site 
	When I click on any one of them 
	Then I should be on that hyperlink page 
	
Scenario: Validate the state of hyperline after visited 
	Given I see five hyperlinks on the site 
	When I visited all the links on the site 
	Then I shold be taken back to the main site 
	And the color of visited hyperlink should be changed 
	
Scenario: Validate the title of the website 
	Given I see five hyperlinks on the site 
	When I visited all the links on the site 
	Then I shold be taken back to the main site 
	Then the website name should never changed 
Scenario: All the visible text is selectable on the site 
	When I select all the visible text on the webesite 
	Then the text is selectable 
Scenario: Input text on the text editing field 
	Given there is a text editing field on the page 
	When I click on it 
	Then I can input some text 
	
	
