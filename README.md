## Project Introduction
You have been provided with access to a real database server that contains only one table (country), and have been tasked to develop a Java program in charge of:
* Retrieve all records stored in the database table
* Retrieve records by country name
* Retrieve records by country code
* Add new records into the database
## Specific Requirements
* Required to implement the Data Access Object pattern, in combination with any other two creational patterns.
* Have to create a simple CLI client program to test implementation of the patterns.
The client program should not have any direct contact with the database and should
pass and receive data in the form of objects (instances of a Country class).

The client program must present the user with a menu with the following options:
* List all countries in the database
* Find a country by country code
* Find a country by name
* Save a new country in the database

## Design Patterns Used
### Singleton enum pattern
It is important to keep the database safe and if we can create just one instance of the 
class to all users access just from one point is good.
In this CA used ENUM singleton because is more secure and prevents 
problems like with Serialization, Deserialization and Reflection.

### Builder Pattern
Aim of the builder pattern is to separate the construction of the object from it representation. 
In this CA it's a good case to build the country object 
that Builder design pattern helps in minimizing the number of parameters 
in constructor like Surface Area and Head Of State can be done by defoult in database.

### DAO Design Pattern
As in this CA the main goal was to minimilize access of the user to the data this pattern
is perfect simple solution.

In the code i have few comment that ask to check README file for more information
This is regarding to thinks that in DB was few tuples with strange symbhols or like the continent was empty so
in code I used querys that can cut off this tuple and dont breack code
