# **Aspire Test Automation Framework**

This is an small assignment project related to 'https://aspireapp.odoo.com' site. 
Basically to know the functionality and working of the site.
The assignment is done in Eclipse IDE using Maven project. 

Java selenium + TestNG framework is used for the project. 

### ** Prerequisite to execute projects**

Add Maven to the Path variable

Step 1) Download Apache Maven
First, go to Google search for Maven download and Select  a link from search result "https://maven.apache.org/download.cgi"

Step 2) After the download, unzip the folder and copy it to the folder. (Lets say i have copied to c:\program files\apache-maven-3.8.4).

Step 3) Setting the path of Maven in environment Variables: Search the Environment Variable --> Edit the System Environment variables--> Navigate to Advanced tab --> Environment Variables

		i) MAVEN_HOME : Click New --> Variable Name : MAVEN_HOME , Variable Value: C:\Program Files\apache-maven-3.8.4
	
		ii) M2_HOME : Click New --> Variable Name : M2_HOME , Variable Value: C:\Program Files\apache-maven-3.8.4
	
		iii) Edit the 'Path' Environment Variable --> %M2_HOME%\bin
	
		iv) Go to Command promot  Testing whether Maven is installed: mvn -version
			Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
			Maven home: C:\apache-maven\apache-maven-3.8.4
			Java version: 17.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17.0.2
			Default locale: en_IN, platform encoding: Cp1252
			OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
		
		If you see the Apache Version details like sample above. Apache Maven is successfully installed.


### **To Run the Project**

Step 1 ) Go to Command prompt and go to the respective project location  ( Example for my location c:\users\sachin\git\Aspore_Test)


Step 2 ) Once your in the respective project location, Type Mvn Clean install

Project will execute and it will generate report. 

For Reports Go to "/Sachin_Aspireapp_Test/TestReport/Test-Automaton-Report.html" Open in Chrome browser. 

It generates beautiful HTML reports. We use the extent reports for maintaining logs and also to include the screenshots of failed test cases in the Extent Report.



### **Project Details**  : 

## **Language Used:**
Selenium Project using Java language.
### **Type of Framework:**
Page Object Model design pattern with Page Factory.
### **POM:**
As per the Page Object Model, we have maintained a class for every web page. Each web page has a separate class and that class holds the functionality and members of that web page. Separate classes for every individual test.
### **Packages:**
We have separate packages for Pages and Tests. All the web page related classes come under the Pages package and all the tests related classes come under Tests package.
Add New Package:
Go to src/main/java or src/test/java >> Right click on >> New >> Package.

**@Note **all the tests are kept in the ‘src/test/java‘ and remaining files (such as config.properties, element locators (POM classes), utility files, test data, etc.,) kept under ‘src/main/java‘.\*\*.
### **BaseTest Class:**
Test Base class (TestBase.java) deals with all the common functions used by all the pages. This class is responsible for loading the configurations from properties files, Initializing the WebDriver, Implicit Waits, Extent Reports, and also to create the object of FileInputStream which is responsible for pointing towards the file from which the data should be read.
Add New Page:
Go to src/main/java >> Right click on Page(Package) >> New >> Java class.
### **Add New PageTest:**
Go to src/test/java >> Right click on Test(Package) >>New >> Java class.
### **Utility Class :**
Utility class (TestUtil.java) stores and handles the functions (The code which is repetitive in nature such as waits, actions, capturing screenshots, accessing JSON, etc.,) which can be commonly used across the entire framework. The reason behind creating a utility class is to achieve reusability. This class extends the BaseTest class to inherit the properties of BaseTest in TestUtil.
### **Properties file:**
This file (config.properties) stores the information that remains static throughout the framework such as browser-specific information, application URL, screenshots path, etc.
All the details which change as per the environment and authorization such as URL, Login Credentials are kept in the config.properties file. Keeping these details in a separate file makes it easy to maintain.
### **Screenshots:**
Screenshots will be captured and stored in a separate folder and also the screenshots of failed test cases will be added to the extent reports.
### **Test Data:**
All the historical test data will be kept in an excel/JSON. we pass test data and handle data-driven testing.
### **TestNG:**
Using TestNG for Assertions, Grouping, and Parallel execution.
### **Execution Test:**  ( Another way of Execution) 
Go to TestNg.xml >> Right Click on TestNg.xml>> Run As TestNg Suite.
### **Maven:**
Using Maven for build, execution, and dependency purpose. Integrating the TestNG dependency in the POM.xml file and running this POM.xml file using Jenkins.
### **Version Control Tool:**
We use Git as a repository to store our test scripts.
### **Extent Reports:**
For the reporting purpose, we are using Extent Reports. It generates beautiful HTML reports. We use the extent reports for maintaining logs and also to include the screenshots of failed test cases in the Extent Report.

