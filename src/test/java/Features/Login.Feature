Feature: LoginFeature
  This feature deals with the login functionality of the application facebook
Scenario: Test Login Functionality
  Given I open Chrome and start application
  When I enter valid username and valid password
  And I click the login button
  Then I should be able to login successfully
