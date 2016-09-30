from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait

import time
import unittest

class LoginTest(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        unittest.TestCase.__init__(self, *args, **kwargs)
        self.driver = webdriver.Chrome()
        # Navigate to login page
        self.driver.get("http://testwave.qabidder.net/")

    def setup(self):
        self.driver.maximize_window()

    def test_AddReport(self):
        driver = self.driver
        self.driver.maximize_window()
        validemail = "pihu2713+3@gmail.com"
        password = "wavefit"
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys(validemail)
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys(password)
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//li[3]/a/span").click()
        time.sleep(2)
        driver.find_element_by_xpath("//div/div[2]/fieldset/div/div/div/label/span").click()
        driver.find_element_by_css_selector("li.next>a").click()
        # entering Firstname
        time.sleep(5)

        driver.find_element_by_css_selector("input[name='first-name']").click()
        driver.find_element_by_css_selector('input[name="first-name"]').send_keys("mia")
        # find last_name
        driver.find_element_by_css_selector('input[name="last-name"]').click()

        # entering last_name
        driver.find_element_by_css_selector('input[name="last-name"]').send_keys("ti")
        time.sleep(2)
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[3]/ul/li[2]/a").click()
        time.sleep(5)
        # Scars selected
        driver.find_element_by_xpath('(//input[@type="checkbox"])[1]').click()
        time.sleep(5)
        # entering on next page
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[4]/ul/li[2]/a").click()
        time.sleep(5)
        # contact page
        driver.find_element_by_name("primary-language").send_keys("English")
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[5]/ul/li[2]/a").click()
        time.sleep(2)
        # Environment page
        driver.find_element_by_xpath('//div[2]/div/label/span').click()
        # location page
        driver.find_element_by_name('locationOfStop').send_keys('Casablanca')
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a").click()
        time.sleep(2)
        # Vehical page
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/fieldset/div[1]/div[1]/div/label/span").click()
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[7]/ul/li[2]/a").click()
        time.sleep(2)
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[8]/ul/li[2]/a").click()
        time.sleep(2)
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div/form/div/div[9]/ul/li[2]/a").click()
        time.sleep(1)
        # logout
        self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]").click()


    def teardown(self):
            self.driver.quit()

if __name__ == "__main__":
        unittest.main()
