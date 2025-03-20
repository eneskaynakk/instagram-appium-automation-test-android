Feature: Instagram App Login Test Automation on Android Operating System
  Scenario: Instagram app login tests
    Given Instagram login page opens
    When Login with only email
    Then Verification of error message stating password is required

    When Login with only password
    Then Verification of error message stating that email is required

    When Login with both incorrect username and password
    Then Verification of error message stating that email and password are required

    When Login with correct email and password
    Then Verification of successful login