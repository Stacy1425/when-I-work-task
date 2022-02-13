@login
Feature:
 As an existing user, I can login to my account on when I work website.

  Scenario: Login as user
    Given user is on the login page
    When user enters correct email, password and clicks on log in button
    Then user is logged in

    Scenario: Login with incorrect email is unsuccessful
    Given user is on the login page
    When user enters wrong email
    Then  email error appears

  Scenario: Login with incorrect password is unsuccessful
    Given user is on the login page
    When user enters wrong password
    Then error appears