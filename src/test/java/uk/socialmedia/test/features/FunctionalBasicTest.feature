Feature: To Test Basic Functionality of JSonPlaceHolder Social Network Project


 @smoke
  Scenario: To check the basic Service availablity
    Given as a system user
    And I am able to provide status of the backend site

  @smoke
   Scenario:  Retrive all post as social media User
     Given as a Social Media user
     And I am able to retrive all the posts successfully

  @smoke
  Scenario:  Retrive all comment as social media user
    Given as a Social Media user
    And I am able to retrive all the comments succesfully

  @smoke
  Scenario:  Retrive all comment as social media user
    Given as a Social Media user
    And I am able to retrive all the users succesfully