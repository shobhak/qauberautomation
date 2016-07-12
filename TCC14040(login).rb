#launch WebDriver
require "selenium-webdriver"

#open browser
driver = Selenium::WebDriver.for:chrome

#info about test case.
puts "C14040 Title: Verify that user can log in with valid credentials."

#open url
driver.navigate.to "http://qabidder.net/fits-alfa/#/page/login"

#Enter valid email
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded
input = wait.until {
    element = driver.find_element(:xpath, ".//*[@id='exampleInputEmail1']")
    element if element.displayed?
}
input.send_keys("knadme+x@gmail.com")

#Enter password in the 'Password' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, ".//*[@id='exampleInputPassword1']")
    element if element.displayed?
}
input.send_keys("123456")

sleep 3 #Wait until the desired page element will be loaded 

#Click 'Login' button.
driver.find_element(:xpath => "html/body/div[2]/div/div/div[1]/div[2]/form/button").click

sleep 3 #Wait until the desired page element will be loaded 

#Check for Expected Result if error message text present. Result of test case.
message = driver.find_element(:xpath,"html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a") #Get the text of error message
puts "Test Passed: error message '#{message.text}' is present" if wait.until {
    driver.find_element(:xpath => "html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a").displayed?
}

#info about system
info = driver.execute_script("return navigator.userAgent;")
puts "info about system: " + info

#Time
time = Time.now
puts "Time: " + time.to_s #convert time to string 

#Close the browser
driver.quit