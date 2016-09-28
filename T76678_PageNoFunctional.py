from selenium import webdriver
import unittest

class PageNoFunctional(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_PageNoFunctional(self):
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avanireg@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        driver.find_element_by_xpath("//button[@type='submit']").click()
        driver.find_element_by_xpath("//div[2]/aside[1]/div/nav/ul/li[2]/a/span").click()
        #driver.find_element_by_link_text(2).click
        driver.find_element_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[12]/td/dir-pagination-controls/ul/li[3]/a").click
        self.assertEqual("Report 2130",driver.find_element_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td/div/div/div/div[1]/h4"))
        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()