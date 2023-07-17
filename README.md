# APIAutomationAssignment

This project is created as my API Automation assignment for my Automation Tester Application at Assurity Consulting. The details on how I created, how to use, and what are the tools, libraries, etc. used in this project is written in this **README** document. 

## API Details
Based on the email sent, here are the API details:
- URI:  _https://api.tmsandbox.co.nz_
- Resource: _/v1/Categories/6327/Details.json_
- Parameter:
  - key: catalogue
  - value: _false_
 
## Acceptance Criteria
- Name = _"Carbon credits"_
- CanRelist = _true_
- The Promotions element with Name = _"Gallery"_ has a Description that contains the text _"Good position in category"_

## The Project Framework
The project is built using different tools and frameworks especially for API automation. Such tools are:
### Maven
Maven is a build automation tool used primarily for Java projects. I utilized this tool for the creation of project folder and for managing the dependencies. Here are the dependencies written in the pom.xml that I used in the project:

```xml
<dependencies>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>7.11.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>7.11.2</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.3.0</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

### Cucumber 
Cucumber is a software tool that supports behavior-driven development. I used this as the base framework of my project by utilizing the feature file, step definition class, test runner class and cucumber HTML reports.
- Feature file - where the step by step process of the automation script is located, written in Gherkin format.
 <img width="131" alt="image" src="https://github.com/ajabarentos/APIAutomationAssignment/assets/129655196/69b55e0e-a702-4cb1-a8d1-0ec3a14a8261">

- Step Definition class - where you can find the java method definition of each feature file step.
 <img width="161" alt="image" src="https://github.com/ajabarentos/APIAutomationAssignment/assets/129655196/da58a684-dfbf-4a3a-a866-f66725eea42a">

- Test Runner class - the class that controls the execution of the automation, where you set the configurations.
 <img width="157" alt="image" src="https://github.com/ajabarentos/APIAutomationAssignment/assets/129655196/b858b125-1481-47f5-9292-fab0ab9d1c3c">

- Cucumber HTML Reports - the summary report of the automation execution in HTML format.
 <img width="886" alt="image" src="https://github.com/ajabarentos/APIAutomationAssignment/assets/129655196/491f30c4-1113-4c62-ac53-b6cc8cf16e9a">


### Rest Assured
It is a Java-based library that is used to test REST Web Services. I chose this library for the actual automation testing of the API. I utilized the **RestAssured** and **Response** class and their methods for the setup of URI, parameter, resource, method, etc. and also for validation. Here are some smmples of the methods written in the step definition class.

```java
public void setBaseURI(String url) {
		RestAssured.baseURI = url;
	}
```
```java
public void sendGetRequest(String resource) {
		response = get(resource);
	}
```
```java
public void setParameter(String paramKey, String paramValue) {
		boolean parsedParamValue = Boolean.parseBoolean(paramValue);
		given().queryParam(paramKey, parsedParamValue);
	}
```
```java
public void validateStatusCode(int statusCode) {
		response.then().statusCode(statusCode);
	}
```





  


