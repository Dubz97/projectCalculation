# projectCalculation
The 2. semester exam project of the computer science education at KEA

We were given the assignment to develop a project management system for the company Alpha Solutions.
In program you should be able to make a user, login, create/edit/delete a project.
First you would make a new user, after that you would login, after that you can create/edit/delete projects and do the same with the task.
Last thing you can do in program is to see you project.
Progress/Implementation:
 Create a data model for project and time dimensions. (Create the right tables in your database)

We have created a MySQL database with the following tables:
User
Project
Employeetask
We used spring MVC to set up the backend and Thymeleaf as a template engine.

Run
Setup Database
Source the database.sql file in MySQL, to create the projectCalculations database.
2. Navigate to projectCalculation/scr/main/resource and find the file called application.properties
Fill it with the following:

url=jdbc:jdbc:mysql://localhost:3306/projektkalkulation
user=[username]
password=[password]

3. Run application
