from selenium import webdriver
import time
import unittest
from faker import Faker
from datetime import datetime

class AssignUserToOrgnization(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_ReAssignUser(self):
        f = Faker()
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avani.canvas@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        #Script to re assign user to an organization
        driver.find_element_by_xpath("//span[contains(.,'Users')]").click()
        time.sleep(2)
        #select emailid for admin user
        driver.find_element_by_xpath( "//tr[5]/td[1]/em").click()
        time.sleep(2)
        Actual_OrgName = driver.find_element_by_xpath("//tr[89]/td[3]/div").text
        print (Actual_OrgName, "On Users Page")
        # delete admin user for organization
        driver.find_element_by_xpath("//tr[89]/td[2]/a/i").click()
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot(
            'C:\Users\UNI\Desktop\QAUber\Automation Assignment\SCREENSHOTS\DelAdminUser' + newtime + '.png')
        time.sleep(5)
        #select regular user for organization
        driver.find_element_by_xpath("//tr[89]/td[1]/select[@ng-model='entity.status']/option[text()='Regular User']").click()
        time.sleep(2)
        #save the changes
        driver.find_element_by_xpath("//tr[89]/td[2]/a/i").click()
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot(
            'C:\Users\UNI\Desktop\QAUber\Automation Assignment\SCREENSHOTS\AdmintoRegUser' + newtime + '.png')
        time.sleep(2)
        driver.find_element_by_xpath("//button[text()='Update']").click()
        time.sleep(5)
        driver.find_element_by_xpath("//a[contains(.,'Logout')]").click()

    def tearDown(self):
        self.driver.quit()