require_relative '../support/hooks'

Given(/^I navigate to login page$/) do
  $driver.get "https://test.bidqa.com/wp-login.php"
end



When(/^I log in as a QA engineer input "([^"]*)", "([^"]*)"$/) do |login, psw|
  $driver.find_element(:xpath, "//input[@id='log']").send_keys login
  $driver.find_element(:xpath, "//input[@id='login_password']").send_keys psw
  $driver.find_element(:xpath, "//input[@id='submits']"). click
end


Then(/^I go to My Account$/) do
  $driver.get "https://test.bidqa.com/my-account/personal-information/"
end


Then(/^I upload image "([^"]*)"$/) do |arg|
  $driver.find_element(:xpath, "//*[@type='file']").send_keys arg
end

Then(/^I click save button$/) do
  $driver.find_element(:xpath, "//*[contains (@value,'Save')]"). click
end

And(/^avatar image should be present$/) do
  $driver.find_element(:xpath, ".//*[@id='personal_information_form']/div[1]/div/ul/div[10]/div/img").displayed?
  sleep 5
end

Given(/^I navigate to main page$/) do
  $driver.get "https://test.bidqa.com"
end


When(/^I Click BidQA logo at upper left corner$/) do
  $driver.find_element(:xpath, "//*[@id='logo']"). click
end


Then(/^I Observe that homepage will refresh$/) do
  $driver.find_element(:xpath, "//*[contains(text(), 'BidQA | Marketplace for available QA Professionals around a globe')]").displayed?
end

Then(/^I verify user name and email field$/) do
  #p $driver.find_element(:xpath, "//*[@name='new_user_name']").text
  p user_name = $driver.find_element(:xpath, "//*[@name='new_user_name']").attribute("value")
  assert(user_name == "denisshirokikh", "User name is not correct.
Name found: #{user_name}. Expected: denisshirokikh")
  p user_email = $driver.find_element(:xpath, "//*[@name='new_user_email']").attribute("value")
  assert(user_email == "denisshirokikh@gmail.com", "User email is not correct.
Email found: #{user_email}. Expected: denisshirokikh@gmail.com")

  # assert($driver.find_element(:xpath, "//*[@name='new_user_name']").text.contains? "denisshirokikh")
  # assert($driver.find_element(:xpath, "//*[@name='new_user_email']").text == "denisshirokikh@gmail.com")



end

Then(/^I enter "([^"]*)" into password field $/) do |newpsw|

end



And(/^I click save$/) do
  $driver.find_element(:xpath, "//*[contains (@value,'Save')]"). click
end

Then(/^I navigate QA eng Search$/) do
  $driver.find_element(:xpath, "//*[@class='jetmenu blue']//*[contains(text(), 'QA Engineer Search')]").click
end

Then(/^I enter "([^"]*)" into password field$/) do |newpsw|
  $driver.find_element(:xpath, "//input[@name='password']").send_keys newpsw
  $driver.find_element(:xpath, "//input[@name='reppassword']").send_keys newpsw
end


Then(/^I click on avatar$/) do
  $driver.find_element(:xpath, "//*[@class='avatar-posted-by-username'][contains(text(),'090809')]").click
end

Then(/^I verify open exact page$/) do
 avatar = $driver.find_element(:xpath, "//*[@class='mm_inn'][contains(text(),'090809')]").text
 assert(avatar.include?("090809"), "Avatar is not correct! Expected:090809. Found: #{avatar}")
end

And(/^Then verify "([^"]*)" on the page$/) do |string|
  sleep 6
  get_text = $driver.find_element(:xpath, "//*[@class='tp-splitted tp-charsplit']//*[contains(text(),'W')]").text
  p get_text
  p string
  #assert(get_text.include?(string), "ERROR: #{string} is not displayed ")
end



Then(/^Click "([^"]*)" in upper right corner of screen$/) do |button|
  $driver.find_element(:xpath, "//*[@id='cssmenu']//*[text()='#{button}']").click
end



Then(/^I observe that Login page opens$/) do
  $driver.find_element(:xpath, "//form[@id='loginform']").displayed?
end


Then(/^I observe Join Us blue button is present$/) do
  $driver.find_element(:xpath, "//*[@id='slide-5-layer-3']").displayed?
end

Then(/^Observe the copyright information$/) do
  $driver.find_element(:xpath, ".//*[@id='site-info-left']/h3").displayed?
end


Then(/^I go to "([^"]*)"$/) do |abc|
  $driver.find_element(:xpath,"//*[@id='right-sidebar']//*[contains(text(),'#{abc}')]").click
end

Then(/^I input "([^"]*)" amount$/) do |amount|
  $driver.find_element(:xpath,"//input[@id='amount']").send_keys amount
  #assert(amount < "25", "Amount is not correct. Name found: #{amount}. Expected: amount should be > 25")
end

Then(/^Log in as a Project Owner input "([^"]*)", "([^"]*)"$/) do |pologin, popsw|
  $driver.find_element(:xpath, "//input[@id='log']").send_keys pologin
  $driver.find_element(:xpath, "//input[@id='login_password']").send_keys popsw
  $driver.find_element(:xpath, "//input[@id='submits']"). click
end


Then(/^Observe the page element "([^"]*)" should be present$/) do |heading|
  $driver.find_element(:xpath,"//*[@id='content']//*[contains(text(), '#{heading}')]").displayed?
end