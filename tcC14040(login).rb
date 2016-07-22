#launch WebDriver
require "selenium-webdriver"
require 'logger'
require 'fileutils'

tc_title = "TITLE: Verify that user can add report."
tc_number = "C13760"
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

#To confirm that the URL has been loaded and make a record about it in a log file.
def wait_element(path, driver)
  wait = Selenium::WebDriver::Wait.new(:timeout => 10) 
  input = wait.until {
    element = driver.find_element(:xpath, path)
    element if element.displayed?
  }
  return input
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
fill_to_log("html/body/div[2]/div/div/div[1]/div[2]/a", "'Open URL'",driver, log)

#Enter valid email
wait_element(".//*[@id='exampleInputEmail1']", driver).send_keys("knadme+x@gmail.com")
fill_to_log(".//*[@id='exampleInputEmail1']", "'Enter valid email'", driver, log)

#Enter password in the 'Password' field.
wait_element(".//*[@id='exampleInputPassword1']", driver).send_keys("123456")
fill_to_log(".//*[@id='exampleInputPassword1']", "'Enter password in the 'Password' field.'", driver, log)

sleep 3 #Wait until the desired page element will be loaded 

#Click 'Login' button.
fill_to_log("html/body/div[2]/div/div/div[1]/div[2]/form/button", "'Click 'Login' button.'", driver, log)
wait_element("html/body/div[2]/div/div/div[1]/div[2]/form/button", driver).click

sleep 3 #Wait until the desired page element will be loaded 

#Check for Expected Result if message text present. Result of test case.
wait = Selenium::WebDriver::Wait.new(:timeout => 10)
message = driver.find_element(:xpath,"/html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a") #Get the text 
log.debug "__________________TEST PASSED: '#{message.text}' text is present" if wait.until {
    driver.find_element(:xpath => "/html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a").displayed?
}

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

