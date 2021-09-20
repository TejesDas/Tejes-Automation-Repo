Feature: jkvkhv

  @xyz
  Scenario: Login to Flipkart
  Given start testcase "Flipkart_Login"
    Given I have the URL
    When I provide Username
    And I provide Password
    And I click on Submit button
    Then I am logged into application

