Feature: Register user
  Scenario Outline: Register Private User
  Given I open codersguru
  When I click on register the new user
  And I fill a private form "<email>" "<name>" "<lastname>" "<pass>" "<city>" "<postcode>" "<street>" "<house>"
  Then The User should be succesfully registered
  Examples:
  |email       |name|lastname |pass     |city   |postcode|street    |house|
  |test@test.pl|Jan |Kowalski|testujemy|Wroclaw|50-001  |Trzebnicka |20   |