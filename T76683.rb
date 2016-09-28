#importing WebDriver
require "selenium-webdriver";

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify "Next" and " Previous" Buttons are functional. https://bidqa.testrail.net/index.php?/tests/view/76683

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

#Navigate to "Users" page
driver.find_element(:xpath, "//span[contains(.,'Users')]").click;
sleep(1)

#Navigate to the next 'User' page
driver.find_element(:xpath, "//a[@ng-click='setCurrent(pagination.current + 1)']").click;

#Verifying if browser navigates to page '2'
if (driver.find_element(:xpath, "//a[contains(.,'2')]")).displayed?
  puts "Able to navigate to the next page"
else
  puts "Unable to navigate to the next page"
end

#Navigate to the previous 'User' page
driver.find_element(:xpath, "//a[@ng-click='setCurrent(pagination.current - 1)']").click;

#Verifying if browser navigates to page '1'
if (driver.find_element(:xpath, "//a[contains(.,'1')]")).displayed?
  puts "Able to navigate to the previous page"
else
  puts "Unable to navigate to the previous page"
end

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;









