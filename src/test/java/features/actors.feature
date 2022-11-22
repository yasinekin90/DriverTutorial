Feature: Feature2

  @Tag2
  Scenario:Check whether user exist
    Given user on guidersoft query page
    When user select required actorlist from dropdownmenu
    Then actors should be listed on the page
    Then lastName should be exist in DB