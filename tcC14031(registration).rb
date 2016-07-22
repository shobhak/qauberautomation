#launch WebDriver
require "selenium-webdriver"
require 'logger'
require 'fileutils'

tc_title = "TITLE: Verify that user can log in with valid credentials."
tc_number = "C14040"
URL = "http://qabidder.net/fits-alfa/#/page/login"

begin
# Write method that will fill info into a log file
def fill_to_log(path, message, driver, log)
  wait = Selenium::WebDriver::Wait.new(:timeout => 10) 
  input = wait.until {
    element = driver.find_element(:xpath, path)
    element if element.displayed?
  }
  log.debug "Step #{message} pass"
end

#Create log file and save info about test case. ('%m.%d.%Y.%I.%M.%S.%p')
time = Time.now #Time
FileUtils::mkdir_p "logs/logs#{time.strftime('%m.%d.%Y')}" #create directory for logs
FileUtils::mkdir_p "logs/screenshort#{time.strftime('%m.%d.%Y')}" #create directory for screenshots
name_of_log = "log#{tc_number}_#{time.strftime('%m.%d.%Y.%I.%M.%S.%p')}.log"
log = Logger.new("logs/logs#{time.strftime('%m.%d.%Y')}/#{name_of_log}")
log.debug time.strftime("_______________________Run on %m/%d/%Y at %I:%M:%S%p")
log.debug "#{tc_number} #{tc_title}" #info about test case.

#open browser
driver = Selenium::WebDriver.for:chrome

#open url and save info
driver.navigate.to URL

#To confirm that the URL has been loaded and make a record about it in a log file.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div[2]/p[1]")
    element if element.text.include?('SIGN IN TO CONTINUE.')
}
fill_to_log("html/body/div[2]/div/div/div[1]/div[2]/a", "'Open URL'",driver, log)

sleep 3 #Wait until the desired page element will be loaded

#Click 'Register Now'. 
driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div[2]/a").click

fill_to_log("html/body/div[2]/div/div/div[1]/div[2]/a", "'Click Register Now'",driver, log)


#Enter name in the 'Name' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/input")
    element if element.displayed?
}
input.send_keys("Name123")

fill_to_log("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/input", "'Enter name in the 'Name' field'",driver, log)

#Enter not registered email in the 'Email address' field.
q=rand(100000000)# The variable that selects a number from 1 to 100000000 randomly. This variable will be used to making new unregistered email every time.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/input")
    element if element.displayed?
}
input.send_keys("knadme+#{q}@email.com") #Every time you run this test case new email address will be generated. Probability repeat email address less than 0,00000001%

fill_to_log("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/input", "'Enter not registered email in the 'Email address' field'",driver, log)


#Enter password in the 'Password' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, ".//*[@id='id-password']")
    element if element.displayed?
}
input.send_keys("Password")

fill_to_log(".//*[@id='id-password']", "'Enter password in the 'Password' field'",driver, log)


#Retype password in the 'Retype Password' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[4]/input")
    element if element.displayed?
}
input.send_keys("Password")

fill_to_log("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[4]/input", "'Retype password in the 'Retype Password' field.'", driver, log)


sleep 3 #Wait until the desired page element will be loaded 

#Click 'Continue registration' button.
driver.find_element(:xpath => "html/body/div[2]/div/div/div[1]/div/div[2]/form/button").click

fill_to_log("/html/body/div[2]/div/div/div[2]/div[1]/h4", "'Click 'Continue registration' button to redirect on 'Company registration' page'", driver, log)

#Type Company name in the 'Company name' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/input")
    element if element.displayed?
}
input.send_keys("Romashka#{q}") #Every time you run this test case new Company name will be generated.

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/input", "'Type Company name in the 'Company name' field'", driver, log)

#Type ZIP in the 'ZIP' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input")
    element if element.displayed?
}
input.send_keys("94010")

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input", "'Type ZIP in the 'ZIP' field.'", driver, log)


#Type Address 1 in the 'Address 1' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/input")
    element if element.displayed?
}
input.send_keys("24 Example Ave")

fill_to_log("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/input", "'Type Address 1 in the 'Address 1' field.'", driver, log)


#Type Address 2 in the 'Address 2' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")
    element if element.displayed?
}
input.send_keys("Unit-1")

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input", "'Type Address 2 in the 'Address 2 ' field.'", driver, log)


#Type City in the 'City' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/input")
    element if element.displayed?
}
input.send_keys("San Francisco")

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/input", "'Type City in the 'City' field.'", driver, log)

#Type Phone in the 'Phone' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/input")
    element if element.displayed?
}
input.send_keys("4155555555")

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/input", "'Type Phone in the 'Phone' field.'", driver, log)


#Type email in the 'Email' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/div/input")
    element if element.displayed?
}
input.send_keys("knadme+#{q}@email.com")

fill_to_log("html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/div/input", "'Type email in the 'Email' field'.", driver, log)

sleep 3 #Wait until the desired page element will be loaded 

#Click 'Finish registration' button.
driver.find_element(:xpath => "html/body/div[2]/div/div/div[2]/div[3]/button").click

fill_to_log("html/body/div[2]/div/div/div[2]/div[3]/button", "'Click 'Finish registration' button'", driver, log)

sleep 3 #Wait until the desired page element will be loaded

#Check for Expected Result if "Registration successful." text present. Result of test case.
if (wait = Selenium::WebDriver::Wait.new(:timeout => 10) 
message = driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div") #Get the text
log.debug "__________________TEST PASSED: '#{message.text}' text is present" if wait.until {
    driver.find_element(:xpath => "/html/body/div[2]/div/div/div[1]/div").text.include?('Registration successful')
})
else log.debug "_______________Test FAIL!!!"
end

#Make a screenshot
driver.save_screenshot("logs/screenshort#{time.strftime('%m.%d.%Y')}/#{tc_number}_#{time.strftime('%m.%d.%Y.%I.%M.%S.%p')}.png") 

#info about system
info = driver.execute_script("return navigator.userAgent;")
log.debug  "INFO ABOUT SYSTEM: " + info

#Close the browser
driver.quit

#Save error message (if test case fail) into the log file
rescue
log.debug "Test script FAIL!!!!!!!!! because of________ #{$!}" 
puts "Test script FAIL!!!!!!!!! because of________ #{$!}"
info = driver.execute_script("return navigator.userAgent;")
log.debug  "INFO ABOUT SYSTEM: " + info
driver.save_screenshot("logs/screenshort#{time.strftime('%m.%d.%Y')}/FAIL____#{tc_number}_#{time.strftime('%m.%d.%Y.%I.%M.%S.%p')}.png") 
File.rename("logs/logs#{time.strftime('%m.%d.%Y')}/#{name_of_log}", "logs/logs#{time.strftime('%m.%d.%Y')}/FAIL_____#{name_of_log}")
driver.quit #Close the browser if test case fail
end