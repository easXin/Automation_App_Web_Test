@test
Feature: To test functionality of the ch1 page
Scenario: Validate functionality of hyperlinks that is right above the input field
		Given I am on the home page
		When I click on chapter1
		Then I will be redirected to the ch1 page
		When I click on first two links
		Then the page would pop out a new windows
		When I clike on the third link
		Then a paragraph would displays on the page
		Then close browser
Scenario: Validate the functionality of hyperlink on this ch1 page
	Given I am on the home page
	When I click on chapter1
	Then I will be redirected to the ch1 page
	When I click on the home page hyperlink
	Then I should be taken back to the main page
	
Scenario: Validate if the radio button and checkbox behave as expected
	Given I am on the home page
	When I click on chapter1
	Then I will be redirected to the ch1 page
	When I click on the radio button
	Then radio button is selected
	And radio button can not be unselected
	When I click on the checkbox
	Then It is checked
	And It can be either checked or unchecked  

Scenario: Validate if the dropdown menu works 
	Given I am on the home page
	When I click on chapter1
	Then I will be redirected to the ch1 page
	When I see the dropdown menu
	Then I want to click on every item on the menu 
    And go back to main page

Scenario: Validate the functionality of buttons,textbox,input field on this page
	Given I am on the home page
	When I click on chapter1
	Then I will be redirected to the ch1 page
	And I see two buttons, one textbox, one input field on this page
	When I click load text button
	Then new content will be added into textbox
	When I click on verify button
	Then nothing would happen
	When I click on the textbox or input field
	Then I can editting both texting filed 
	Then go back to main page