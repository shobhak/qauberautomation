from selenium import webdriver
#from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException


import time
import unittest
from faker import Faker

class LoginTest(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        unittest.TestCase.__init__(self, *args, **kwargs)
        self.driver = webdriver.Chrome()
        # Navigate to login page
        self.driver.get("http://testwave.qabidder.net/")
        self.driver.save_screenshot('screenshot.png')

    def setup(self):
        self.driver.maximize_window()

    def test_Invite(self):
        driver = self.driver
        self.driver.maximize_window()
        validemail = "smi16p+55@gmail.com"
        password = "test123"
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys(validemail)
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys(password)
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        # click on entities
        driver.find_element_by_xpath("//div/nav/ul/li[5]/a/span").click()
        time.sleep(2)
        fake = Faker()
        # add organization.
        driver.find_element_by_xpath('//div/button').click()
        time.sleep(2)
        oraganization = fake.company()
        driver.find_element_by_xpath("//input[@name='name']").send_keys(oraganization)
        time.sleep(2)
        # add zip code
        driver.find_element_by_xpath("//input[@name='zip']").send_keys(94040)
        time.sleep(2)
         # add address
        driver.find_element_by_xpath("//div[2]/div[1]/div[3]/input").send_keys(fake.street_address())
        time.sleep(2)
        # add city
        driver.find_element_by_xpath("//div[2]/div[1]/div[5]/input").send_keys(fake.city())
        time.sleep(2)
        # select state
        driver.find_element_by_xpath("//div[2]/div[1]/div[6]/div/a/div/b").click()
        time.sleep(2)
       # myselect = Select(driver.find_element_by_class_name("chosen-results"))
        #myselect.select_by_index(1)
        #myselect.select_by_visible_text("text")
        driver.find_element_by_xpath("//li[@class='active-result'][text()='Arizona - AZ']").click()
        #driver.find_element_by_xpath("//select/option[@value='AZ']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]/span[2]").click()
        time.sleep(2)
        print("regular user")

        #driver.find_element_by_xpath("//button[2]").click()
        #time.sleep(3)
        # regular user email
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div").click()
        regularEmail = fake.email()
        # sending regularemail
        driver.find_element_by_xpath("(//input[@type='text'])[9]").send_keys(regularEmail)
        time.sleep(5)
        # click on textbox(Regularemail)
        driver.find_element_by_xpath("//button[@class='btn btn-primary']").click()
        time.sleep(5)
        # driver.find_elements_by_class_name("input-group-btn").click()
        # click on invite button
        driver.find_element_by_xpath("//button[2]").click()
        time.sleep(4)
        driver.save_screenshot('screenshot1.png')
        #driver.switch_to.alert.accept()
        #wait = WebDriverWait(driver, 10)
        #wait.until(EC.alert_is_present())

        #alert = driver.switch_to.alert
        #assert "Unable to login. Try different username" in alert.text
        #alert.accept()
        #time.sleep(2)
        # click on done button
        # driver.find_element_by_css_selector("//button[@class='btn btn-primary").click()
        time.sleep(3);
        # click on logout button
        self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]").click()

    def teardown(self):
            self.driver.quit()

if __name__ == "__main__":
        unittest.main()