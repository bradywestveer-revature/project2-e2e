Feature: Change Password Page
  Background:
    Given ChangePassword: The user is on the change password page

  Scenario: The user has a valid token and enters valid passwords and they are redirected to the login page
    Given ChangePassword: The user has a valid token
    When ChangePassword: The user enters valid passwords
    Then ChangePassword: The user is redirected to the login page

  Scenario: The user has an invalid token and enters a valid password and an error message is shown
    Given ChangePassword: The user has an invalid token
    When ChangePassword: The user enters valid passwords
    Then ChangePassword: An invalid token error message is shown

  Scenario: The user enters an invalid password and an error message is shown
    When ChangePassword: The user enters an invalid password
    Then ChangePassword: An invalid password error message is shown

  Scenario: The user enters non-matching passwords and an error message is shown
    When ChangePassword: The user enters non-matching passwords
    Then ChangePassword: A non-matching password error message is shown

  Scenario: The user clicks the try password reset button and is redirected to the reset password page
    When ChangePassword: The user clicks the try password reset button
    Then ChangePassword: The user is redirected to the reset password page