# **Aspire Test Automation Framework**

This is an small assignment project related to 'https://aspireapp.odoo.com' site. 
Basically to know the functionality and working of the site.
The assignment is done in Eclipse IDE using Maven Quick-start project. 
-Java selenium + TestNG framework is used for the project. 

### **To Run the Project**
1) ** Import the project to Eclipse**
<br/> 2) ** Right Click on the project and Select Run as maven clean Test**  Or Go to Commond prompt with respective location and Type mvn clean test
<br/> 3) ** Right Click on the project and Select Run as maven install**  Or Go to Commond prompt with respective location and type mvn clean install

Project will Execute and Report will generated under the TestRport section refer the "Test-Automaton-Report.html" 
 


### **Language Used:**
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
### **Execution Test:**
Go to TestNg.xml >> Right Click on TestNg.xml>> Run As TestNg Suite.
### **Maven:**
Using Maven for build, execution, and dependency purpose. Integrating the TestNG dependency in the POM.xml file and running this POM.xml file using Jenkins.
### **Version Control Tool:**
We use Git as a repository to store our test scripts.
### **Extent Reports:**
For the reporting purpose, we are using Extent Reports. It generates beautiful HTML reports. We use the extent reports for maintaining logs and also to include the screenshots of failed test cases in the Extent Report.

