@bidqa
  Feature: Test cases


    @bidqa1
    Scenario: Verify that in the Profile Avatar Images can be uploaded T45594
      Given I navigate to login page
      When I log in as a QA engineer input "denisshirokikh", "shdg1979"
      Then I go to My Account
      Then I scroll to end of page
      Then I upload image "C:\Users\Денис\Рабочий стол\IMG_0495_thumb.jpg"
      Then I click save button
      And avatar image should be present


    @bidqa2
     Scenario: Verify BidQA logo links to homepage T45514
       Given I navigate to main page
       When I Click BidQA logo at upper left corner
       Then I Observe that homepage will refresh

    @bidga3
     Scenario: Verify User name & Email are displayed T45718
       Given I navigate to main page
       Then I navigate to login page
       Then I log in as a QA engineer input "denisshirokikh", "shdg1979"
       Then I go to My Account
       Then I verify user name and email field
       # OR
       #Then element having xpath "//*[@name='new_user_email']" should have attribute "value" with value "denisshirokikh@gmail.com"
       #Then element having xpath "//*[@name='new_user_name']" should have attribute "value" with value "denisshirokikh"

    @bidqa4
    Scenario: Verify Change password T45721
      Given I navigate to main page
      Then I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "shdg1979"
      Then I go to My Account
      Then I enter "shdg1979" into password field
      And  I click save


    @bidqa5
    Scenario: Verify that click on the avatar opens a profile of the corresponding use T45585
      Given I navigate to main page
      Then I navigate to login page
      Then I log in as a QA engineer input "denisshirokikh", "shdg1979"
      Then I navigate QA eng Search
      Then I click on avatar
      Then I verify open exact page

    @bidqa6
    Scenario: Verify that project images carousel are present on home page at browser width reduction T45608
      Given I navigate to main page
      When I maximize browser window
      Then I wait for 3 sec
      Then I scroll to element having xpath "//*[@id='project-home-page-main-inner']"
      Then I wait for 6 sec
      Then I resize browser window size to width 400 and height 700
      Then I wait for 5 sec
      Then element having xpath "//*[@id='project-home-page-main-inner']" should be present
      Then I resize browser window size to width 700 and height 700
      Then I wait for 6 sec
      Then element having xpath "//*[@id='project-home-page-main-inner']" should be present
      And I maximize browser window

    #@bidqa7
    #Scenario: Verify that headline reads Find available QA Engineers and improve your product T45582
     # Given I navigate to main page
     # Then I wait for 5 sec
     # Then I click on element having xpath "//*[@id='cssmenu']//*[contains(text(),'Home')]"
      #And Then verify "We are Live in BETA" on the page


    @bidqa8
    Scenario: Verify that Log In link is functional T45528
      Given I navigate to main page
      Then I wait for 3 sec
      Then Click "Log In" in upper right corner of screen
      Then I observe that Login page opens

    @bidqa9
    Scenario: Verify that Join Us blue button is present on the Home page T45634
      Given I navigate to main page
      Then I wait for 3 sec
      Then I observe Join Us blue button is present

    @bidqa10
    Scenario: Verify the copyright information on Project Search page
      Given I navigate to main page
      Then I scroll to end of page
      Then Observe the copyright information

    @bidqa11
    Scenario: Verify that user can not put invalid email in the field PayPal Email T45481
      Given I navigate to main page
      Then I navigate to login page
      When I log in as a QA engineer input "denisshirokikh", "shdg1979"
      Then I go to My Account
      Then I click on element having xpath "//*[@id='my-account-admin-menu']//*[contains(text(),'Personal Info')]"
      Then I enter "htjfkyfkjyjgfkug" into input field having xpath "//*[@name='paypal_email']"
      Then I click save button
      And element having xpath ".//*[@id='content']//*[@class='error']" should be present

    @bidqa12
    Scenario: Verify that QA Engineer can see all the transaction on transaction page T45410
      Given I navigate to login page
      When I log in as a QA engineer input "denisshirokikh", "shdg1979"
      Then I go to "Finances"
      Then I wait for 3 sec
      Then I click on element having xpath "//*[@id='content']//*[contains(text(),'Withdraw Money')]"
      Then I wait for 3 sec
      Then I input "25" amount
      Then I click on element having xpath "//*[@name='withdraw']"
      Then I wait for 3 sec
      Then I click on element having xpath ".//*[@id='content']//*[contains(text(),'Close Request')]"
      Then element having xpath "//*[@id='content']" should be present
      And I take screenshot

