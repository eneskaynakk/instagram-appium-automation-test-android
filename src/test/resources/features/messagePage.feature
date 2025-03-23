@message
Feature: Instagram App Message Page Test Automation on Android Operating System
  Scenario: Instagram app message page tests
    Given Instagram message page opens
    Then Message page is verified

    When Click on the Note button and then add the music "Uzerime Kalir" and the "Perfect Music" note
    Then Adding notes has been verified

    When Go to the message box and send a message "Hello, how are you"
    Then Verify sent message