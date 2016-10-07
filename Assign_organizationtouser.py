from selenium import webdriver
from datetime import datetime
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
        validemail = "avani.canvas@gmail.com"
        password = "1234567"
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
        driver.find_element_by_xpath("//input[@name='zip']").send_keys(fake.postalcode())
        time.sleep(2)
         # add address
        driver.find_element_by_xpath("//div[2]/div[1]/div[3]/input").send_keys(fake.street_address())
        time.sleep(2)
        driver.find_element_by_xpath("//input[contains(@name,'country')]").send_keys("USA")
        time.sleep(2)
        # select state
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").send_keys(fake.state())
        time.sleep(3)
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").click()
        # add city
        driver.find_element_by_xpath("//input[contains(@name,'city')]").send_keys(fake.city())
        time.sleep(2)
        # nextstep
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]/span[2]").click()
        time.sleep(2)
        print("regular user")
        #regularEmail = fake.email()
        # sending regularemail
        driver.find_element_by_xpath("(//input[@type='text'])[10]").send_keys("mia27@gmail.com")
        time.sleep(5)
        # click on textbox(Regularemail)
        driver.find_element_by_xpath("(//input[@type='text'])[10]").click()

        driver.find_element_by_xpath("(//input[@type='text'])[10]").send_keys(u'\ue007')
        time.sleep(4)

        # click on invite button for regular user
        driver.find_element_by_xpath("//div[2]/section/div/div/div[1]/div[2]/form/div/div/span/button").click()
        time.sleep(3)

        # click on done button
        driver.find_element_by_xpath("//button[contains(@ng-click,'confirm()')]").click()
        time.sleep(3)
        # for screenshot
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot('D:\Screenshot\wavefit' + newtime + '.png')
        driver.save_screenshot('D:\Screenshot\wavefit1.png')
        # click on entities
        driver.find_element_by_xpath("//span[contains(.,'Users')]").click()
        time.sleep(2)
        # click on cofig menu
        driver.find_element_by_xpath("//div[2]/table/tbody/tr[3]/td[1]/em").click()
        time.sleep(2)
        #element = driver.find_element_by_xpath("//div[2]/div[1]/div/table/tbody/tr[20]/td[3]/div")
        self.assertTrue(self.driver.find_element_by_xpath("//div[2]/div[1]/div/table/tbody/tr[20]/td[3]/div"))
        # select department(Regular user)
        driver.find_element_by_xpath("//select/option[@value='10']").click()
        time.sleep(2)
        # Click on save button
        driver.find_element_by_css_selector(".btn.btn-default.btn-sm.ng-scope").click()
        time.sleep(2)
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot('D:\Screenshot\wavefit' + newtime + '.png')
        # click on update button
        driver.find_element_by_css_selector(".btn.btn-primary.mr").click()
        time.sleep(1)
        # click on logout button
        self.driver.find_element_by_xpath("//a[contains(text(),'Logout')]").click()

    def teardown(self):
            self.driver.quit()

if __name__ == "__main__":
        unittest.main()