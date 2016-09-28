
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait

import time
import unittest

class LoginTest(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        unittest.TestCase.__init__(self, *args, **kwargs)
        self.driver = webdriver.Chrome()
        # Navigate to login page
        self.driver.get("http://testwave.qabidder.net/")

    def setup(self):
        self.driver.maximize_window()
        # Login
    def test_Login(self):
        driver = self.driver
        self.driver.maximize_window()
        validemail = "pihu2713+3@gmail.com"
        password = "wavefit"
        emailfieldelement = WebDriverWait(driver, 10).until(lambda driver: driver.find_element_by_id("exampleInputEmail1"))
        passfieldelement = WebDriverWait(driver,10).until(lambda driver: driver.find_element_by_id("exampleInputPassword1"))
        loginbuttonelement = WebDriverWait(driver, 10).until(lambda driver: driver.find_element_by_xpath("//button[@type='submit']"))
        emailfieldelement.clear()
        emailfieldelement.send_keys(validemail)
        passfieldelement.clear()
        passfieldelement.send_keys(password)
        time.sleep(2)
        loginbuttonelement.click()
        time.sleep(2)
        logoutelement = self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]")
        time.sleep(1)
        # Verify that the reports button as regular user works
        driver.find_element_by_xpath("html/body/div[2]/aside[1]/div/nav/ul/li[2]/a/span").click()
        # Verify that the Suspect last name as regular user works
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input").click()
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input").send_keys("ti")
        # Verify that the Suspect first name as regular user works
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input").click()
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input").send_keys("report2")
        # Verify view button
        driver.find_element_by_xpath("//table/tbody/tr[1]/td/div/div/div/div[6]/a").click()

        time.sleep(10)
        logoutelement.click()

    def teardown(self):
        self.driver.quit()


if __name__ == "__main__":
    unittest.main()
