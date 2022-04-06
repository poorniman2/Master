@smoke
Feature: Buttom click check
Scenario: Verify buttons present on the webpage
Given User is on "https://demoqa.com/buttons"
When User enters following details with columns
    |ButtonType|Message|
    | Double Click Me | You have done a double click|
    | Right Click Me  | You have done a right click |
    |Click Me         |You have done a dynamic click|
    
Then validate the message displayed