# DVD Library Application

## Wiley Edge Training - Project 2

*Trainee: Haaris Iqbal*

*Date: November 2022*

---

This program is a maven project made in IntelliJ, containing 6 Java files, 2 JUnit tests, a .txt file (acting as a psedo database) and this README.md file. The project has been organised in the MVC design pattern.

Test Driven Development methodology was used to write DVDLibraryDao.java and DVD.java. Appropriate JavaDoc has been applied to all functional files and Java code conforms to Google Checkstyle.

Below is an overview of some of these parts.

### App.java

The primary purpose of this class is to call an 'execute' method that will trigger the controller, and subsequently start program. It is included in the controller package.

### DVDLibraryController.java

This class is the 'brain' of this application, and its included in the controller package to act as the interface between the UI, the DAO and the DTO.

It featues several private methods that interact with the other MVC componenets to orchestrate the program. It instantiates and controls the DAO, DTO and UI used in the program.

Key improvement: In this version of the application, (for simplicity sake) duplicate titles are not allowed. This is a desicion that could be reconsidered, as DVDs may have duplicate titles while having different attributes.

### DVDLibraryDao.java

This class is the 'memory' of this application, used by the controller to access DVD objects (data access object).

It features mutiple public methods that processes DVDs and DVD information, and it uses multiple private methods to read and write to a DVDLibrary.txt file (which is effectively the database of this applicaton).

Rather than an ArrayList, a HashMap was implemented for faster reading of DVD objects.

Thoughtful design desicions were made in the process of development. For example, the get() method of this DAO is general-purpose.

There is a DVDLibraryDao JUnit test present in this project, as this was developed using TDD.

Some possible improvements: 
- The addDVD() method of this class currently allows for duplicates. Duplicate check is implemented in the controller. However, this could also be implemented here.
- Design could still be improved by refactoring to eliminate simialar private and public methods.
- During TDD, some more corner cases could have been tested for greater robustness.

### DVD.java

This class is used by the DAO to represent DVDs (data transfer object).

The DVD object features appropriate attributes. It also has a full suite of getter and setter methods.

There is a DVD JUnit test present in this project, as this was developed using TDD.

### View.java

This class is used by the controller to handle user interaction generally.

It features several methods to formulate UI input and output.

Thoughtful design desicions were made in the process of development. The US is well-space and features helpful error messages. And internally, diplicate code is avoided by having general purpose methods (for example found() and notFound() is used by three seperate commands).

A possible improvement would be too generalise some more methods - in particular, edit and add functionality have similarities that could potentially be handled together.

### UserIO.java

This class is used by View to handle raw interaction with the console.

It features multiple input and output options that may be used by View.