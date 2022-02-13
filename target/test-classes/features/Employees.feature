@employee
Feature:
  As an existing user, I can login to my account on when I work website.

  Scenario: Login as user
    Given user is on the login page
    When user enters correct email, password and clicks on log in button
    And clicks on specific workplace Test Workplace
    And clicks on add employee button
    And adds new employee
      | firstName | lastName|
      | Kate      | Smith   |
    Then employee Kate Smith is successfully added

