Feature: Transaction_Module

  @Smoke @Regression @FindTransactions
  Scenario Outline: Validate Transaction Functionality
    Given user enters username and password
    When clicks on login button
    And clicks on Find Transactions link
    And enter transaction details "<fromDate>" "<toDate>"
    And clicks on find transaction button
    Then validate transaction search result

    Examples:
      | fromDate   | toDate     |
      | 01-01-2025 | 12-09-2026 |
