from selenium import webdriver
import time
import unittest
from faker import Faker

class InviteAdminUser(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_InviteAdminUser(self):
        f = Faker()
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("offuse11@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("test123")
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//li[5]/a/span").click()
        time.sleep(2)
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/button[1]").click()
        time.sleep(2)
        ####### write organization name
        cname = f.company()
        driver.find_element_by_xpath("//input[contains(@orgname,'orgname')]").send_keys(cname)
        print(cname)
        time.sleep(2)
        ####### enter zipcode
        post =f.postalcode()
        driver.find_element_by_xpath("//div[2]/input").send_keys(post)
        print(post)
        #driver.find_element_by_xpath("//div[2]/input").send_keys("94086")
        time.sleep(2)
        ####### enter address
        add =f.street_address()
        driver.find_element_by_xpath("//div[2]/div[1]/div[3]/input").send_keys(add)
        print(add)
        # time.sleep(2)
        #driver.find_element_by_xpath("//div[3]/input").send_keys("123 cbbnbn")
        ####### enter country
        driver.find_element_by_xpath("//input[@name='country']").send_keys("USA")
        ####### enter state
        state = f.state()
        #driver.find_element_by_xpath("//input[contains(@name,'state')]").send_keys(state)
        #print(state)
         #driver.find_element_by_xpath("//input[contains(@name,'state')]").send_keys("CA")
        ####### select state from drop down
        driver.find_element_by_xpath("//select[contains(@ng-show,'ctrl.showStatesDropDown')]").click()
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").send_keys(state)
        print(state)
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").click()
        ####### enter city
        city = f.city()
        driver.find_element_by_xpath("//input[contains(@name,'city')]").send_keys(city)
        print(city)
        # time.sleep(2)
        #driver.find_element_by_xpath("//input[contains(@name,'city')]").send_keys("santa clara")
        ####### click NextStep
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]").click()
        print("regular user page")
        time.sleep(2)
        ####### click next step
        driver.find_element_by_xpath("//button[contains(@ng-click,'ctrl.nextStep()')]").click()
        time.sleep(2)
        print("Onadmin user page")
        ####### add email id for admin user
        email = f.email()
        print(email)
        driver.find_element_by_xpath("(//input[@type='text'])[12]").send_keys(email)
        #######Ascii value  u'\ue007' TO PRESS ENTER KEY
        driver.find_element_by_xpath("(//input[@type='text'])[12]").send_keys(u'\ue007')
        time.sleep(5)
        ####### click on Invite button
        driver.find_element_by_xpath("//div[2]/section/div/div/div[1]/div[3]/form/div/div/span/button").click()
        time.sleep(3)
        print("Invitation sent to admin user")
        driver.find_element_by_xpath("//button[contains(.,'Done')]").click()
        time.sleep(5)
        print("done")
        driver.find_element_by_xpath("//button[contains(@ng-click,'ctrl.nextStep()')]").click()
        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()
