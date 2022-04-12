@sanity
Feature: browser window check
Scenario: Verify page header
Given user is on "https://demoqa.com/browser-windows"
Then Page header should be "Browser Windows"

Scenario: Verify different window click options
Given user is on "https://demoqa.com/browser-windows"
When User clicks on the below broser window buttons 
|windowType|Message|
|New Tab|This is a sample page|
|New Window|This is a sample page|