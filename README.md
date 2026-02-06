This project is an API Test Automation Framework built to validate API endpoints using structured, reusable, and scalable automation practices. It covers end-to-end API testing with support for multiple HTTP methods and robust reporting.
Execution Options-

▶ Run from Command Line

-Ensure testng.xml is configured in the pom.xml.

-Open terminal in the project root directory.

-Run: mvn clean test

This triggers the complete TestNG suite execution.

▶ Run from Jenkins

-Configure a Jenkins job.

-In the Build section, choose Invoke top-level Maven targets.

-Provide the path to pom.xml.

-Use Maven goal: clean test

This enables automated execution through CI/CD.

📊 Reporting

The framework includes Extent Reports for rich HTML reporting: 

-Detailed test steps

-Pass/Fail status

-Logs and execution insights.

🗂 Test Data Management

-Test data is managed using JSON files

-Easy to maintain and update

-Supports multiple data-driven test scenarios

♻ Reusable Components

The framework is designed with modular and reusable architecture:

-JSON-based test data handling

-Configuration file reader utilities

-Advanced Extent Reporting integration

-Retry mechanism for failed tests using TestNG Listeners


🌟 Key Benefits

Efficient execution of test cases, business flows, and user stories

Reduced scripting and manual effort through reusable components

Customizable and detailed reporting

Easy maintenance with or without test management tools

Minimal learning curve for automation engineers

Supports multiple test data iterations

Ready-to-use framework that saves significant setup time

Abstract design allows adaptation to other API automation projects with minimal changes

Improved ROI

Git-based source code management

Seamless CI/CD integration

This framework helps teams accelerate API testing while maintaining high quality, scalability, and maintainability. 
