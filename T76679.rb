#importing WebDriver
require "selenium-webdriver";

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify that the "Logout" on the menu bar is function https://bidqa.testrail.net/index.php?/tests/view/76679

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

#Logout
driver.find_element(:xpath, "//a[@ng-click='app.logout()']").click;
sleep(2)

#Verifying if user is redirected to the login page.
if (driver.find_element(:xpath, "//p[contains(.,'SIGN IN TO CONTINUE.')]")).displayed?
  puts "Passed"
else
  puts "Failed"
end

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;