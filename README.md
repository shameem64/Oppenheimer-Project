Oppenheimer Project

Below are the documents attached 

1. Oppenheimer Project - TestStrategy : Which explains the high level testing strategy for the project 
2. Oppenheimer Project - TestCases: Test cases and test date is included in this file. Test cases has been written for all the user stories
3. Oppenheimer - Contains the Test Automation project. It is created in eclipse - RestAssured + Testng

Note: Full automation is not completed only the structure is created and a sample test case is partially automated. 

To Run the automation:
Download and open the project in Eclipse
To Run single test case navigate to \src\test\java\TestCase\UserStory1\tc0001.java and right click run as -> TestNG test

To Run as suite right click testng.xml and select -> Run As -> TestNG Suite

Further Improvements which needs to be done for Automation 
1. UI Automation with selenium
2. parametrize the input values and get the input from excel or json file
3. Create enviroment variables to store the global variable
4. Create Utility function to handle excel file
5. Can be converted to BDD approach by adding cucumber, and step definition 


**For non functional testing**
jmeter can be used to validate the performance of the application. This is not setup due to time constraint.
