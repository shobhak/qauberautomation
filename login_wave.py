from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
import logging
import time
import unittest
from datetime import datetime
class LoginTest(unittest.TestCase):
    logging.basicConfig(filename="C:\Users\Madhu\python\workspace_python\Wavefit\Test_suitePackage\TestSuitscreenshots\log.txt",
        level=logging.DEBUG)
    logging.debug('debug message')
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
        validemail = "smi16p+55@gmail.com"
        password = "test123"
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys(validemail)
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys(password)
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        # click on logout button
        driver.find_element_by_xpath("//a[contains(text(),'Logout')]").click()
        time.sleep(2)

    def teardown(self):
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        self.driver.save_screenshot('C:\Users\Madhu\python\workspace_python\Wavefit\Test_suitePackage\TestSuitscreenshots\screenshots' + newtime + '.png')
        self.driver.quit()

if __name__ == "__main__":
        unittest.main()
