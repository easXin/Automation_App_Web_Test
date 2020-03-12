@test
Feature: To test functionality of the ch4 page
Scenario: Click on the index will redirect current page to main page 
	Given I am on the home page 
	When I click on chapter4 
	Then I will be redirected to the ch4 page 
	Then I see an index hyperlink on the ch4 page 
	When I click on the index on ch4 page
	Then I should be taken back to the main page

Scenario: Validate if the dropdown menu works 
	Given I am on the home page
	When I click on chapter4
	Then I will be redirected to the ch4 page
	When I see the dropdown menus
	Then I want to click on every item on the menu 
    Then go back to home page

Scenario: Enter some text on the input fields of ch8 page 
	Given I am on the home page
	When I click on chapter4
	Then I will be redirected to the ch4 page
	When I click on the input field
	Then I enter the text on all input fields
	Then go back to home page

Scenario: Click on the chapter 4 on the main page 
	Given I am on the home page 
	When I click on chapter4 
	Then I will be redirected to the ch4 page 
	And on the chapter 4 page, I saw two buttons
	But nothing would happen when I click on these two button
	Then hover over text field at left bottom of the page
	And show a popup when hovering over the text field
	Then go back to home page
