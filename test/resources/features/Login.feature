Feature: Login_Module

  @Smoke @Regression @Login
  Scenario: Validate Login Functionality
    Given user enters username and password
    When clicks on login button
    Then validate login result
