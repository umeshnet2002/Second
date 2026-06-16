Feature: Bill_Module

  @Regression @BillPay
  Scenario Outline: Validate Bill Functionality
    Given user enters username and password
    When clicks on login button
    And clicks on Bill Pay link
    And enter bill pay details "<name>" "<address>" "<city>" "<state>" "<zipCode>" "<phoneNumber>" "<accountNumber>" "<verifyAccountNumber>" "<amount>"
    And clicks on send payment button
    Then validate bill pay information update result

    Examples:
      | name     | address         | city     | state | zipCode | phoneNumber  | accountNumber | verifyAccountNumber | amount |
      | John Doe | 123 Main Street | New York | NY    | 10001   | 123-456-7890 | 123456789     | 123456789           | 100    |
