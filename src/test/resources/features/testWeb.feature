@test
Feature: Testing facebook registration page

Scenario: open facebook page and press sign up
	Given user opens facebook page
	When user inputs data
	And clicks sign up button
	When user inputs confirmation code
	Then then new account is created