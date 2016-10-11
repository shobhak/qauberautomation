from selenium import webdriver
import time
import unittest
from faker import Faker

class AssignUserToOrgnization(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_AssignUser(self):
        f = Faker()
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avani.canvas@gmail.com")
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        time.sleep(2)
        driver.find_element_by_xpath("//button[@type='submit']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//li[5]/a/span").click()
        time.sleep(2)
        driver.find_element_by_xpath("html/body/div[2]/section/div/div/button[1]").click()
        time.sleep(2)
        ####### write organization name
        cname = f.company()
        driver.find_element_by_xpath("//input[contains(@orgname,'orgname')]").send_keys(cname)
        print(cname)
        time.sleep(2)
        ####### enter zipcode
        post =f.postalcode()
        driver.find_element_by_xpath("//div[2]/input").send_keys(post)
        print(post)
        time.sleep(2)
        ####### enter address
        add =f.street_address()
        driver.find_element_by_xpath("//div[2]/div[1]/div[3]/input").send_keys(add)
        print(add)
        time.sleep(2)
        ####### enter country
        driver.find_element_by_xpath("//input[@name='country']").send_keys("USA")
        ####### enter state
        state = f.state()
        ####### select state from drop down
        driver.find_element_by_xpath("//select[contains(@ng-show,'ctrl.showStatesDropDown')]").click()
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").send_keys(state)
        print(state)
        driver.find_element_by_xpath("//select[@ng-show='$ctrl.showStatesDropDown']").click()
        ####### enter city
        city = f.city()
        driver.find_element_by_xpath("//input[contains(@name,'city')]").send_keys(city)
        print(city)
        ####### click NextStep
        driver.find_element_by_xpath("//div[2]/section/div/div/div[2]/button[2]").click()
        print("regular user page")
        time.sleep(2)
        ####### click NextStep
        driver.find_element_by_xpath("//button[contains(@ng-click,'ctrl.nextStep()')]").click()
        time.sleep(2)
        print("Onadmin user page")
        ####### add email id for admin user
        #email = f.email()
        #print(email)
        #driver.find_element_by_xpath("(//input[@type='text'])[12]").send_keys(email)
        driver.find_element_by_xpath("(//input[@type='text'])[12]").send_keys('avani112@gmail.com')
        ####### u'\ue007' TO PRESS ENTER KEY
        driver.find_element_by_xpath("(//input[@type='text'])[12]").send_keys(u'\ue007')
        time.sleep(5)
        ####### click on Invite button
        driver.find_element_by_xpath("//div[2]/section/div/div/div[1]/div[3]/form/div/div/span/button").click()
        time.sleep(3)
        print("Invitation sent to admin user")
        driver.find_element_by_xpath("//button[contains(.,'Done')]").click()
        time.sleep(5)
        print("done")
        driver.find_element_by_xpath("//button[contains(@ng-click,'ctrl.nextStep()')]").click()
        time.sleep(2)
        driver.find_element_by_xpath("//span[contains(.,'Users')]").click()
        time.sleep(2)
        driver.find_element_by_xpath( "//tr[5]/td[1]/em").click()
        time.sleep(2)
        #driver.find_element_by_xpath("//p[contains(.,'Email: avani112@gmail.com']").click()
        #driver.find_element_by_xpath(".//*[@id='ngdialog5']/div[2]/div[1]/div/table/tbody/tr[19]/td[3]/div").click()
        #driver.find_element_by_xpath("//div[@class='depth-level'][text()='Duke and Sons']").click()
        #driver.find_element_by_xpath("//div[@class='depth-level firepath-matching-node']").click()
        driver.find_element_by_xpath("//tr[29]/td[2]/a/i").click()
        #driver.find_element_by_xpath("//i[@class='fa fa-trash']").click()
        time.sleep(5)
        driver.find_element_by_xpath("//[@id='ngdialog2']/div[2]/div[1]/div/table/tbody/tr[29]/td[1]/select").click()
        time.sleep(5)
        driver.find_element_by_xpath("//[@id='ngdialog2']/div[2]/div[1]/div/table/tbody/tr[30]/td[1]/select/option[@value='20']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//i[contains(@class,'fa fa-floppy-o firepath-matching-node')]").click()
        # driver.find_element_by_xpath("//i[@class='fa fa-floppy-o']").click()
        time.sleep(2)
        driver.find_element_by_xpath("//button[text()='Update']").click()
        time.sleep(5)
        driver.find_element_by_xpath("//a[contains(.,'Logout')]").click()

    def tearDown(self):
        self.driver.quit()