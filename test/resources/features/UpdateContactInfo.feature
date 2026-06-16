Feature: Contact_Module

  @Smoke @Regression @UpdateContactInfo
  Scenario Outline: Validate Contact Functionality
    Given user enters username and password
    When clicks on login button
    And clicks on Update Contact Info link
    And update contact information "<newAddress>"
    And clicks on update contact information button
    Then validate contact information update result

    Examples:
      | newAddress |
      | 123456789  |
