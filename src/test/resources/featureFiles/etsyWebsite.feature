Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the "https://www.etsy.com/uk/" landing page
    When he searches for a product "Toys" from the input box
    Then the result should be displayed

#  @ui @screenplay
#  Scenario: Should be able to search for a product from the input box (screenplay)
#    Given John is viewing the "https://www.etsy.com/uk/" landing page
#    When he searches for a product from the input box (screenplay)
#    Then the result should be displayed (screenplay)

  @ui
  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the "https://www.etsy.com/uk/" landing page
    And he searches for a product from the dropdown of "Jewellery & Accessories"
    And selects the product category of "Necklaces"


  @ui
  Scenario: Should be able to search for a product from the icons
    Given John is viewing the "https://www.etsy.com/uk/" landing page
    And he searches for a product from the icon of "clothing"
