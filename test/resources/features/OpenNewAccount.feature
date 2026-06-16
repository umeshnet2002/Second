Feature: Account_Module

  @Smoke @Regression @OpenNewAccount
  Scenario: Validate Account Open Functionality
    Given user enters username and password
    When clicks on login button
    And clicks on Open New Account link
    And selects account type
    And clicks on open new account button
    Then validate account open result
