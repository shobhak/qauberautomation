import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait

#### This test verifies that all the functionalities in the web application WAVE FIT are
### functional beginning from logging in to the application
#  specifically testing  Main Navigation functionality -test case #T76671	Verify "Reports" link is functional
# and logging out and exiting in the end.  This test uses chrome driver.
#
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


        # passed Navigation test case #2 Verify that the reports button in main navigation works
        driver.find_element_by_xpath("//a/span").is_selected()

        # wait
        time.sleep(2)
        # +++ testing logout  functionality
        driver.find_element_by_link_text('Logout').click()
        time.sleep(2)

        # shut it down
    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
        unittest.main()

