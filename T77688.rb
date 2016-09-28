#importing WebDriver
require "selenium-webdriver"

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome

#TC Name: Verify that Super Admin can delete User https://bidqa.testrail.net/index.php?/tests/view/77688
#Precondition: There is only one user on the "User List".

#Navigating to website
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(4)

#Entering text in Email field
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");

#Entering text in the Password field
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");

#Clicking "Submit"
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

# Navigating to "Users" page
driver.find_element(:xpath, "//span[contains(.,'Users')]").click;
sleep(2)

#Clicking on user's configuration button.
driver.find_element(:xpath, "//em[@class='icon-settings ng-scope']").click;
sleep(1)

#Deleting a user
driver.find_element(:xpath, "//button[contains(.,'Delete User')]").click;
sleep(1)

#confirming deletion
driver.find_element(:xpath, "//button[contains(.,'Delete')]").click;

#Output of result. Passed if no existing users.
if driver.find_element(:xpath, "//em[@ng-click='openUserSettings(user)']").displayed?;
  puts "Failed"
else
  puts "Passed"
end;

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;

