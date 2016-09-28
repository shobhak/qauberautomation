#importing WebDriver
require "selenium-webdriver";

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify the hamburger icon is functional https://bidqa.testrail.net/index.php?/tests/view/76670

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

#Verifying element exists
driver.find_element(:xpath, "//a[@class='hidden-xs']").click;
sleep(2)

#Veryfying element is functional and side menu is minimized.
driver.find_element(:xpath, "//body[@class='layout-fixed aside-collapsed']");

#Prints "Passed" if no error.
puts "Passed";

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;

