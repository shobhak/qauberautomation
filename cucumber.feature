@cucumber
  Feature: Cucumber embedded steps

    @cucumber1
    Scenario: Cucumber embedded steps

########################################################################################################################
# Navigation Steps
########################################################################################################################

    # step to open browser URL
      Given I navigate to "https://student:latham@www.portnov.com/data/ruby/html/sample.html"

    # step to imitate browser back button
      And I navigate back

    # step to imitate browser forward button
      When I navigate forward

    # step to close browser
      Then I close browser

    # step to resize browser
      Then I resize browser window size to width 800 and height 600

    # step to maximize browser
      Then I maximize browser window

    # step to refresh page
      Then I refresh page

    # step to switch to new window
      Then I switch to new window

    # step to switch to previous window
      Then I switch to previous window

    # step to switch to main window
      Then I switch to main window

    # step to close new window
      Then I close new window

    # step to switch to frame
      Then I switch to frame "frameId"

    # step to switch to main content
      Then I switch to main content

    # steps to scroll to element
      Then I scroll to element having xpath "//*[@*='val']"

    # steps to scroll web page to top or end
      Then I scroll to end of page
      Then I scroll to top of page

    # step to hover over a element
      Then I hover over element having xpath "//*[@*='val']"

    # steps to zoom in page
      Then I zoom in page

    # steps to zoom out page
      Then I zoom out page

    # method to reset page view
      Then I reset page view

    # steps to zoom out till element displays
      Then I zoom out page till I see element having xpath "//*[@*='val']"

########################################################################################################################
# Click Elements Steps
########################################################################################################################

    # click on web element
      Then I click on element having xpath "//*[@*='val']"

    # click on web element with JavaScript
      Then I forcefully click on element having xpath "//*[@*='val']"

    # double click on web element
      Then I double click on element having xpath "//*[@*='val']"

    # steps to click on link
      Then I click on link having text "some text"

    # steps to click on link with partial text
      Then I click on link having partial text "some partial text"

########################################################################################################################
# Alert Handling Steps
########################################################################################################################



      Then I dismiss alert

########################################################################################################################
# Input Steps
########################################################################################################################

    # enter text into input field steps
      Then I enter "value" into input field having xpath "//*[@*='val']"

    # clear input field steps
      Then I clear input field having xpath "//*[@*='val']"

    # select option by text/value from dropdown
      Then I select "option value" option by value from dropdown having xpath "//*[@*='val']"

    # select option by text/value from multiselect
      Then I select "option text" option by text from multiselect dropdown having xpath "//*[@*='val']"
      Then I select "option text" option by text from multiselect dropdown having xpath "//*[@*='val']"

    # select option by index from dropdown/multiselect
      Then I select 7 option by index from dropdown having xpath "//*[@*='val']"

    # step to select option from mutliselect dropdown list
      Then I select all options from multiselect dropdown having xpath "//*[@*='val']"

    # step to unselect option from mutliselect dropdown list
      Then I unselect all options from multiselect dropdown having xpath "//*[@*='val']"

    # check checkbox steps
      Then I check the checkbox having xpath "//*[@*='val']"

    # uncheck checkbox steps
      Then I uncheck the checkbox having xpath "//*[@*='val']"

    # steps to toggle checkbox
      Then I toggle checkbox having xpath "//*[@*='val']"

    # step to select radio button
      Then I select radio button having xpath "//*[@*='val']"

    # steps to select option by text from radio button group
      Then I select "option value" option by value from radio button group having xpath "//*[@*='val']"

########################################################################################################################
# Assertion Steps
########################################################################################################################

    # page title checking
      Then I should see page title as "exact Text"

    # page title checking
      Then I should not see page title as "wrong Text"

    # page title checking
      Then I should see page title having partial text as "partial Text"

    # step to check element text
      Then element having xpath "//*[@*='val']" should have text as "exact Text"

    # step to check element partial text
      Then element having xpath "//*[@*='val']" should have partial text as "partial Text"

    # step to check attribute value
      Then element having xpath "//*[@*='val']" should have attribute "attribute name" with value "attribute value"

    # step to check element enabled or not
      Then element having xpath "//*[@*='val']" should be disabled

    # step to check element present or not
      Then element having xpath "//*[@*='val']" should be present

    # step to assert checkbox is checked or unchecked
      Then checkbox having xpath "//*[@*='val']" should be unchecked

    # steps to assert radio button checked or unchecked
      Then radio button having xpath "//*[@*='val']" should be unselected

    # steps to assert option by text from radio button group selected/unselected
      Then option "option value" by value from radio button group having xpath "//*[@*='val']" should be unselected

    # steps to check link presence
      Then link having text "exact link text" should be present

    # steps to check link presence
      Then link having partial text "partial link text" should be present

    # step to assert javascript pop-up alert text
      Then I should see alert text as "exact text match"

    # step to assert dropdown list
      Then option "option text" by text from dropdown having xpath "//*[@*='val']" should be selected

    # step to assert difference in images
      Then actual image having xpath "//*[@*='val']" and expected image having xpath "//*[@*='val']" should be similar

########################################################################################################################
# Progress Steps
########################################################################################################################

    # wait for specific period of time
      Then I wait for 3 sec

    # wait for specific element to display for specific period of time
      Then I wait 3 seconds for element having xpath "//*[@*='val']" to display

    # wait for specific element to enable for specific period of time
      Then I wait 3 seconds for element having xpath "//*[@*='val']" to enable

########################################################################################################################
# Screenshot Steps
########################################################################################################################

      Then I take screenshot

########################################################################################################################
# Configuration Steps
########################################################################################################################

      Then I print configuration

########################################################################################################################
# Mobile Steps
########################################################################################################################

      Then I tap on element having xpath "//*[@*='val']"

      Then I long tap on element having xpath "//*[@*='val']"
      Then I long tap on element having xpath "//*[@*='val']" for "3" sec

      Then I long tap on co-ordinate "100","100"
      Then I long tap on co-ordinate "100","100" for "3" sec

      Then I swipe from element having xpath "//*[@*='val']" to element having xpath "//*[@*='val']"
      Then I swipe from co-ordinates "100","100" to co-ordinates "200","200"

      Then I swipe co-ordinates "100","100" to right
      Then I swipe co-ordinates "100","100" to left

      Then I swipe co-ordinates "100","100" to down
      Then I swipe co-ordinates "100","100" to up

      Then I swipe right
      Then I swipe left
      Then I swipe down
      Then I swipe up

      Then I swipe element having xpath "//*[@*='val']" to right
      Then I swipe element having xpath "//*[@*='val']" to left
      Then I swipe element having xpath "//*[@*='val']" to down
      Then I swipe element having xpath "//*[@*='val']" to up

      Then I tap on back button of device
      Then I press back button of device

      Then I close app