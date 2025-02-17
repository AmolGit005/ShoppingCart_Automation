 @LoginTest
 Feature: Test the Login Functionality

  Scenario Outline: Check the Swag Labs login flow
    Given User launches the swag labs url
    When User insert "<username>" in username field
    And User insert the "<password>" in password field
    And User clicks on the login button
    Then Verify the swag labs products title in home

    Examples:
      | username      |   password   |
      | standard_user | secret_sauce |