
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
import inspect
import time
import unittest
import logging
from datetime import datetime


class AddReports(unittest.TestCase):
    logging.basicConfig(filename="C:\Users\Madhu\python\workspace_python\Wavefit\Test_suitePackage\TestSuitscreenshots\log.txt", level=logging.DEBUG)
    logging.debug('debug message')


    def __init__(self, *args, **kwargs):
        unittest.TestCase.__init__(self, *args, **kwargs)

        self.driver = webdriver.Chrome()
        # Navigate to login page
        self.driver.get("http://testwave.qabidder.net/")

    def setup(self):
        self.driver.maximize_window()
        # Login
    def test_Addreports(self):
      #try:
        driver = self.driver
        self.driver.maximize_window()
        validemail = "smi16p+55@gmail.com"
        password = "test123"
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

        # Verify that the reports button as regular user works
        driver.find_element_by_xpath("html/body/div[2]/aside[1]/div/nav/ul/li[2]/a/span").click()
        # Verify that the Suspect last name as regular user works
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input").click()
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[1]/input").send_keys("rai")
        # Verify that the Suspect first name as regular user works
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input").click()
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/div[1]/div[2]/input").send_keys("mia")
        time.sleep(2)
        # Verify view button
        driver.find_element_by_xpath("//a[contains(.,'View')]").click()
        time.sleep(2)
        #driver.find_element_by_xpath("html/body/div[2]/aside[1]/div/nav/ul/li[3]/a/span")
        time.sleep(2)
        #assert "No results found." not in driver.page_source

        #driver.find_element_by_css_selector("li.next>a").click()
        #time.sleep(10)

        logoutelement = self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]")
        time.sleep(1)

        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        self.driver.save_screenshot('C:\Users\Madhu\python\workspace_python\Wavefit\Test_suitePackage\TestSuitscreenshots\screenshots'+ newtime + '.png')
        logoutelement.click()

    def teardown(self):
         self.driver.quit()

if __name__ == "__main__":
         unittest.main()
