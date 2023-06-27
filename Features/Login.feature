Feature: Login

Scenario: Successfully login with valid credentials 
	Given user lauch chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And user enters Email as "admin@yourstore.com" and Password as "admin"
	And click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User Click on logout link
	And  close browser
	
Scenario Outline: Login Data Driven
	Given user lauch chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And user enters Email as "<email>" and Password as "<password>"
	And click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User Click on logout link
	And  close browser
	
	Examples:
		| email | password |
		| admin@yourstore.com | admin |
		| admin@yourstore.com | admin123 |
	