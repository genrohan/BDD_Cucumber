Feature: Login Page of amazon.in


Background: flow till Password page with correct mail id while logging in
Given User is on HomePage
When User clicks on SignIn
And User enters mailid
And User clicks on Continue


Scenario: successful log in with corrct password
When User enters password
And User clicks on Login
Then Login validation is done