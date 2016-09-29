

from selenium import webdriver
import unittest
import time

class PageNoFunctional(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_PageNoFunctional(self):
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        #Enter Regular User Name
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avanireg@gmail.com")
        #Enter Associated password
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        time.sleep(5)
        #Click Login Button
        driver.find_element_by_xpath("//button[@type='submit']").click()
        #Click on Reports button from main navigation
        driver.find_element_by_xpath("//li[2]/a/span").click

        number_of_pages = driver.find_elements_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[12]/td/dir-pagination-controls/ul/li/a")
        print(number_of_pages)
        #page = driver.find_element_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[12]/td/dir-pagination-controls/ul/li/a")
        if number_of_pages > 0:
            print("Pagination Exists")
            for current_page in number_of_pages:
                driver.findElementByXPath("//div[2]/section/div/div/dir-pagination-controls/ul/li[" + current_page + "]/a").click
                print(current_page)
        else:
           print("Pagination Doesn't Exists")




        #for page_link in driver.find_elements_by_xpath("html/body/div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[12]/td/dir-pagination-controls/ul/li/a"):
           # print "page number: %s" % page_link.text
           # page_link.click()

        #click on page2
        #driver.find_element_by_link_text("2").click()
        #print("You are on Page 2")

        # driver.find_element_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[12]/td/dir-pagination-controls/ul/li[3]/a").click
        # self.assertEqual("Report 2130",driver.find_element_by_xpath("//div[2]/section/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td/div/div/div/div[1]/h4"))
        driver.find_element_by_link_text("Logout").click()

    def tearDown(self):
        self.driver.quit()





