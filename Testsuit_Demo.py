import unittest
from Test_suitePackage.Add_reports import  AddReports
from Test_suitePackage.login_wave import  LoginTest

# get all tests from addreport and LoginTest
tc1 = unittest.TestLoader().loadTestsFromTestCase(AddReports)
tc2 = unittest.TestLoader().loadTestsFromTestCase(LoginTest)
# creating test suits
smoke_test= unittest.TestSuite([tc1,tc2])
unittest.TextTestRunner(verbosity=2).run(smoke_test)