Feature: Images
  Scenario: Upload an image
    When I upload an image for user with id 1
    Then I should get a status 201

  Scenario: Delete an image
    When I delete an image for user with id 1
    Then I should get a status 204

  Scenario: Get an image that exists
    When I get an image for user with id 1
    Then I should get a status 200

  Scenario: Get an image that does not exists
    When I get an image for user with id 2
    Then  I should get a WebApplicationException with status code 404