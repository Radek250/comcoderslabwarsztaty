Feature: Book a date
  Scenario Outline: Register New User
    Given I open site http://codersguru.pl
    When I click on register a user
    And I fill registration private form "<email>" "<name>" "<lastname>" "<pass>" "<city>" "<postcode>" "<street>" "<house>"
    And I write "GIT" technology and I go to choose mentor
    And I choose the mentor and I go to reservation window
    And I book a date and go to payment window
    And I choose visaCard payment
    And I fill payment form by "10/2022" "Jan Kowalski"
    Then payment should be rejected
    Examples:
      |email            |name     |lastname |pass     |city   |postcode|street     |house|
      |test@test.pl     |Piotr    |Nowak    |testtest |Wroclaw|50-001  |Trzebnicka |20   |
