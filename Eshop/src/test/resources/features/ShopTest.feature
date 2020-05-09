Feature: AutomationPractice Main Test
  This feature allows user to randomly choose
  item of the women clothes, proceed through
  summary, address and shipping details, pay
  by cheque, confirm order and verify the order
  was being processed. User also verifies if his
  last order price remains the same in the list

  Background:
    Given User navigates to the page
    And User clicks login link
    And User logins to the e-shop using credentials
      | username                 | password     |
      | viktorviktor11@gmail.com | 123456qwerty |

    @MainScenario
    Scenario: AutomationPractice Test Scenario
      When User clicks women category button
      And User randomly chooses product and is redirected to Order Summary Page
      And User continues clicking proceed button and is redirected to Order Address Page
      And User clicks proceed and is redirected to Order Shipping Page
      And User marks agreement, clicks proceed and redirects to Order Payment Page
      And User clicks on Pay By Cheque
      Then User gets "Your order on My Store is complete." order result message
      When User clicks go back to orders
      Then User verifies his last order price is correct