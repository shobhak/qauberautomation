#launch WebDriver
require "selenium-webdriver"

#open browser
driver = Selenium::WebDriver.for:chrome

#info about test case.
puts "C14036 Title: Verify that user can not register with blank 'E-mail' field."

#open url
driver.navigate.to "http://qabidder.net/fits-alfa/#/page/login"
sleep 3 #Wait until the desired page element will be loaded

#Click 'Register Now'. 
driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div[2]/a").click 

#Enter name in the 'Name' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/input")
    element if element.displayed?
}
input.send_keys("Name123")


#Enter password in the 'Password' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, ".//*[@id='id-password']")
    element if element.displayed?
}
input.send_keys("Password")

#Retype password in the 'Retype Password' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[4]/input")
    element if element.displayed?
}
input.send_keys("Password")

sleep 3 #Wait until the desired page element will be loaded 

#Click 'Continue registration' button.
driver.find_element(:xpath => "html/body/div[2]/div/div/div[1]/div/div[2]/form/button").click

sleep 3 #Wait until the desired page element will be loaded 

#Check for Expected Result if error message text present. Result of test case.
message = driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/span[2]") #Get the text of error message
puts "Test Passed: error message '#{message.text}' is present" if wait.until {
    driver.find_element(:xpath => "html/body/div[2]/div/div/div[1]/div").displayed?
}

#info about system
info = driver.execute_script("return navigator.userAgent;")
puts "info about system: " + info

#Time
time = Time.now
puts "Time: " + time.to_s #convert time to string 

#Close the browser
driver.quit