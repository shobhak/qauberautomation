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
        #maximize the browser window
        driver.set_window_size(1024, 600)
        driver.maximize_window()
        wait = WebDriverWait(driver, 2)
        #wait
        time.sleep(2)
        driver.get(self.base_url)
        time.sleep(3)
        #find the login and input email
        driver.find_element_by_xpath("//input[@id='exampleInputEmail1']").clear()
        driver.find_element_by_xpath("//input").send_keys("dummyemail1938+4@gmail.com")
        # password
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").clear()
        driver.find_element_by_xpath(".//*[@id='exampleInputPassword1']").send_keys("Thisis4u")
        time.sleep(3)
        #submit
        driver.find_element_by_xpath("//button").click()
        time.sleep(3)

    ############## Super AdminUser has logged in and arrived at the main page on testwave .
        # Click on Users on the left panel
        driver.find_element_by_xpath('//li[4]/a/span').click()
        time.sleep(3)
        # Go to the panel with all the pages
        pagePanel = driver.find_elements_by_xpath("//div[2]/table/tbody/tr[12]/td")
        time.sleep(2)
        #iterate through each of the pages to click and check if they are working.
        for page in pagePanel:
                #page 1
                driver.find_element_by_xpath("//a[contains(text(),'1')]").click()
                #wait
                time.sleep(2)
                #page 2
                driver.find_element_by_xpath("//a[contains(text(),'2')]").click()
                #wait to see if the page has changed from page1 to page2
                time.sleep(3)
                #page 3
                driver.find_element_by_xpath("//a[contains(text(),'3')]").click()
        else:
                print "Page over"
        #sleep
        time.sleep(1)
        # +++ logout  functionality
        driver.find_element_by_link_text('Logout').click()
        time.sleep(1)
  #######++++++++++quit and exit the browser
    def tearDown(self):
        self.driver.quit()
if __name__ == "__main__":
        unittest.main()

