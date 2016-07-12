#launch WebDriver
require "selenium-webdriver"

#open browser
driver = Selenium::WebDriver.for:chrome

#info about test case.
puts "C14031 Title: Verify that user can register"

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


# Define the variable that selects a number from 1 to 100000000 randomly. This variable will be used to making new unregistered email every time.
q=rand(100000000)

#Enter not registered email in the 'Email address' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/input")
    element if element.displayed?
}
input.send_keys("knadme+#{q}@email.com") #Every time you run this test case new email address will be generated. Probability repeat email address less than 0,00000001%

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

#Type Company name in the 'Company name' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/input")
    element if element.displayed?
}
input.send_keys("Romashka#{q}") #Every time you run this test case new Company name will be generated.

#Type ZIP in the 'ZIP' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input")
    element if element.displayed?
}
input.send_keys("94010")


#Type Address 1 in the 'Address 1' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/input")
    element if element.displayed?
}
input.send_keys("24 Example Ave")

#Type Address 2 in the 'Address 2' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")
    element if element.displayed?
}
input.send_keys("Unit-1")


#Type City in the 'City' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/input")
    element if element.displayed?
}
input.send_keys("San Francisco")

#Type Phone in the 'Phone' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/input")
    element if element.displayed?
}
input.send_keys("4155555555")

#Type email in the 'Email' field.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
input = wait.until {
    element = driver.find_element(:xpath, "html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/div/input")
    element if element.displayed?
}
input.send_keys("knadme+#{q}@email.com")

sleep 3 #Wait until the desired page element will be loaded 

#Click 'Finish registration' button.
driver.find_element(:xpath => "html/body/div[2]/div/div/div[2]/div[3]/button").click

sleep 3 #Wait until the desired page element will be loaded 
#Check for Expected Result if "Registration successful." text present. Result of test case.
wait = Selenium::WebDriver::Wait.new(:timeout => 10) #Wait until the desired page element will be loaded 
message = driver.find_element(:xpath,"html/body/div[2]/div/div/div[1]/div") #Get the text
puts "Test Passed:'#{message.text}' text is present" if wait.until {
    driver.find_element(:xpath => "/html/body/div[2]/div/div/div[1]/div").text.include?('Registration successful')
}

#info about system
info = driver.execute_script("return navigator.userAgent;")
puts "info about system: " + info

#Time
time = Time.now
puts "Time: " + time.to_s #convert time to string 

#Close the browser
driver.quit