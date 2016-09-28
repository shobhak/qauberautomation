#importing WebDriver
require "selenium-webdriver";

#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify user can "Add Department" as Super Admin  https://bidqa.testrail.net/index.php?/tests/view/77373

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(3)

#Navigating to "Entities" page
driver.find_element(:xpath, "//span[contains(.,'Entities')]").click;
sleep(3)

#Clicking on organization name text-link
driver.find_element(:xpath, "//a[@ng-click='setCurrentEntity(entity.id)']").click;
sleep(2)

#Openning Department Form
driver.find_element(:xpath, "//button[@ng-click='openAddDepartmentForm()']").click;
sleep(1)

#Typing department name in the "Department Name" field.
driver.find_element(:xpath, "//input[@name='name']").send_keys("Automated Department Creation");
sleep(3)

#Submitting Department form
driver.find_element(:xpath, "//button[contains(.,'Create')]").click;
sleep(2)

#Verifying if department is created.
if (driver.find_element(:xpath, "//a[contains(.,'            Automated Department Creation')]")).displayed?
  puts "Passed"
else
  puts "Failed"
end;

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;
