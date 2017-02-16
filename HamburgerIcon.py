import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait

### This test verifies that hamburger icon in the testwave of the web application are
### functional beginning from logging in checking the hamburger icon to the application until logging out.
# specifically  testing T76670	Verify the hamburger icon is functional,
###  tester -Shobha Vaidyanathan


class WvLogin(unittest.TestCase):
    def setUp(self):
        self. driver = webdriver.Chrome('C:\Users\shobha\chromedriver')
        #self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(2)
        self.wait = WebDriverWait(self.driver,2)
        self.base_url = "http://testwave.qabidder.net/#/page/login"
        time.sleep(1)

    def test_search(self):
        driver = self.driver
        driver.get(self.base_url)
        wait = WebDriverWait(driver,2)
        time.sleep(3)
        driver.find_element_by_id("exampleInputEmail1").click()
        driver.find_element_by_xpath("//input[@id='exampleInputEmail1']").clear()
        driver.find_element_by_xpath("//input").send_keys("dummyemail1938+4@gmail.com")
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").clear()
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").send_keys("Thisis4u")
        time.sleep(3)
        driver.find_element_by_xpath("//button").click()

        #passedNavigation test case #1 Verify that the hamburger icon is functional
        driver.find_element_by_xpath("//li/a").is_selected()
        driver.find_element_by_css_selector("a.hidden-xs").is_enabled()

        time.sleep(2)
        # +++ testing logout  functionality
        driver.find_element_by_link_text('Logout').click()

        time.sleep (1)
     #quit
    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
        unittest.main()
