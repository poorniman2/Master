Feature: alerts check
Scenario: Verify alerts on webpage
Given User is on "https://demoqa.com/alerts" Page
When User clicks on the below alert button
|AlertButton|Message|
|alertButton|You clicked a button|
|timerAlertButton|This alert appeared after 5 seconds|
|confirmButton|You selected Ok|
|promtButton|You entered Test|
Then Validate the message displayed