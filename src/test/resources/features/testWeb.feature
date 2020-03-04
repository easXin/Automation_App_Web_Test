@test
Feature: Testing facebook registration page

Scenario: open facebook page and press sign up
	Given user opens facebook page
	When user enters data
	Then validates user input
	Then clicks sign up
