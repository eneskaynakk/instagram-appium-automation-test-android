@post
Feature: Instagram App Post Actions Test Automation on Android Operating System
  Scenario: Instagram app post actions tests
    Given Instagram application homepage opens
    When Post is liked

    And Go to post comment
    Then Comment pop-up verified
    When Write "Hello Everyone" in the comment box and close the pop-up

    When Click the send button to get the link to the post
    Then The post link popup is verified
    When Post link copied and popup closed
    And Click on anyone's story button on the home page