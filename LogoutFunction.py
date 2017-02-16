import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait

# This script is testing the Main Navigation of the application
# specifically testing #T76679	Verify that the "Logout" on the menu bar is function. There is login
#and then logs out of the application and exits the browser. This is on Chrome.
# tester- Shobha Vaidyanathan

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

        time.sleep(2)
        # +++ testing logout  functionality
        driver.find_element_by_link_text('Logout').click()
        time.sleep(1)

    def tearDown(self):
        self.driver.quit()
if __name__ == "__main__":
    unittest.main()

