

from selenium import webdriver
import unittest
import time

class PageNoFunctional(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_PageNoFunctional(self):
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        #Enter Regular User Name
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avanireg@gmail.com")
        #Enter Associated password
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        time.sleep(5)
        #Click Login Button
        driver.find_element_by_xpath("//button[@type='submit']").click()
        #Click on Reports button from main navigation
        driver.find_element_by_xpath("//li[2]/a/span").click
        print("on reports page")

        driver.find_element_by_xpath("//a[@ng-click='setCurrent(pagination.current + 1)']").click()
        if driver.find_element_by_xpath("//a[contains(.,'2')]"):
            time.sleep(2)
            print("On 2nd page")
        else:
            print("Can't go to next page")

        driver.find_element_by_xpath("//a[@ng-click='setCurrent(pagination.current - 1)']").click()
        if driver.find_element_by_xpath("//a[contains(.,'1')]"):
            time.sleep(2)
            print("On 1st page")
        else:
            print("Can't go to previous page")

        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()





