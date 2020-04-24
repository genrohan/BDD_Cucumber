Feature: User Account page of amazon.in

Scenario Outline: Account Page content when user is not logged in
Given User is on Account page
And User is not logged in
When User clicks on <user options>
Then User lands on Login page

Examples:
	| user options |
	| Your Orders  |
	| Login & Security |
	| Youur Addresses |
	| Payment Options |
	| Amazon Pay |
	

Scenario: My Orders page contents
Given User is on "Home Page" or "My Account Page"
And User is already Login
When User clicks on "My Orders" 
Then User order history is displayed