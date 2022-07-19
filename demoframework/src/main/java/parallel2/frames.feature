@Regression
Feature: Frames check
Scenario: Verify frames present on webpage
Given User is on "https://demoqa.com/frames" frames Page
When User clicks on the below frame button
|Frameid|Message|
|frame1|This is a sample page|
|frame2|This is a sample page|
Then Validate the message displayed for frames