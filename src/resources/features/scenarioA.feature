Feature: Property Finder Qatar and UAE

	Scenario: First scenario
	  When I open the page url "propertyfinder.qa"
	  Then I validate the page title and URL "propertyfinder.qa"
	  When I select "Buy" from "Category" field
	  And I search "Pearl" in "Location" field
	  And I select "Villa" from "Property" field
	  And I select "3 BEDS" from "Minimum_Bedroom_Group" field
	  And I select "7 BEDS" from "Maximum_bedroom_Group" field
	  When I click on "search" link
	  And I select "HighPrice" from "Sorting" field
	  Then I fetch all the prices of the listing and save it in csv file 
	      
	Scenario: Second scenario
	  When I open the page url "propertyfinder.ae"
	  Then I validate the page title and URL "propertyfinder.ae"
	  When I click on "Find agent" link
	  And I filter Hindi English Arabic from Languages field
	  When I click on "searchFA" link
	  Then I get the total number of "Combined" agents
	  And I select "India" from "Nationality" field
	  Then I get the total number of "Indian" agents
	  Then I validate the current agents to be in lesser number than previous

	Scenario: Third scenario
		When I open the page url "propertyfinder.ae"
		Then I validate the page title and URL "propertyfinder.ae"
		When I click on "Find agent" link
		Then I click on "First agent" link
		And I capture the First Agent details in a text file
		Then I capture screenshot of the page "before" changing language
		Then I click on "Arabic language" link
		Then I capture screenshot of the page "after" changing language