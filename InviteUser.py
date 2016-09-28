import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
#from selenium.webdriver import ActionChains
#from selenium.webdriver.common.by import By
#from selenium.webdriver.support import expected_conditions as EC


### This test verifies that when logged in as a Super admin the user is able to
## invite other users. This has been done on Selenium WebDriver with Python using JetBrains IDE
# Specifically it tests # Test case T76681	Verify Super Admin user can invite user. This is done on Chrome browser
###  tester -Shobha Vaidyanathan


class WvLogin(unittest.TestCase):
    def setUp(self):
        # using chrome
        self. driver = webdriver.Chrome('C:\Users\shobha\chromedriver')
        #self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(2)
        self.wait = WebDriverWait(self.driver,2)
        #go to the url
        self.base_url = "http://testwave.qabidder.net/#/page/login"
        time.sleep(1)

    def test_search(self):
        driver = self.driver
        driver.get(self.base_url)
        wait = WebDriverWait(driver,2)
        #wait
        time.sleep(3)
        # click on the email and input email info
        driver.find_element_by_xpath("//input[@id='exampleInputEmail1']").clear()
        driver.find_element_by_xpath("//input").send_keys("dummyemail1938+4@gmail.com")
        #find password and input.
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").clear()
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").send_keys("Thisis4u")
        #wait
        time.sleep(3)
        # click to submit
        driver.find_element_by_xpath("//button").click()
        time.sleep(3)

        # Users on Navigation menu
        driver.find_element_by_xpath('//li[4]/a/span').click()
        time.sleep(2)
        # click on invite users button
        driver.find_element_by_xpath('//div/button').click()

        #wait
        time.sleep(2)

        # shut it down

    def tearDown(self):

        self.driver.quit()

