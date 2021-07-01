Feature: Testing a REST API
Users should be able to submit GET and POST requests to a web service

Scenario: Add user to database
When User sends data
Then The server should handle it and return a success status

Scenario: Get users from database
When User requests data
Then All users are returned