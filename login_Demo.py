""""
LOGGING DEMO1
lOGGING LEVELS
DEBUGG
INFO
WARNING
ERROR
CRITICAL
"""
import logging

logging.basicConfig(filename= "test.log",level= logging.DEBUG)

logging.warning("This is warning")

logging.debug("This is debugg")

logging.error("This is Error")

logging.critical("This is critical error")

logging.info("This is info")