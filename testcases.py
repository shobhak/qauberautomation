import unittest
import os
from datetime import datetime

import xmlrunner as xmlrunner

######from packeage_name.modulename(scriptname) import classname

from suceesfultests.PaginationForUsers import PageNoFunctional
from suceesfultests.T77291_Random_SuperAdmin_AddReport_Preview import Addreport_Preview
from suceesfultests.T76692_Verify_InviteAdminUser import InviteAdminUser

def suite():
    mysuite = unittest.TestSuite()
######suitename.addTest(classname('testcasename'))
    mysuite.addTest(PageNoFunctional('test_PageNoFunctional'))
    mysuite.addTest(Addreport_Preview('test_addreport_preview'))
    mysuite.addTest(InviteAdminUser('test_InviteAdminUser'))
    return mysuite


if __name__ == "__main__":

##### testrunner 1)unittest 2)TextTestRunner 3)xmlrunner
    #unittest.main()

    unittest.TextTestRunner(verbosity=2).run(suite())

    #unittest.main(
    #testRunner=xmlrunner.XMLTestRunner(output='test-reports'),
    #failfast=False, buffer=False, catchbreak=False)

