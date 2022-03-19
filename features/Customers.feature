Feature: Customers
Scenario: Add a new Customer
  Given User Launch Chrome browser
	When User Opens URL "http://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then User can view Dashboard
  When User click on customers Menu
  And Click on customers Menu Item
  And Click on Add new button
  Then User can view Add new customer page
  When User enter customer info
  And Click on Save button
  Then User can view confirmation message "The new customer has been added successfully."
  And close browser

