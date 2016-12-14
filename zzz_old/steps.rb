#basicurl = "https://test.bidqa.com/wp-login.php"

#@bidqa1

Then(/^Enter Username "([^"]*)"$/) do |login|
 $driver.get "https://test.bidqa.com/wp-login.php"
 $driver.manage.window.maximize
 element = $driver.find_element :xpath => "//input[@id='log']"
 element.clear
 element.send_keys login
end

 Then(/^Enter Password "([^"]*)"$/) do |pass|
  element = $driver.find_element :xpath => "//input[@id='login_password']"
  element.send_keys pass
end

Then(/^Click Sign In$/) do
 element = $driver.find_element :xpath => "//input[@id='submits']"
 element.click
end


Then /^Click Show All Categories$/ do
 element = $driver.find_element(:xpath, "//*[@class='jetmenu blue']//*[contains(text(),'Show All Categories')]").click
 sleep 5
end

Then /^Verify All Categories page is open$/ do
 page = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'All Categories')]").text
 assert(page = "All Categories","Error: element is checked by default!")
end

# @first2non


Then /^Click on View User Feedback$/ do
 element = $driver.find_element(:xpath, "//*[@id='post-4043']//*[contains(text(),'View User Feedback')]").click
end

# Then /^Verify User Feedback is present$/ do
#   user = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'User Feedback - kids7')]").text
#   assert(page = "user","Error: element is checked by default!")
#   sleep 5
# end


#@first3 T45674


Then /^Click to Private Messages$/ do
 element = $driver.find_element :xpath => "//*[@id='my-account-admin-menu']//*[contains(text(),'Private Messages')]"
 element.click
end


Then(/^Click on Sent Items button$/) do
 element = $driver.find_element(:xpath, "//*[@class='green_btn'][contains(text(),'Sent Items')]").click
end

Then(/^Verify Private Messages: Sent Items$/) do
  name= $driver.find_element(:xpath, "//*[@class='box_title'][contains(text(),'Private Messages: Sent Items')]").displayed?
 assert(name = "Sent Items","Error: element is checked by default!")
end







#4 @first4 T45795

Then(/^Click on the Project Search$/) do
 element = $driver.find_element(:xpath, "//*[@id='cssmenu2']/ul/li[2]/a").click
end

Then(/^Click on the Project and select QA Engineer from drop down list$/) do
 element = $driver.find_element(:xpath, "//*[@id='dd']/span").click
 element = $driver.find_element(:xpath, "//*[@class='dropdown']//*[contains(text(),'QA Engineers')]").click
end

Then(/^Enter the "([^"]*)" or the part of the QA Engineer into search text box$/) do |name|
 element = $driver.find_element(:xpath, "//*[@id='my-top-search-input']")
 element.send_keys name
 $driver.find_element(:xpath, "//*[@id='my-top-submit-input']").click
 $driver.switch_to.alert.dismiss
end


Then(/^Verify display search result$/)do
  item = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'QA Engineer Search')]").displayed?
 assert(item = "QA Engineer Search","Error: name is checked by default!")
  puts "done"
 end


#5 @first5 T45666

Then(/^Click on Messaging Home button$/) do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Messaging Home')]").click
end

Then(/^Verify Messaging Home button displayed$/)do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Latest Sent Items')]").displayed?
 assert(element = "Latest Sent Items","Error: name is checked by default!")
end


#6 T45338

Then(/^Click on Disputes$/) do
 element = $driver.find_element(:xpath, "//*[@class='widget-container widget_text']//*[contains(text(),'Disputes')]").click
end


# Then(/^type comment into Comment for closing this dispute field$/) do
#  element = $driver.find_element(:xpath, "//textarea [@name='admin_comment']").send keys
# end

Then(/^Type "([^"]*)" into Comment for closing this dispute field$/) do |th|
 element = $driver.find_element(:xpath, "//textarea[@name='admin_comment']").send_keys th
end


Then(/^Click Close button$/) do
 element = $driver.find_element(:xpath, "//input[@type='submit'][@value='Close']").click
end


#7 T46561

# Then(/^Click on Disputes$/) do
#  element = $driver.find_element(:xpath, "//*[@class='widget-container widget_text']//*[contains(text(),'Disputes')]").click
# end

# Then(/^Type "([^"]*)" into Comment for closing this dispute field$/) do |th|
#  element = $driver.find_element(:xpath, "//textarea[@name='admin_comment']").send_keys th
# end
Then(/^Click Disputes$/) do
 element = $driver.find_element(:xpath, "//*[@class='widget-container widget_text']//*[contains(text(),'Disputes')]").click
end

Then(/^Type "([^"]*)" into$/) do |dis|
 element = $driver.find_element(:xpath, "//textarea[@class='disput_comment form-control']").send_keys dis
end

Then(/^Click on Create Dispute button$/) do
 element = $driver.find_element(:xpath, "//input[@type='submit'][@value='Create Dispute']").click
end

Then(/^Verify Dispute Created highlights in green$/) do
 name= $driver.find_element(:xpath, "//*[@class='saved_thing'][contains(text(),'Dispute created.')]").text
 assert(name = "Latest Sent Items","Error: name is checked by default!")
end


#8 T45953 Verify that the Project Owner can repost a closed project

Then(/^Click the Repost project button in My Latest Closed Projects$/) do
 element = $driver.find_element(:xpath, "//*[@class='green_btn old_mm_k'][contains(text(),'Repost Project')]")
end

Then(/^Click on Publish Project button at the bottom of the page$/) do
 element = $driver.find_element(:xpath, "//*[@type=ssubmit'][value='Publish Project']").click
end





#9 T45721


Then(/^Click PERSONAL INFO link from MY ACCOUNT menu$/) do
 element = $driver.find_element(:xpath, "//*[@class='widget-container widget_text']//*[contains(text(),'Personal Info')]").click
end


Then(/^Click on country and choose other at dropdown list$/) do
 element = $driver.find_element(:xpath, "//*[@class='form-control'][@name='user_city']").click
 element = $driver.find_element(:xpath, "//*[@class='form-control']//*[@value='Cupertino']").click
end

Then(/^Click Save$/) do
 element = $driver.find_element(:xpath, "//input[@type='submit'][@value='Save']").click
end

#10 T45725  Verify the copyright information on "Project Search" page.


Then(/^Verify the copyright information on Project Search page$/) do
 element = $driver.find_element(:xpath, "//*[contains(text(),'Copyright')]")
 assert(element = "Copyright","Error: name is checked by default!")
end


#11 T46368 negative

Given(/^Navigate to home page$/) do
 $driver.get "https://test.bidqa.com/wp-login.php"
 $driver.manage.window.maximize
end

Then(/^Click support link in the menu bar$/) do
 element = $driver.find_element(:xpath, "//*[text()='Support']").click
end

Then(/^Click Send button$/) do
 element = $driver.find_element(:xpath, "//input[@type='submit'][@value='Send']").click
end

#12 T45344

Then(/^Click the Disputes$/) do
 element = $driver.find_element(:xpath, "//*[@class='has-sub']//*[contains(text(),'My Account')]")
  $driver.mouse.move_to subcat
  subcat = $driver.find_element(:xpath, "//*[@class='has-sub']//*[contains(text(),'Disputes')]").click
end

Then(/^Select defendant from drop down list$/) do
 element = $driver.find_element(:xpath, "//select[@name='defendant']").click
 element = $driver.find_element(:xpath, "//*[@name='defendant']//*[contains(text(),'First Project - kids7')]").click
end

Then(/^Verify Error message You cannot leave the dispute comment blank! appears$/) do
 p element = $driver.find_element(:xpath, "//*[text()='You cannot leave the dispute comment blank!']").text
 #assert(element = "You cannot leave the dispute comment blank!","Error: name is checked by default!")
end


#13


Then(/^Click on Finances link$/) do
 element = $driver.find_element(:xpath, "//*[@id='my-account-admin-menu']//*[text()= 'Finances']").click
end


Then(/^Verify Pending Withdrawals appears$/) do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Pending Withdrawals')]"). displayed?
 assert(element = "Pending Withdrawals","Error: name is checked by default!")
end


#14

Then(/^Verify user can see the heading Finances$/) do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Finances')]"). displayed?
 assert(element = "Finances","Error: name is checked by default!")
end



#15

Then(/^Click on Withdraw Money$/) do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Withdraw Money')]").click
end


Then(/^Verify Rejected Withdrawals displayed$/) do
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Rejected Withdrawals')]").displayed?
 assert(element = "Rejected Withdrawals","Error: name is checked by default!")
end


#16

Then(/^Click on Send New Message button$/)do
  sleep 5
 element = $driver.find_element(:xpath, "//*[@class='my_box3']//*[contains(text(),'Send New Message')]").click
  sleep 5
end


# Then(/^Enter Mila$/) do
#  $driver.find_element(:xpath, "//input[@id='to_as']").send_keys "Mila"
# end

Then(/^Enter Subject$/) do
 $driver.find_element(:xpath, "//input[@id='subject_a']").send_keys "hi"
end


# Then(/^Enter message$/) do
#   $driver.switch_to.frame "message_a_ifr"
#   $driver.find_element(:xpath, "//*[@id='tinymce']/p").send_keys("Hello")
#  $driver.switch_to.default_content
# end



Then(/^Click Send Message$/) do
element = $driver.find_element(:xpath, "//*[@type='submit'][@value='Send Message']").click
$driver.switch_to.alert.dismiss
end


# #extra

Given(/^Open home page$/) do
 $driver.get "https://test.bidqa.com/wp-login.php"
 $driver.manage.window.maximize
end

Then(/^If user Loged Out$/) do
 element = $driver.find_elements(:xpath, "//*[text()='Log In']")
 if element.count > 0
   element[0].click
   puts "done"
 end
end



#17

Then(/^Verify What do you want to do appears$/) do
 element = $driver.find_element(:xpath, "//*[text()='What do you want to do ?']").displayed?

end

#18 T45585


Then(/^Click menu QA Engineer Search$/) do
 element = $driver.find_element(:xpath, "//*[text()='QA Engineer Search']").click
end

# Then(/^Click on the ([^"]*)$/) do |avatar|
# element = $driver.find_element(:xpath, "(//*[@id='content']//*[@alt='avatar-user'])['#{avatar}']").click
#
# end



Then(/^Click on the ([^"]*)$/) do |ava|
 element = $driver.find_element(:xpath, "(//*[@class='my_box3']//*[@alt='avatar-user'])['#{ava}']").click
end


Then(/^Verify open ([^"]*) page related to that image displayed$/) do |arg|
 element = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'#{arg}')]").displayed?
end


#19 T45528

Then(/^Click Log In button$/) do
 element = $driver.find_element(:xpath, "//*[text()='Log In']").click
end

Then(/^Verify Log In page is open$/) do
  element = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'Login - BidQA')]").displayed?
end



#20 T45514

Then(/^Click Logo button$/) do
  element = $driver.find_element(:xpath, "//img[@id='logo']").click
end

Then(/^Verify Featured Projects of the Day page is open$/) do
  element = $driver.find_element(:xpath, "//*[text()='Featured Projects of the Day']").displayed?
  assert(element = "Featured Projects of the Day","Error: name is checked by default!")
end


#21

Then(/^Enter valid email address to PayPal Email field$/) do
  element = $driver.find_element(:xpath, "//*[@name='paypal_email']").send_keys 'mluna07-buyer@gmail.com'
end


#22


Then(/^Verify Pending Escrow Outgoing Payments appears$/) do
 element = $driver.find_element(:xpath, "//*[text()='Pending Escrow Outgoing Payments']").displayed?
 assert(element = "Pending Escrow Outgoing Payments","Error: name is checked by default!")
end

#23

Then(/^Attach files$/) do
 $driver.find_element(:xpath, "//*[@id='file_instant']").send_keys("/Users/Mila/Desktop/Screen Shot 2016-05-25 at 11.10.01 PM")
end

#24

Then(/^Enter a "([^"]*)"$/) do |name|
 $driver.find_element(:xpath, "//input[@id='to_as']").send_keys "#{name}"
end

Then(/^Enter "([^"]*)"$/) do |mess|
 $driver.switch_to.frame "message_a_ifr"
 $driver.find_element(:xpath, "//*[@id='tinymce']/p").send_keys "#{mess}"
 $driver.switch_to.default_content
end



Then(/^Verify message msg to user has been sent is appears$/) do
 element = $driver.find_element(:xpath, "//*[@id='content']//*[contains(text(),'Your message to user')]").displayed?
 #assert(element = "Your message to user","Error: name is checked by default!")
end

#25

Then(/^Click "([^"]*)"$/) do |sent|
  $driver.find_element(:xpath, "//*[@id='content']//*[text()='#{sent}']").click
end


Then(/^Click "([^"]*)" button$/) do |del|
 $driver.find_element(:xpath, "//*[@id='content']//*[text()='#{del}']").click
end

Then(/^Click on "([^"]*)"$/) do |compl|
 $driver.find_element(:xpath, "//*[@id='content']//*[text()='#{compl}']").click
end

Then(/^Verify Private Messages: "([^"]*)"$/) do |conf|
 p name= $driver.find_element(:xpath, "//*[@class='box_title'][contains(text(),'#{conf}')]").displayed?
 #assert(name = "#{conf}","Error: element is checked by default!")
end

#26
Then(/^Click "([^"]*)"\.$/) do |inb|
 $driver.find_element(:xpath, "//*[@id='content']//*[contains(text(),'#{inb}')]").click
end

Then(/^Verify page Inbox is open$/) do
 element = $driver.find_element(:xpath, "//*[text()='Private Messages: Inbox']").displayed?
 assert(name = "Private Messages: Inbox","Error: element is checked by default!")
end
 #29
Then(/^Click the "([^"]*)" button$/) do |read|
 $driver.find_element(:xpath,"(//*[@class='box_content']//*[text()='#{read}'])[1]").click
end


Then(/^Verify message is open$/) do
 element = $driver.find_element(:xpath, "//*[@class='box_title'][contains(text(),'Read Message')]").displayed?
  assert(name = "Read Message", "Error:element is checked by default")
end

#30
Then(/^Click Replay button$/) do
 $driver.find_element(:xpath, "//*[text()='Reply']").click
end


Then(/^Click on Inbox$/) do
 $driver.find_element(:xpath, "//*[@id='content']//*[contains(text(),'Inbox')]").click
end

#31

# Then(/^Verify unread message has bold font$/) do
#  element= $driver.find_elements(:xpath, ("//*[@class='success'])[2]").text
#   #assert(elements = "success", "Error:element is checked by default")
# end

#32

#33
Then(/^Attach a files$/) do
 $driver.find_element(:xpath, "//*[@id='file_instant']").send_keys("/Users/Mila/Desktop/selenium/Untitled 2.pages")
end


Then(/^Click the "([^"]*)"$/) do |delete|
 $driver.find_element(:xpath, "//*[text()='#{delete}']").click
end

Then(/^Verify text File deleted$/) do
 $driver.find_element(:xpath, "//*[@name='file_instant[]']").displayed?
  assert(elements = "file_instant[]", "Error:element is checked by default")
end

#34


# Then(/^Attach the "([^"]*)"$/) do |img|
#  $driver.find_element(:xpath, "//*[@id='file_instant']").send_keys("#{img}")
# end

Then(/^Attach the img files$/) do
 $driver.find_element(:xpath, "//*[@id='file_instant']").send_keys("/Users/Mila/Desktop/download.jpeg")
end

#35

Then(/^Click "([^"]*)" link$/) do |supp|
 $driver.find_element(:xpath, "//*[text()='#{supp}']").click
end

Then(/^Verify Your Name text field$/) do
 $driver.find_element(:xpath, "//*[@name='your-name']").displayed?
  assert(element = "your-name", "Error:element is checked by default")
end

Then(/^Verify Your Email text field$/) do
 $driver.find_element(:xpath, "//*[@name='your-email']").displayed?
 assert(element = "your-email", "Error:element is checked by default")
end

Then(/^Verify Subject required text field$/) do
 $driver.find_element(:xpath, "//*[@name='your-subject']").displayed?
  assert(element = "your-subject", "Error:element is cheked by default")
end

Then(/^Verify Your massage required text field;$/) do
 $driver.find_element(:xpath, "//*[@name='your-message']").displayed?
 assert(element = "your-message", "Error:element is cheked by default")
end

Then(/^Verify "([^"]*)" button$/) do |send|
 $driver.find_element(:xpath, "//*[@value='#{send}']").displayed?
 assert(element = "#{send}", "Error:element is cheked by default")
end

#36

Then(/^Verify message "([^"]*)" in the top left corner$/) do |wel|
 $driver.find_element(:xpath, "//*[@class='#{wel}']").displayed?
 assert(element = "#{wel}", "Error:element is cheked by default")
end


#37
Then(/^Verify message "([^"]*)" is displayed$/) do |you|
 $driver.find_element(:xpath, "//*[@class='jetmenu blue']//*[contains(text(),'#{you}')]").displayed?
 assert(element = "#{you}", "Error:element is cheked by default")
end

#38
# Then(/^Verify Error mess is displayed$/) do
#  $driver.find_element(:xpath, "//*[text()='ERROR']").displayed?
#  assert(element = "ERROR", "Error:element is cheked by default")
# end

# #40

Then(/^Verify "([^"]*)" mess is displayed$/) do |error|
 $driver.find_element(:xpath, "//*[text()='#{error}']").displayed?
 assert(element = "#{error}", "Error:element is cheked by default")
end

#42

Then(/^Click a "([^"]*)"$/) do |lost|
 $driver.find_element(:xpath, "//*[text()='#{lost}']").click
end

Then(/^Verify message displays Please enter your information here\.$/) do
$driver.find_element(:xpath, "//*[@name='lostpass']//*[contains(text(),'Please enter your information here')]").displayed?
  assert(element = "Please enter your information here", "Error:element is cheked by default")
end

#43


Then(/^Verify Logo button present$/) do
  $driver.find_element(:xpath, "//*[@id='logo']").displayed?
  assert(element = "logo", "Error:element is cheked by default")
end

#44

Then(/^Click on "([^"]*)" link$/) do |regi|
 $driver.find_element(:xpath, "//*[text()='#{regi}']").click
end

Then(/^Click "([^"]*)" but$/) do |log|
  $driver.find_element(:xpath, "//*[@id='#{log}']").click
  #assert(element= "#{log}", "Error:element is cheked by default")
end

Then(/^Verify link redirected to home page$/) do
  $driver.find_element(:xpath, "//*[text()='Featured Projects of the Day']").displayed?
  assert(element = "Featured Projects of the Day","Error: name is checked by default!")
 end

#extra1

# Given(/^Open the home page$/) do
#  $driver.get "http://www.bestbuy.com/"
#  $driver.manage.window.maximize
# end
#
#
# Then(/^Click "([^"]*)" on$/) do |sing|
#  $driver.find_element(:xpath, "//*[@class='profile-wrap js-navitem main-nav js-forceexempt']//*[text()= '#{sing}']").click
# end

#45

Then(/^Click "([^"]*)" button\.$/) do |h|
 $driver.find_element(:xpath, "//*[contains(text(),'#{h}')]").click
end
#46
#47
Then(/^Click at the "([^"]*)"$/) do |x|
 $driver.find_element(:xpath, "//*[text()='#{x}']").click
end

Then(/^Verify link redirected to login page$/) do
 $driver.find_element(:xpath, "//*[contains(text(),'Login - BidQA')]").displayed?
  assert(element = "Login - BidQA", "Error: named is checked by default!")
end


Then(/^Click on the "([^"]*)" link$/) do |proj|
 $driver.find_element(:xpath, "//*[@id='my-account-admin-menu_buyer']//*[contains(text(),'#{proj}')]").click
end

Then(/^Verify link redirected to won page$/) do
 $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'Projects ')]").displayed?
 assert(element = "Projects", "Error: named is checked by default!")
end

#50
Then(/^Select Keep me logged in radio button$/) do
 $driver.find_element(:xpath, "//input[@id='rememberme']").click
end

Then(/^Close browser and open again$/) do
  $driver.quit
  $driver = Selenium::WebDriver.for :firefox
  $driver.get "https://test.bidqa.com/wp-login.php"
end

Then(/^Verify user is loged in$/) do
 $driver.find_element(:xpath, "//*[@class='mm_inn']//*[contains(text(),'My Account')]").displayed?
 assert(element = "My Account", "Error: named is checked by default!")
end

#52


Then(/^Verify "([^"]*)"page open$/) do |regist|
 $driver.find_element(:xpath, "//*[contains(text(),'#{regist}')]").displayed?
assert(element = "#{regist}", "Error: named is cheking by default")
end

#54
Given(/^Open Hhome page$/) do
 $driver.get "https://test.bidqa.com/"
end

Then(/^Click any "([^"]*)" highlighted in blue$/) do |first|
 $driver.find_element(:xpath, "//*[@class='widget-container latest-posted-jobs-big']//*[contains(text(),'#{first}')]").click
end


Then(/^Verify "([^"]*)" page open$/) do |text|
 $driver.find_element(:xpath, "//*[@class='mm_inn mm_inn21'and contains(text(),'#{text}')]").displayed?
  assert(element = "#{text}", "Error: named is cheking by default")
end

#55
Then(/^Click on the "([^"]*)" highlighted in blue$/) do |avat|
 $driver.find_element(:xpath, "//*[@class='widget-container latest-posted-jobs-big']//*[contains(text(),'#{avat}')]").click
 end

Then(/^Verify "([^"]*)" page is open$/) do |profile|
 $driver.find_element(:xpath, "//*[@class='mm_inn' and contains(text(),'#{profile}')]").displayed?
 assert(element = "#{profile}", "Error: named is cheking by default")
end