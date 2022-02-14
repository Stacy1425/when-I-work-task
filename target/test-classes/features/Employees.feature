@employee
Feature:
  As an existing user, I can create a new employee to my workplace.

  Scenario: Login as user
    Given user is on the login page
    When user enters correct email, password and clicks on log in button
    And clicks on specific workplace Test Workplace
    And goes to settings menu
    And adds new employee
      | firstName | lastName|
      | Kate      | Smith   |
    Then employee Kate Smith is successfully added

