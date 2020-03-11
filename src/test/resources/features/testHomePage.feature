@test
Feature: I want to see what this website has

Scenario: I am on the theautomatedtester website
	Given I see 5 hyperlinks on this page
	And  one text editing field
	When I am opened any of these 5 hyperlinks
	Then I should be taken to the disparate page
	When I am on the subsite
	Then I will be redirected back to previous page  

Scenario: Subsite redirects me back to the home page
	Given I notice the text on page is same as the website title
	And one text editing field
	When I am clicked on the texting editing field 
	Then I can input some text

Scenario: Check if hyperlink is active
	Given I see 5 hyperlinks on this page
	When I am opened any of these 5 hyperlinks
	Then I should be taken to disparate page
	But when I am going back the home page
	Then the color of the hyperline should be changed to indicate the link is visited
	
Scenario: Check if text is selectable
	When I select all the visible text on the webesite
	Then the text is selectable

