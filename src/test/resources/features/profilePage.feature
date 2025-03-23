@profile
Feature: Instagram App Search And Profile Page Test Automation on Android Operating System
  Scenario: Instagram app search and profile page tests
    Given Instagram search page is opened
    Then Instagram search page verified

    When "Instagram" is entered into the search bar
    And Instagram profile page is navigated
    Then Instagram profile is verified

    When Instagram page is followed by clicking the follow button
    And First post is liked and saved