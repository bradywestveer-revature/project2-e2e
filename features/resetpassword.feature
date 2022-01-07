Feature: Reset Password Page
  Background:
    Given A user is on the reset password page
  Scenario: A user enter a valid email address and a success message is displayed
    When A user enters a valid email address
    Then A success message is displayed
  Scenario: A user enter an invalid email address and an error message is displayed
    When A user enters an invalid email address
    Then An error message is displayed
  Scenario: A user clicks the "Retry Login" button and is redirected to the login page
    When The user is clicks the retry login button
    Then The user is redirected to the login page
