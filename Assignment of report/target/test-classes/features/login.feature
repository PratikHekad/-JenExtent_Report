Feature: Login Test with Excel Data

Scenario: Login with multiple credentials from Excel
  Given user opens the browser
  When user navigates to "https://demoqa.com/login"
  And user logs in using Excel data
  Then verify login result