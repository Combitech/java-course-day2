Feature: Images
  Scenario: Upload an image
    When I upload an image for user with id 1
    Then I should get a status 201