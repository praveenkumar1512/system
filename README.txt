		------------------------Project (redBusProject)------------------------------
Prepared by - Praveen Kumar

Project Name - RedBusProject
Project type :
	- java with selenium maven project
	- POM(proper use of page object model)

Java Version - 10.0.2
Environment	- Automation testing

Resources (folder): 
		chrome driver - (chrome driver)
		Gecko driver - (firefox driver)
		RedBusTestData.xlsx - (User has the ability to selective run the test cases by marking yes in the "Execution Required" field in excel.)

test-output (folder):
		config.properties (Properties file).
		pom.xml   (pom file - all the dependencies and plugins).
		testng.xml (testng file).

Note :  - in property file you have an option to run the test cases in headless mode.
	- you can change browser from property file(following browsers Chrome, FF ).

1. src/main/java :-
		>com.excel.utility
			XLS_Reader.java (java class to read the data from Excel file).

		>com.log4j
			Log4jtest.java (java class to user logger).
			
		> com.pages
			1. About_RedBus_Page.java  (java class is use to find about 'About us' Page element locators ).
			2. LoginPage.java (java class is use to find about 'Login' Page element locators ).
			3. Bus_Hire_Pages.java  (java class is use to find about 'Bus_Hire' Page element locators ).
			4. ManageBookingPage.java  (java class is use to find about 'Manage Booking' Page element locators ).
			5. RedBus_Colombia_Page.java  (java class is use to find about 'redBus Colombia' Page element locators ).
			6. RedBus_JoiOperator_Page.java  (java class is use to find about 'redBus JoiOperator' Page element locators).
			7. RedBus_Partners_Page.java  (java class is use to find about 'redBus Partners' Page element locators ).
			8. RPool_Page.java :- (java class is use to find about 'rPool' Page element locators ).
			9. TripPage.java  :- (java class is use to find about 'Trip' Page element locators ).
		
		>com.utils
			1. ExplicitWaitClass.java (java class is use for EXplicit wait for elements).
			2. RedBusScreenShots.java (java class is use to capture screenshots).
			
Note:- Reusable libraries for both the classes(ExplicitWaitClass.java and RedBusScreenShots.java) are in jar,
 and i have used dependency in pom.xml file.


2. src/main/resources
		1. log4j.properties (is use to define log4j  properties).
3. src/test/java :-
		> com.execution
			1.Executiontest.java (java class is use to check Execution is Required or not).
		
		> com.tests
			1. BaseTest.java (java class is use to define the driver setup, and Extent report).
			2. About_RedBus_Page.java  (java class is use to define test cases for 'About us' ).
			3. LoginTest.java (java class is use to define the test cases for Login page).
			4. Bus_Hire_Pages.java  (java class is use to define test cases for 'Bus_Hire').
			5. ManageBookingPage.java  (java class is use to define test cases for 'Manage Booking').
			6. RedBus_Colombia_Page.java  (java class is use to define test cases for 'redBus Colombia').
			7. RedBus_JoiOperator_Page.java  (java class is use to find about 'redBus JoiOperator').
			8. RedBus_Partners_Page.java  (java class is use to find about 'redBus Partners' Page ).
			9. RPool_Page.java :- (java class is use to find about 'rPool' Page ).
			10.TripPage.java  :- (java class is use to find about 'Trip' ).
						
		
4. src/test/resources

5.FailedTestScreenShots (folder) - save screenshots only fail test cases

Required installation - Jenkins and Git.
Signin  on Github and save project repository.
	install the required plugins.

Run from CMD Run :
	go to RedBusProject Location and open cmd
	1.mvn test
	2.mvn install
	3.mvn clean
	4.mvn clean install 
	
	
