from selenium import webdriver
from faker import Faker
import time
import unittest

class Addreport_Preview(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        #self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_addreport_preview(self):
        f = Faker()
        first_name = f.first_name()
        last_name = f.last_name()

        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("offuse11@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("test123")
        time.sleep(5)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        #Go to add report page
        driver.find_element_by_xpath("//span[contains(.,'Add Report')]").click()
        #Select department name
        driver.find_element_by_xpath("//label[contains(.,'Neoaccel')]").click()
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[2]/ul/li/a").click()
        time.sleep(2)
        #enter  random first name
        driver.find_element_by_xpath("//input[@name='first-name']").clear()
        driver.find_element_by_xpath("//input[@name='first-name']").send_keys(first_name)
        print(first_name)
        time.sleep(2)
        #enter  random last name
        driver.find_element_by_xpath("//input[@name='last-name']").clear()
        driver.find_element_by_xpath("//input[@name='last-name']").send_keys(last_name)
        print(last_name)
        time.sleep(2)
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a").click()
        time.sleep(2)
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a").click()
        time.sleep(2)
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a").click()
        time.sleep(2)
        # enter Stop Location
        driver.find_element_by_xpath("//input[@placeholder = 'Stop Location']").clear()
        driver.find_element_by_xpath("//input[@placeholder = 'Stop Location']").send_keys("Sunnyvale")
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a").click()
        time.sleep(2)
        #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a").click()
        time.sleep(2)
         #Go to next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div/form/div/div[8]/ul/li[2]/a").click()
        time.sleep(2)
        print("You are on preview page")
        time.sleep(2)
        fname= driver.find_element_by_xpath("//strong[@class='ng-binding firepath-matching-node']")
        print (fname)
        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()
