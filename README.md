# AcmeTests
This package contains working example tests for the demo [ACME website](https://demo.applitools.com).  This package
depends on the [WebDriverFacoty](https://github.com/mandutree/WebDriverFactory) to build the WebDriver needed to
control the browser.  It also needs the [AcmePages](https://github.com/mandutree/AcmePages) package, which contains the
page and component objects representing the website.  AcmePages in turn depends on the [ElementHandler](https://github.com/mandutree/ElementHandler)
package, which contains the logic for WebElement interaction.

The binaries for the above three dependencies do not exist in any artifactory.  This means that in order to run these
tests, you must download and build the source code for all 4 packages.  Downloading and building the packages is a
simple process scribed below.

## Prerequisite
### Java
Although this code will likely run with JDK lower than 17, the POM file specifies Java version 17.  During development
I have used the [Amazon Corretto 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html),
but any Java 17 will likely be OK.

### Maven
If you intend to use any IDE, it will likely have built in Maven support.  But if you plan to run the test on the
terminal, you will need to install Maven binaries.  [Here](https://maven.apache.org/download.cgi) is one of many places
where you can get them.  You may need to configure MAVEN_HOME and JAVA_HOME on your computer. 

### Git
Installation step is easy to find on the web.  [Here](https://git-scm.com/) is one of many places where you can get
them.

### Chrome
Ensure that you have chrome installed on the computer.  It is not required that you have the chromedriver downloaded.
It's setup to download the appropriate driver.

## Downloading the packages
First create any folder where you have full access.  You will download all 4 repositories in this folder. eg:
**C:\Users\username\Documents\Demo**

On a terminal navigate to the **Demo** folder and enter commands:

    Demo> git clone https://github.com/mandutree/WebDriverFactory.git
    Demo> git clone https://github.com/mandutree/ElementHandler.git
    Demo> git clone https://github.com/mandutree/AcmePages.git
    Demo> git clone https://github.com/mandutree/AcmeTests.git

## Compile and Run - Terminal
You should have 4 folder like this:

    Mode                 LastWriteTime         Length Name
    ----                 -------------         ------ ----
    d-----         1/13/2023   2:09 PM                AcmePages
    d-----         1/13/2023   2:10 PM                AcmeTests
    d-----         1/13/2023   2:09 PM                ElementHandler
    d-----         1/13/2023   2:07 PM                WebDriverFactory

### Compile
You need to compile the source code in specific order because of the dependencies. AcmeTests depends on AcmePages and
WebDriverFactory.  AcmePages depends on ElementHandler.  So the compile order might be:

    WebDriverFactory > ElementHandler > AcmePages > AcmeTests

To compile the code, navigate into each folder and execute command: **mvn compile**

    Demo\WebDriverFactory> mvn compile
    Demo\ElementHandler> mvn compile
    Demo\AcmePages> mvn compile
    Demo\AcmeTests> mvn compile

### Run Test
On a terminal navigate to the AcmeTests folder and enter command:

    Demo\AcmeTests> mvn test

## Compile and Run - IntelliJ
I happen to have IntelliJ, so I will use it as example.  But any IDE will work.

IntelliJ will compile all the project in the right order and run it for you, so all you have to do is import it and 
run the test.

### Create a New Project and Configure
Open IntelliJ and create a new project from Existing Sources:

    File > New > Project from Existing Sources...

You need a new workspace folder to store the project information.  I typically use the root folder.  In this example,
that's the **Demo** folder.

At Import Project, select:

    Import project from external model > Maven

You should have an empty Project view.  You can configure the project from the Project Structure.

    File > Project Structure > Project Settings > Project

Select SDK 17 and Language Level 17

### Import the Modules

    File > Project Structure > Project Settings > Modules > + > Import Module

Select the root folder of one of the 4 projects. At Import Module, select:

    Import module from external model > Maven

Do the same for all the modules.

### Run the test
You should now be able to navigate to any test in AcmeTests folder and run one or more test.  The IDE will compile all
the module, in the right order, for you before running the test.
