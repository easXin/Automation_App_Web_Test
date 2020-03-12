@test
Feature:  To test functionality of the ch8 page
Scenario: Click on the chapter 8 on the web 
	Given I am on the home page 
	When I click on chapter8 
	Then I will be redirected to the ch8 page 
	And on the chapter 8 page, I saw a button
	But nothing would happen when I click on that button
