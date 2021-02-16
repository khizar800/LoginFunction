Feature: Function of the site

@loginPage
Scenario Outline: Login Page Loaded
Given I open guru99 website
When User enters <email> and <passwd>
Then Successful Login Message Displayed

Examples:  
| email  | passwd  |
| Pavithra24 | pass123 |
| vivekaoutlook654 | Saas321 |