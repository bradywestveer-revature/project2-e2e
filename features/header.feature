Feature: Header
  Background:
    Given Login: A user is on the login page

  Scenario: A user is on the login page and does not see the user component and logout button
  Then Header: The user component and logout button are not displayed

  Scenario: A user can see their user component and logout button on the main page
    When Login: A user enters correct login credentials
    Then Login: The user is redirected to their main feed
    Then Header: The User Component and Logout Button are visible

  Scenario: A user clicks the logout button and is redirected to the login page
    When Login: A user enters correct login credentials
    Then Login: The user is redirected to their main feed
    When Header: A user clicks the logout button
    Then Header: The user is redirected to the login page