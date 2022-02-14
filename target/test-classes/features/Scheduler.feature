@scheduler
Feature:
  As an existing user, I can create an OpenShift with and without publishing it and assign it to an existing employee.

  Scenario: Login as user
    Given user is on the login page
    When user enters correct email, password and clicks on log in button
    And clicks on specific workplace Test Workplace
    And navigate to Scheduler
    And adds new OpenShift for _09pm
    Then openShift is successfully created for 9p 11p
    And openShift is not published
    And delete created shift for OpenShift at 9p and 11p and assigned is false

  Scenario: Login as user
    Given user is on the login page
    When user enters correct email, password and clicks on log in button
    And clicks on specific workplace Test Workplace
    And navigate to Scheduler
    And adds new OpenShift for _08pm
    And openShift is successfully created for 8p 11p
    And edit openShift and publish it for 8p and 11p Kate Smith
    Then openShift is published for Kate Smith at 8p
    And delete created shift for Kate Smith at 8p and 11p and assigned is true