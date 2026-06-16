Feature: Registration_Module

  @Smoke @Registration
  Scenario Outline: Validate Registration Functionality
    Given user clicks Register option
    When enters necessary credentials "<firstname>" "<lastname>" "<address>" "<city>" "<state>" "<zip>" "<phone>" "<ssn>" "<username>" "<password>" "<confirm_password>"
    And clicks register button
    Then validate registration result

    Examples:
      | firstname | lastname | address         | city     | state | zip   | phone      | ssn         | username  | password    | confirm_password |
      | John      | Doe      | 123 Main Street | New York | NY    | 10001 | 9876543210 | 123-45-6789 | johndoe60 | Password123 | Password123      |
