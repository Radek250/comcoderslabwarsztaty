Feature: Register new user
  Scenario Outline: Register Company User
    Given I open site codersguru.pl
    When I click on register a new user
    And I ckick on company button
    And I fill company form "<email>" "<name>" "<lastname>" "<pass>" "<city>" "<postcode>" "<street>" "<house>" "<company>" "<NIP>"
    Then Company user should be succesfully registered
    Examples:
      |email       |name  |lastname |pass     |city   |postcode|street     |house|company|NIP       |
      |test@test.pl|Piotr |Nowak    |testtest |Wroclaw|50-001  |Trzebnicka |20   |GLS    |1111111111|