@ui
Feature: Shop button on main page should contain categories {} and when they selected they should be bold , and all links should work


  Background:
    Given the user is on the home page
    When  the user hovers over the Shop button
    Then the categories beneath the Shop button should be visible



  Scenario: Upon hovering over categories beneath the "Shop" button, a bold font style should be applied to the selected category.
    Then the user hovers over each category and categories font should change to a bold font style


@WIP
  Scenario: Each category under the "Shop" should contain working link.
    Then the user ensures that every hyperlink under the Shop menu works as expected



  Scenario: Shop menu should contain categories.
    Then Shop menu contain categories
      | Appliances                          |
      | Baby                                |
      | Beauty                              |
      | Clothing, Luggage & Handbags        |
      | Computers                           |
      | Costco Direct                       |
      | Costco Next                         |
      | Electronics                         |
      | Floral & Gift Baskets               |
      | Furniture                           |
      | Gift Cards & Tickets                |
      | Gourmet Foods                       |
      | Grocery, Household Essentials & Pet |
      | Health & Personal Care              |
      | Holiday & Seasonal                  |
      | Home & Installation Services        |
      | Home & Kitchen                      |
      | Home Improvement                    |
      | Jewelry, Watches & Sunglasses       |
      | Mattresses                          |
      | Office Products                     |
      | Patio, Lawn & Garden                |
      | Special Events                      |
      | Sports & Fitness                    |
      | Tires & Auto                        |
      | Toys & Books                        |
      | View More Categories                |



