@first

Feature:  Regression test bidqa

  @firts1
  Scenario:  T45645 Verify that clicking "Show All Categories" link

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click Show All Categories
    Then Verify All Categories page is open


@first2

  Scenario:  Verify functionality of the "View User Feedback" link under "Latest Projects"
    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click on View User Feedback


@first3

  Scenario: T45674 Verify that "Sent Items" button in messaging is functional.

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
   Then Click to Private Messages
   Then Click on Sent Items button
    Then Verify Private Messages: Sent Items

  @first4

  Scenario: T45795 Verify that user can search for "QA Engineer".

    Then Enter Username "Mila"
    Then Enter Password "bidqa123"
    Then Click Sign In
    Then Click on the Project Search
    Then Click on the Project and select QA Engineer from drop down list
    Then Enter the "Mila" or the part of the QA Engineer into search text box
    Then Verify display search result

@first5
    Scenario: T45666 Verify "Messaging Home" button displaed.

   Then Enter Username "Mila"
   Then Enter Password "bidqa123"
   Then Click Sign In
   Then Click to Private Messages
   Then Click on Messaging Home button
   Then Verify Messaging Home button displayed


  @first6
  Scenario: T45338 Verify that QA Engineer can close the dispute

    Then Enter Username "Mila"
    Then Enter Password "bidqa123"
    Then Click Sign In
    Then Click on Disputes
    Then Type "goodbuy" into Comment for closing this dispute field
    Then Click Close button

  @first7

  Scenario:   T46561
  Verify that Project Owner gets message on screen "Dispute Created"

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click on the Disputes
    Then Type "Hello" into
    Then Click on Create Dispute button
    Then Verify Dispute Created highlights in green

    @first8n
  Scenario: T45953 Verify that the Project Owner can repost a closed project

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click the Repost project button in My Latest Closed Projects
    Then Click on Publish Project button at the bottom of the page


  @first9

    Scenario: T45721 Change Password

      Then Enter Username "Mila"
      Then Enter Password "bidqa123"
      Then Click Sign In
      Then Click PERSONAL INFO link from MY ACCOUNT menu
      Then Click on country and choose other at dropdown list
      Then Click Save


  @first10
  Scenario: T45725 Verify the copyright information on "Project Search" page.

  @first11negative

  #Scenario: Verify user cannot submit an empty "feedback form" in Support page

#    Given Navigate to home page
#    Then Verify the copyright information on Project Search page

@first12 non
Scenario: T45344 Verify that error message when QA Engineer create dispute without comm

  Then Enter Username "Mila"
  Then Enter Password "bidqa123"
  Then Click Sign In
  Then Click the Disputes
  Then Click on Create Dispute button
  Then Verify Error message You cannot leave the dispute comment blank! appears



  @first13
 Scenario: T45460 Verify that QA Engineer can see the heading "Pending Withdrawals" on Finances page

   Then Enter Username "Mila"
   Then Enter Password "bidqa123"
   Then Click Sign In
   Then Click on Finances link
   Then Verify Pending Withdrawals appears


  @first14
  Scenario: T45492 Verify that Project Owner can see the heading "Finances" on Finances page

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click on Finances link
    Then Verify user can see the heading Finances



      @first15

      Scenario: T45411
      Verify that QA Engineer can see all the transaction on transaction page

        Then Enter Username "kids7"
        Then Enter Password "ytkids777"
        Then Click Sign In
        Then Click on Finances link
        Then Verify Rejected Withdrawals displayed

        @first16

        Scenario: T45662
        Verify that the user can send a message as a Project Owner

          Then Enter Username "kids7"
          Then Enter Password "ytkids777"
          Then Click Sign In
          Then Click to Private Messages
          Then Click on Send New Message button
          Then Enter a "Mila"
          Then Enter Subject
          Then Enter "message"
          Then Click Send Message


  @first17
 Scenario: T45459
 Verify that QA Engineer can see the heading “What do you want to do?” on Finances page

    Then Enter Username "Mila"
    Then Enter Password "bidqa123"
    Then Click Sign In
    Then Click on Finances link
    Then Verify What do you want to do appears


    @first18
    Scenario: T45585
    Verify that click on the avatar opens a profile of the corresponding user

      Then Enter Username "Mila"
      Then Enter Password "bidqa123"
      Then Click Sign In
      Then Click menu QA Engineer Search
      Then Click on the any avatar
      Then Verify open User Profile page related to that image displayed

      @first19
      Scenario: T45528
      Verify that "Log In" link is functional

        Given Open home page
        Then Click Log In button
        Then Verify Log In page is open

        @first20

        Scenario: T45514
        Verify BidQA logo links to homepage

          Given Open home page
          Then Click Logo button
          Then Verify Featured Projects of the Day page is open



@first21
          Scenario: T45719
Update & Save Personal Info with only required field -PayPal Email

  Then Enter Username "kids7"
  Then Enter Password "ytkids777"
  Then Click Sign In
  Then Click PERSONAL INFO link from MY ACCOUNT menu
  Then Enter valid email address to PayPal Email field
  Then Click Save

  @first22

  Scenario:T45480
  Verify that Project Owner can see the heading "Pending Escrow Outgoing Payments"

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click on Finances link
    Then Verify Pending Escrow Outgoing Payments appears

#  @firstextra
#
  Scenario: Loged Out

    Given Open home page
    Then If user Loged Out
    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
     # Then Loged Out

@firstextra1

#Scenario: Verify user can login in bestby
#  Given Open the home page
#  Then Click "Create Account" on
   #Then Click at "Create Account"

@EXTRA
  Scenario: print out1
  #Given Open the home
  Then Click category "Age"
  Then Click cubcategory "Big Kids"
  Then print out result

  Scenario: print out2
 #Given Open the home
    Then Click category "Age"
    Then Click cubcategory "Big Kids"
    Then Print