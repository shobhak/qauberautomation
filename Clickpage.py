import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait


### This test is for the waveit application.
# It  checks Super admin test case T76682 on Chrome Browser
# Verify "Page numbers" are functional in the Users Panel.The application then logs
#out and exits after closing the browser
###  tester -Shobha Vaidyanathan


class WvLogin(unittest.TestCase):
    def setUp(self):
        #browser
        self. driver = webdriver.Chrome('C:\Users\shobha\chromedriver')
        #self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(2)
        self.wait = WebDriverWait(self.driver,2)
        #url
        self.base_url = "http://testwave.qabidder.net/#/page/login"
        time.sleep(1)

    def test_search(self):
        driver = self.driver
        driver.get(self.base_url)
        wait = WebDriverWait(driver,2)
        time.sleep(3)
        #login
        driver.find_element_by_xpath("//input[@id='exampleInputEmail1']").clear()
        driver.find_element_by_xpath("//input").send_keys("dummyemail1938+4@gmail.com")
        #password
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").clear()
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").send_keys("Thisis4u")
        time.sleep(3)
        #submit
        driver.find_element_by_xpath("//button").click()
        time.sleep(3)

        # Users
        driver.find_element_by_xpath('//li[4]/a/span').click()
        time.sleep(3)

        # click on page button
        #page #1
        driver.find_element_by_xpath("//a[contains(text(),'1')]").click()
        #page #2
        driver.find_element_by_xpath("//a[contains(text(),'2')]").click()
        #page#3
        driver.find_element_by_xpath("//a[contains(text(),'3')]").click()

        #sleep
        time.sleep(2)
        # +++ logout  functionality
        driver.find_element_by_link_text('Logout').click()

        time.sleep(1)

    def tearDown(self):

       self.driver.quit()

if __name__ == "__main__":
        unittest.main()

