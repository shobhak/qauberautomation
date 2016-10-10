import unittest
import time
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.common.exceptions import NoSuchElementException

def findElement(driver, selector, name, keys='', click=False):

    if keys:
        try:
            driver.find_element_by_css_selector(selector).send_keys(keys)
        except NoSuchElementException:
            driver.save_screenshot("C:\Users\shobha\Desktop\New folder.png")
            driver.fail("Tried to send %s into element %s but did not find the element." % (keys, name))
    elif click:
        try:
            driver.find_element_by_css_selector(selector).click()
        except NoSuchElementException:
            driver.save_screenshot("C:\Users\shobha\Desktop\New folder.png")
            driver.fail("Tried to click element %s but did not find it." % name)
    else:
        try:
            driver.find_element_by_css_selector(selector)
        except NoSuchElementException:
            driver.save_screenshot("C:\Users\shobha\Desktop\New folder.png")
            driver.fail("Expected to find element %s but did not find it." % name)