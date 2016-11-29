# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re

class FinalInviteUser(unittest.TestCase):
    def setUp(self):
        #self.driver = webdriver.Firefox()
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://testwave.qabidder.net/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_final_invite_user(self):
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("offuse11@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("test123")
        #driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(5)
        driver.find_element_by_xpath("//button[@type='submit']").click()

        driver.find_element_by_xpath("//li[5]/a/span").click()
        time.sleep(2)
        driver.find_element_by_xpath("//div/button").click()
        time.sleep(2)
        driver.find_element_by_name("name").click()
        time.sleep(2)
        driver.find_element_by_name("name").clear()
        time.sleep(2)
        driver.find_element_by_name("name").send_keys("adinn14578912")
        time.sleep(2)
        driver.find_element_by_xpath("(//button[@type='button'])[4]").click()
        print("regular user page")
        time.sleep(2)
        #driver.find_element_by_xpath("(//button[@type='button'])[4]").click()
        #driver.find_element_by_xpath("//button[contains(.,'Nextstep')]").click()
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]").click()
        time.sleep(2)

       # driver.find_element_by_xpath("//div[@class='bootstrap-tagsinput firepath-matching-node']")
        driver.find_element_by_xpath("//div[3]/form/div/div/div").click()
        print("admin form")
        #driver.find_element_by_xpath("//div[@class='panel-body']").click()
        time.sleep(2)
        driver.find_element_by_xpath("(//input[@type='text'])[11]").click()
        time.sleep(2)
        #driver.find_element_by_xpath("(//input[@type='text'])[11]").click()
        #time.sleep(2)
        driver.find_element_by_xpath("(//input[@type='text'])[11]").clear()
        time.sleep(2)
        driver.find_element_by_xpath("(//input[@type='text'])[11]").send_keys("avani.canvas@gmail.com")
        time.sleep(5)
        driver.find_element_by_xpath("(//button[@type='button'])[2]").click()
        print("Invite Page")
        time.sleep(1)

        driver.find_element_by_xpath("(//button[@type='button'])[5]").click()
        time.sleep(1)
        driver.find_element_by_link_text("Logout").click()
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException as e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
