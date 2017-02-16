import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
#from selenium.webdriver import ActionChains
#from selenium.webdriver.common.by import By
#from selenium.webdriver.support import expected_conditions as EC


### This test verifies that the login and logout funcctionality of then is working. The browser used is Chrome.
###  tester -Shobha Vaidyanathan


class WvLogin(unittest.TestCase):
    def setUp(self):
        #chrome browser
        self. driver = webdriver.Chrome('C:\Users\shobha\chromedriver')
        # if using firefox take the comment out and comment the previous statement.
        #self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(2)
        self.wait = WebDriverWait(self.driver,2)
        #url to login
        self.base_url = "http://testwave.qabidder.net/#/page/login"
        time.sleep(1)

    def test_search(self):
        driver = self.driver
        driver.get(self.base_url)
        wait = WebDriverWait(driver,2)
        time.sleep(3)
        #email field
        driver.find_element_by_xpath("//input[@id='exampleInputEmail1']").clear()
        driver.find_element_by_xpath("//input").send_keys("dummyemail1938+4@gmail.com")
        #password field
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").clear()
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").send_keys("Thisis4u")
        #wait
        time.sleep(3)
        # submit
        driver.find_element_by_xpath("//button").click()

        #passedNavigation test case #1 Verify that the hamburger icon is functional
        driver.find_element_by_xpath("//li/a").is_selected()
        driver.find_element_by_css_selector("a.hidden-xs").is_enabled()

        #passed Navigation test case #2 Verify that the reports button in main navigation works
        driver.find_element_by_xpath("//a/span").is_selected()

        #passed Navigation test case #3 verify Add report button in left main navigation works
        driver.find_element_by_xpath("//li[3]/a/span").is_selected()

        #passed Navigation test case #4 Verify users button in main navigation is functional
        driver.find_element_by_xpath("//li[4]/a/span").is_selected()

        # Navigation test case that the profile panel is functional
        driver.find_element_by_xpath("//li[2]/a").click()
        driver.find_element_by_xpath("//li[2]/a").click()

        time.sleep(2)
        # +++ testing logout  functionality
        driver.find_element_by_link_text('Logout').click()

        time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    unittest.main()
