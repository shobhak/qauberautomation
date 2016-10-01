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
        fake = Faker()
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
        cname = fake.company()
        time.sleep(2)
        #write organization name
        driver.find_element_by_xpath("//input[contains(@orgname,'orgname')]").send_keys(cname)
        # click next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]").click()
        # click next step
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]").click()
        # add email id for admin user
        driver.find_element_by_xpath("//button[2]").send_keys("avani.canvas@gmail.com")
        driver.find_element_by_xpath("//button[2]").click()
        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()