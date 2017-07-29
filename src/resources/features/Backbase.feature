Feature: CRUD - Create, Read, Update and Delete

  Background: 
    Given I open the page url "computer-db"
    Then I validate the "page title" in home page

  Scenario: Create and Delete existing computer details
    When I click on "create new computer" button from the home page
    Then I validate the "page title" in create page
    When I create a new machine
    Then I validate the "newly created computer" in filter page
    When I click on "machine" link from the home page
    And I click on "delete this computer" button from the create page
    Then I validate the "deleted computer details" in filter page

  Scenario: Read and Update existing computer details
    When I click on "create new computer" button from the home page
    Then I validate the "page title" in create page
    When I create a new machine
    Then I validate the "newly created computer" in filter page
    When I click on "machine" link from the home page
    And I enter "updated name" in the "Computer update name" field
    And I click on "save this computer" button from the create page
    Then I validate the "updated computer details" in filter page
