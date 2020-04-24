Feature: Way of failed login on amazon.in

Background: fow till Sign in page
Given User is on Sign in page

Scenario: fail login with correct mail and incorrect password
When User enters correct mail id
And User enters password
Then Verify incorrect password displayed on the page


Scenario: failed login with incorrect mail id or phone number
When User enters incorrect mail id
Then Verify incorrect mail id displayed on the page


Scenario: failed login when user is not registered
When User enters mail id
And User clicks on Continue
Then User lands on SIGN UP page





