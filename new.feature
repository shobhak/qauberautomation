@first23new

Feature:  Regression test.bidqa

Scenario: T45662
Verify that the user can send a message

Then Enter Username "kids7" and Enter Password "ytkids777"
Then Click Sign In
Then Click to Private Messages
Then Click on Send New Message button
Then Enter a "Mila"
Then Enter Subject
Then Enter "message"
Then Attach files
Then Click Send Message

@first24
Scenario: T45706
Verify that the user can send a message as a QA Engineer

Then Enter Username "Mila" and Enter Password "bidqa123"
Then Click Sign In
Then Click to Private Messages
Then Click on Send New Message button
Then Enter a "kids7"
Then Enter Subject
Then Enter "message"
Then Attach files
Then Click Send Message
Then Verify message msg to user has been sent is appears

  @first25
  Scenario: T45691 	Verify that user can delete messages in mailbox
    Then Enter Username "Mila"
    Then Enter Password "bidqa123"
    Then Click Sign In
    Then Click to Private Messages
    Then Click "Sent Items"
    Then Click "Delete" button
    Then Click on "Confirm Deletion"
    Then Verify Private Messages: "Sent Items"


@first26
Scenario: T45666 Verify "Messaging Home" button displaed.

  Then Enter Username "Mila"
  Then Enter Password "bidqa123"
  Then Click Sign In
  Then Click to Private Messages
  Then Click "Inbox".
  Then Click on Messaging Home button
  Then Verify Messaging Home button displayed

  #06/01/16
@first27

Scenario: T45670 	Verify that "Inbox" button in messaging is functional.

  Then Enter Username "Mila"
  Then Enter Password "bidqa123"
  Then Click Sign In
  Then Click to Private Messages
  Then Click "Inbox".
  Then Verify page Inbox is open

  @first28

  Scenario: T45674 	Verify that "Sent Items" button in messaging is functional.

    Then Enter Username "kids7"
    Then Enter Password "ytkids777"
    Then Click Sign In
    Then Click to Private Messages
    Then Click on Sent Items button
    Then Verify Private Messages: Sent Items

    @first29
  Scenario: T45678 	Verify that user can open and read messages
      Then Enter Username "kids7"
      Then Enter Password "ytkids777"
      Then Click Sign In
      Then Click to Private Messages
      Then Click on Sent Items button
      Then Click the "Read" button
      Then Verify message is open

      @first30
      Scenario: T45682 	Verify that user can reply to the messages.
        Then Enter Username "kids7"
        Then Enter Password "ytkids777"
        Then Click Sign In
        Then Click to Private Messages
        Then Click on Inbox
        Then Click the "Read" button
        Then Click Replay button
        Then Enter "message"
        Then Click Send Message

#        @first31
#Scenario: T45695 	Verify that unread message has bold font
#
#          Then Enter Username "kids7"
#          Then Enter Password "ytkids777"
#          Then Click Sign In
#          Then Click to Private Messages
#          Then Click on Inbox
#          Then Verify unread message has bold font

  @first32
  Scenario: T45697 Verify that "messaging home" button function

    Then Enter Username "Mila"
    Then Enter Password "bidqa123"
    Then Click Sign In
    Then Click to Private Messages
    Then Click "Inbox".
    Then Click on Messaging Home button
    Then Verify Messaging Home button displayed

      @first33
        Scenario: T45703
      Verify that user can delete attached text files while composing messages.

        Then Enter Username "Mila" and Enter Password "bidqa123"
        Then Click Sign In
        Then Click to Private Messages
        Then Click on Send New Message button
        Then Enter a "kids7"
        Then Enter Subject
        Then Enter "message"
        Then Attach a files
        Then Click the "Delete file"
        Then Verify text File deleted

        @first34
Scenario:T45705
        Verify that user can delete image File while composing messages.

          Then Enter Username "Mila" and Enter Password "bidqa123"
          Then Click Sign In
          Then Click to Private Messages
          Then Click on Send New Message button
          Then Enter a "kids7"
          Then Enter Subject
          Then Enter "message"
          Then Attach the img files
          Then Click the "Delete file"
          Then Verify text File deleted


@first35

Scenario: T46363 	Verify that the form of the "Support" page includes all required elements.

  Given Open home page
  Then Click "Support" link
  Then Verify Your Name text field
  Then Verify Your Email text field
  Then Verify Subject required text field
  Then Verify Your massage required text field;
  Then Verify "Send" button


  #06/06/16
  @first36
  Scenario: T46231
  Verify that "Welcome username!" message is present after logging in

    Then Enter Username "Mila" and Enter Password "bidqa123"
    Then Click Sign In
    Then Verify message "welcome" in the top left corner

    @first37
    Scenario: T46233
    Verify that message "You are logged in as a <type of user>" is displayed

      Then Enter Username "Mila" and Enter Password "bidqa123"
      Then Click Sign In
      Then Verify message "You are logged in as" is displayed

      @first38

      Scenario: T46150
      Verify user can not login with incorrect credentials
        Then Enter Username "any username" and Enter Password "any pass"
        Then Click Sign In
        Then Verify "ERROR" mess is displayed

        @first39

        Scenario: T46151
        Verify user can not login with incorrect password
          Then Enter Username "Mila" and Enter Password "any pass"
          Then Click Sign In
          Then Verify "ERROR" mess is displayed

          @first40
          Scenario:T46152
          Verify user can not login with empty password field and gets appropriate error messag

            Then Enter Username "kids7"
            Then Click Sign In
            Then Verify "Error" mess is displayed

@first41
Scenario:T46153 	Verify user can not login with empty username field and gets appropriate error message


  Then Enter Password "ytkids777"
  Then Click Sign In
  Then Verify "Error" mess is displayed

  @first42

  Scenario:  	T46167 	Verify user can retrieve lost password

    Given Open home page
    Then Click Log In button
    Then Click a "Lost your password?"
    Then Verify message displays Please enter your information here.

    @first43
    Scenario: T46181
    Verify user is redirected to home page by clicking on company logo at login page

      Given Open home page
      Then Click Log In button
      Then Verify Logo button present


  @first44
      Scenario:T46182
      Verify user is redirected to home page by clicking on company logo at registration page

    Given Open home page
    Then Click on "Register" link
    Then Click "logo" but
    Then Verify link redirected to home page

    @first45(07/06/16)
  Scenario: T46183
  Verify user is redirected to home page by clicking on "Home" button at login page
      Given Open home page
      Then Click Log In button
      Then Click "Home" button.
      Then Verify link redirected to home page

@first46
  Scenario:T46184 	Verify user is redirected to home page by clicking on "Home" button at registration page
  Given Open home page
  Then Click on "Register" link
  Then Click "Home" button.
  Then Verify link redirected to home page


  @first47
      Scenario: T46185 	Verify user is redirected to Login page by clicking on "Login" button at registration page

        Given Open home page
      Then Click on "Register" link
      Then Click at the "Login"
      Then Verify link redirected to login page

    @first48
    Scenario:T46226
    Verify that links from "QA Engineer Menu" match with the names
      Then Enter Username "Mila" and Enter Password "bidqa123"
      Then Click Sign In
      Then Click on the "Projects I" link
       Then Verify link redirected to won page

      @first49
      Scenario:T46217
      Verify user is redirected to Register page by clicking on "Register" button at the login page
        Given Open home page
        Then Click Log In button
        Then Click on "Register" link
        Then Verify "Register"page open

        @first50
        Scenario: T46219
        Verify that by clicking on "Keep me logged in" radio button keeps user loged in

          Then Enter Username "Mila" and Enter Password "bidqa123"
          Then Select Keep me logged in radio button
          Then Click Sign In
          Then Close browser and open again
          Then Verify user is loged in

          #08/06/16
@first51
 Scenario:T45514 	Verify BidQA logo links to homepage

  Given Open home page
  Then Click "logo" but
  Then Verify link redirected to home page

  @first52
  Scenario:T45523
  Verify that "Register" link is functional.
    Given Open home page
    Then Click on "Register" link
    Then Verify "Register"page open

  @first53
  Scenario:T45528
    Verify that "Log In" link is functional
      Given Open home page
      Then Click Log In button
      Then Verify link redirected to login page

    @first54
    Scenario:T45563
    Verify functionality of the project title link under "Latest Projects"
      Given Open Hhome page
      Then Click any "Test" highlighted in blue
      Then Verify "Test" page open

    @first55
    Scenario:T45568
    Verify functionality of the Author (User Name) link under "Latest Projects"
      Given Open Hhome page
      Then Click on the "Asya3" highlighted in blue
      Then Verify "User Profile" page is open