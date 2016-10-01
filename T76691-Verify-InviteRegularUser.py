from selenium import webdriver
import time
import unittest
from faker import Faker

class LoginTest(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        unittest.TestCase.__init__(self, *args, **kwargs)
        self.driver = webdriver.Chrome()
        # Navigate to login page
        self.driver.get("http://testwave.qabidder.net/")

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
        time.sleep(4)

        driver.find_element_by_xpath("//button[2]").click()
        time.sleep(3)
        # regular user email
        regularEmail = fake.email()
        driver.find_element_by_xpath("(//input[@type='text'])[9]").send_keys(regularEmail)
        time.sleep(2)
        self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]").click()

    def teardown(self):
            self.driver.quit()

if __name__ == "__main__":
        unittest.main()