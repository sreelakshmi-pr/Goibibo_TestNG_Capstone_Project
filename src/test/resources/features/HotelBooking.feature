Feature: Verify the functionalities of Hotel Booking

  Scenario: Search hotel
    Given user open goibibo website
    When user select hotel booking
    And user enters location "hotel.city"
    And user select checkIn date "hotel.checkInDate"
    And checkOut date "hotel.checkOutDate"
    And select number of rooms "2",adults "4" ,child "1" and child age is "2"
    Then user clicks on search
    And verify user is on hotels displayed page

  Scenario: Book the first hotel
    Given user open goibibo website
    When user select hotel booking
    And user enters location "hotel.city"
    When user clicks on search
    And user clicks on first hotel displayed on the hotel search page
    And user clicks on select room Button
    And verify user is on property information page
    And user fills the guest details
    And user clicks on proceed to payment
    Then verify user is on payment page


  Scenario:Verify price of hotels are in low to high
    Given user open goibibo website
    When user select hotel booking
    And user enters location "hotel.city"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on price low to high
    Then verify the hotels displayed in price low to high order

  Scenario:Verify price of hotels are in high to low
    Given user open goibibo website
    When user select hotel booking
    And user enters location "hotel.city"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on price high to low
    Then verify the hotels displayed in price high to low order

  Scenario:Verify customer rating of hotels are in descending order
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Mumbai"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on customer rating
    Then verify the hotels displayed in descending order by customer rating


  Scenario Outline:Verify country type is automatically selected by enter city
    Given user open goibibo website
    When user select hotel booking
    And user enter location "<city>"
    Then verify "<selected_country_Type>" is selected with respect to the city we entered
    Examples:
      | city   | selected_country_Type |
      | Mumbai | India                 |
      | London | International         |


  Scenario Outline:Verify property type are displayed on search page when we filter by property type
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on "<property>"
    Then verify "<property>" are displayed in search page

    Examples:
      | property  |
      | Apartment |
      | Villa     |
      | Hotel     |

  Scenario Outline:Verify popular filters are working properly
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on "<popular_filters>"
    Then verify respected filters "<output>" are displayed in search page

    Examples:
      | popular_filters               | output                                |
      | Couple-friendly Stays         | Couple Friendly                       |
      | Free Cancellation Available   | Free Cancellation Till Checkin        |
      | Free Breakfast Included       | INCL OF FREE BREAKFAST                |
      | Breakfast Included            | INCL OF FREE BREAKFAST                |
#      | Breakfast and Dinner Included | INCL OF FREE BREAKFAST + LUNCH/DINNER |
#      | All Meals Available           | INCL OF ALL MEALS                     |


  Scenario Outline:Verify price filters are working properly
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on "<price_range>"
    Then verify price filters "<price_range>" are displayed in search page

    Examples:
      | price_range   |
      | Upto ₹1000    |
      | ₹1001 - ₹2000 |
      | ₹2001 - ₹4000 |
      | ₹4001 - ₹6000 |
      | ₹6000 +       |

  Scenario Outline:Verify customer rating filters are working properly
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user select one "<rating>"
    Then verify the hotels with rating grater than "<rating>" is displayed on the search page

    Examples:
      | rating |
      | 4.5    |
      | 4      |
      | 3.5    |
      | 3      |

  Scenario Outline:Verify star rating filters are working properly
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user select one star rating "<click_on_star>"
    Then verify the hotels with star rating grater than "<no_of_star>" is displayed on the search page

    Examples:
      | click_on_star | no_of_star |
      | 1             | 5          |
      | 2             | 4          |
      | 3             | 3          |


  Scenario Outline:Verify the functionality of update search button
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user enters location "<city>" on update search
    And user clicks on update search button
    Then verify the hotel search page is updated by "<city>"

    Examples:
      | city    |
      | Mumbai  |
      | Goa     |
      | Kolkata |





