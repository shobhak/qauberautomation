import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from faker import Faker


#from selenium.webdriver import ActionChains
#from selenium.webdriver.common.by import By
#from selenium.webdriver.support import expected_conditions as EC


###  This script verifies tes case T76690	Verify User is able to "Make A payment". The browser used is Chrome.
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
        # maximize the browser window
        driver.set_window_size(1024, 600)
        driver.maximize_window()
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

        #######################Logged In
        # click on Entities
        driver.find_element_by_xpath("//li[5]/a/span").click()
        time.sleep(3)

        # variable of the Faker package which allows us to create fake information for testing.
        fake = Faker()
       ##################################################
        # add organization.
        driver.find_element_by_xpath('//div/button').click()
        time.sleep(2)
        name = fake.company()
        driver.find_element_by_xpath("//input[@name='name']").send_keys(name)
        time.sleep(4)

        ##driver.find_element_by_xpath("//button[2]").click()
        ##time.sleep(2)
        ## zip code
        zipCode = fake.postalcode()
        driver.find_element_by_xpath("//div[2]/input").send_keys(zipCode)
        time.sleep(2)
        ## address
        # address = fake.address()
        # driver.find_element_by_xpath("//div[3]/input").send_keys(address)
        # time.sleep(3)
        # city#   country
        driver.find_element_by_name("country").send_keys("USA")
        # state
        state = fake.state()
        driver.find_element_by_name("state").send_keys(state)
        # wait
        time.sleep(3)

        city = fake.city()
        driver.find_element_by_xpath("//input[@name='city']").send_keys(city)

        time.sleep(3)
        # regular user email
        regularEmail = fake.email()
        driver.find_element_by_css_selector("div.bootstrap-tagsinput.focus").send_keys(regularEmail)

        # +++ testing logout  functionality//div[7]/input
        # adminUser email generated.
        adminEmail = fake.email()
        time.sleep(2)

        # enter the random admin email into the
        driver.find_element_by_xpath("//button[2]").send_keys(adminEmail)
        time.sleep(2)
        # click on next button
        driver.find_element_by_xpath("//button[2]").click()
        time.sleep(3)

        driver.find_element_by_xpath("//button[@type='button']").click()
        driver.find_element_by_xpath("//div[@id='ngdialog3']/div[2]/div/button").click()
        ##driver.find_element_by_css_selector("span.input-group-btn > button.btn.btn-primary").click()
        ####pay for subscription
        driver.find_element_by_xpath("(//button[@type='button'])[4]").click()
        time.sleep(3)
        #
    def tearDown(self):
         self.driver.quit()

if __name__ == "__main__":
        unittest.main()


