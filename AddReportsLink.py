import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait

### This test verifies that all the functionalities in the web application are
### functional beginning from logging in to the application until logging out.
# Specifically testing test case T76672	Verify "Add report" link is functional
# ###  tester -Shobha Vaidyanathan

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

        # passed Navigation test case #3 verify Add report button in left main navigation works
        driver.find_element_by_xpath("//li[3]/a/span").is_selected()

        time.sleep(2)
        # +++ testing logout  functionality
        driver.find_element_by_link_text('Logout').click()
        time.sleep(2)

    def tearDown(self):
            self.driver.quit()

if __name__ == "__main__":
        unittest.main()


