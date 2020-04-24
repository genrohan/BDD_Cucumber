Feature: Prouct detail page of amazon.in

Background: flow till project lister page
Given User is on Home page
When User search for "mens running shoes"
Then User is on Product lister page of "\"mens running shoes\""


Scenario: User selecting brand of the product
When User select brand of the product as "Nivia"
Then User can see "Nivia" product


Scenario: User selecting a product and landing on product detail page
When User clicks on a product
Then User lands on the detail page of the selected product


Scenario: User trying to product to cart
Given User is on the product detail page
When User select size as "10"
And User add product to the cart
Then Number of product in the cart increases by one