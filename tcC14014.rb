#launch WebDriver
require "selenium-webdriver"

#open browser
driver = Selenium::WebDriver.for:chrome

#info about test case.
puts "C14014 Title: Verify that the 'Register Now' button is functional"

#open url
driver.navigate.to "http://qabidder.net/fits-alfa/#/page/login"
sleep 3 #Wait until the desired page element will be loaded

#Click 'Register Now'. 
driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div[2]/a").click 

sleep 3 #Wait until the desired page element will be loaded 

#Check for Expected Result if "SIGNUP TO GET INSTANT ACCESS" text present. Result of test case.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
message = driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div/div[2]/p[1]") #Get the text
puts "Test Passed:'#{message.text}' text is present" if wait.until {
    driver.find_element(:xpath => "html/body/div[2]/div/div/div[1]/div/div[2]/p[1]").text.include?('SIGNUP TO GET INSTANT ACCESS')
}

#info about system
info = driver.execute_script("return navigator.userAgent;")
puts "info about system: " + info

#Time
time = Time.now
puts "Time: " + time.to_s #convert time to string 

#Close the browser
driver.quit