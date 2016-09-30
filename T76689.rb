#importing WebDriver
require "selenium-webdriver"
#importing Actions
require "selenium/webdriver/common/action_builder"
require "faker"


#Specifying Browser for Webdriver
driver = Selenium::WebDriver.for :chrome;

#TC: Verify User is able to "Choose A Subscription Package"  https://bidqa.testrail.net/index.php?/tests/view/76689

#navigate to login page
driver.get("http://testwave.qabidder.net/#/page/login");
sleep(3)

#login
driver.find_element(:xpath, "//input[@id='exampleInputEmail1']").send_keys("arkadiy.plekhanov@yahoo.com");
sleep(4)
driver.find_element(:xpath, "//input[@id='exampleInputPassword1']").send_keys("qwerty123");
sleep(4)
driver.find_element(:xpath, "//button[@type='submit']").click;
sleep(4)

#Navigating to "Entities" page
driver.find_element(:xpath, "//span[contains(.,'Entities')]").click;
sleep(6)

#Openning [Add Organization] form.
driver.find_element(:xpath, "//button[@ng-click='openAddOrgForm()']").click;
sleep(4)

#Enter text into Organization Name field.
name = Faker::Company.name
driver.find_element(:xpath, "//input[@orgname='orgname']").send_keys(name);
sleep(1)

#Enter numbers into phone # field.
driver.find_element(:xpath, "//input[@ng-model='$ctrl.org.phone']").send_keys("123455674456775");

#Enter E-Mail into Email field.
driver.find_element(:xpath, "//input[@name='email']").send_keys("nospam@gmail.com");
sleep(3)

#Enter Zip code into Zip Code field.
driver.find_element(:xpath, "//input[@ng-model='$ctrl.org.zip']").send_keys("94010");
sleep(2)

#Enter address into address field .
driver.find_element(:xpath, "//input[@ng-model='$ctrl.org.address1']").send_keys("1014 El Camino Real");

#Enter city name into city field.
driver.find_element(:xpath, "//input[@ng-model='$ctrl.org.city']").send_keys("San Mateo");

sleep(1)

#Navigate to the next page
driver.find_element(:xpath, "//button[@ng-click='$ctrl.nextStep()']").click
sleep(3)

#Navigate to the next page
driver.find_element(:xpath, "//button[@ng-click='$ctrl.nextStep()']").click

#Navigate to the next page
driver.find_element(:xpath, "//button[@ng-click='$ctrl.nextStep()']").click

#Change subscription package to 22 using Action Class
el = driver.find_element(:xpath, "//div[@class='slider-handle min-slider-handle round']");
driver.action.drag_and_drop_by(el, 74, 0).perform

#Verifying if the slider's value is set to 22.
if (driver.find_element(:xpath, "//div[@aria-valuenow='22']")).displayed?
  puts "Passed"
else
  puts "User is not able to move slider"
end;

#clearing cache
driver.manage.delete_all_cookies;

#closing Browser
driver.quit;