# Language: en

Feature: Registering a person in the system
    Scenario: Creating a new person
        Given I am connected to the system to register a new person
        When I send the person's data to the system
        Then the system should return a 201 status code
        And the response should include the newly created person information