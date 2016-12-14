#launch WebDriver
require "selenium-webdriver"
require 'logger'
require 'fileutils'
require 'securerandom'

tc_title = "TITLE: Verify that 'View' button in Report is functional"
tc_number = "C14160"
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

#Check for logged in.
wait_element("/html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a", driver)
message = driver.find_element(:xpath,"/html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a") #Get the text 
fill_to_log("/html/body/div[2]/header/nav/div[2]/ul[2]/li[1]/a", "'User login, '#{message.text}' text is present'", driver, log)

# Click on "Add Report".
wait_element("html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span", driver).click
fill_to_log("html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span", "'Click on 'Add Report''", driver, log)

#enter 'First name'
random_name = SecureRandom.hex
wait_element("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[1]/div/div/input", driver).send_keys("#{random_name}")
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[1]/div/div/input", "'Enter 'First name''", driver, log)

# enter 'Last name'
wait_element("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[3]/div/div/input", driver).send_keys("Lastname")
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[1]/div[3]/div/div/input", "'Enter 'Last name''", driver, log)

# enter 'Date of birth'
wait_element("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[1]/div/div/p/input", driver).send_keys("21-July-1972")
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[1]/fieldset/div[2]/div[1]/div/div/p/input", "'Enter 'Date of birth''", driver, log)

sleep 3 #Wait until the desired page element will be loaded 

# Click on "Next".
wait_element("/html/body/div[2]/section/div/div/div/form/div/div[1]/ul/li/a", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[2]/fieldset/legend", "' Click on 'Next''", driver, log)

# Click on "Next".
wait_element("html/body/div[2]/section/div/div/div/form/div/div[2]/ul/li[2]/a", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[3]/fieldset/legend", "' Click on 'Next''", driver, log)

# Click on "Next".
wait_element("html/body/div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[4]/fieldset/legend", "' Click on 'Next''", driver, log)

# Check checkbox.
wait_element("html/body/div[2]/section/div/div/div/form/div/div[4]/fieldset/div[5]/div[1]/div/label/span", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[4]/fieldset/div[5]/div[1]/div/label/span", "' Check checkbox''", driver, log)

# Click on "Next".
wait_element("html/body/div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a/span", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[5]/fieldset/legend", "' Click on 'Next''", driver, log)

# Click on "Next".
wait_element("html/body/div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/legend", "' Click on 'Next''", driver, log)

# Click on "Next".
wait_element("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a/span", driver).click
fill_to_log("html/body/div[2]/section/div/div/div/form/div/div[7]/div/h1", "' Click on 'Next''", driver, log)

# Click on 'Commit report'.
wait_element("html/body/div[2]/section/div/div/div/form/div/div[7]/div/p[2]/a[2]", driver).click
fill_to_log("html/body/div[2]/section/div/h3", "'Click on 'Commit report''", driver, log)

# Enter Name in the search field
wait_element("html/body/div[2]/section/div/div/div/div[1]/input", driver).send_keys("#{random_name}")
if (wait_element("html/body/div[2]/section/div/div/div/div[1]/input", driver).attribute("class") == "form-control mb ng-untouched ng-valid ng-not-empty ng-dirty ng-valid-parse")
   fill_to_log("html/body/div[2]/section/div/div/div/div[1]/input", "'Enter Name in the search field''", driver, log)
else log.debug "Step 'Enter Name in the search field' FAIL"
end

#Check for Step 'Report has been found.
if (wait_element("/html/body/div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr/td/div/div/p", driver).text.include?("#{random_name}") == true)
 log.debug "Step 'Report has been found' pass"
else log.debug "Step 'Report has been found'  FAIL"
  driver.find_element(:xpath, "html/body/div[2]/section/div/div/div/form/div/div[6]")
end

# Click on 'View'.
wait_element("/html/body/div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr/td/div/div/a", driver).click
fill_to_log("/html/body/div[2]/section/div/div/div[2]/div[1]/div[1]/form/div[2]/div[2]/strong", "'Click on 'View''", driver, log)

#Check for Expected Result if message text present. Result of test case.
if (wait_element("/html/body/div[2]/section/div/div/div[2]/div[1]/div[1]/form/div[2]/div[2]/strong", driver).text.include?("#{random_name}") == true)
  log.debug "__________________TEST PASSED: '#{random_name}' text is present"
else log.debug "Step 'View report'  FAIL"
  driver.find_element(:xpath, "html/body/div[2]/section/div/div/div/form/div/div[6]")
  end

#Make a screenshot
driver.save_screenshot("logs/screenshort#{time.strftime('%m.%d.%Y')}/#{tc_number}_#{time.strftime('%m.%d.%Y.%I.%M.%S.%p')}.png") 

#info about system
info = driver.execute_script("return navigator.userAgent;")
log.debug  "INFO ABOUT SYSTEM: " + info

#Close the browser
driver.quit

rescue
#Close the browser + info about system if test case fail
log.debug "Test script FAIL!!!!!!!!! because of________ #{$!}" 
puts "Test script FAIL!!!!!!!!! because of________ #{$!}"
info = driver.execute_script("return navigator.userAgent;")
log.debug  "INFO ABOUT SYSTEM: " + info
driver.save_screenshot("logs/screenshort#{time.strftime('%m.%d.%Y')}/FAIL____#{tc_number}_#{time.strftime('%m.%d.%Y.%I.%M.%S.%p')}.png") 
File.rename("logs/logs#{time.strftime('%m.%d.%Y')}/#{name_of_log}", "logs/logs#{time.strftime('%m.%d.%Y')}/FAIL_____#{name_of_log}")
driver.quit #Close the browser if test case fail
end


