Installation
------------

Without IDE in command line:
TODO!


In Netbeans or Eclipse:
Open as existing Maven project in Netbeans or Eclipse. 
Edit project properties and ensure the context path (in Netbeans run submenu) is set to '/'. 
Create connection pool in Glassfish admin console (or the Java EE 7 application server of your choice):
 - new JDBC connection pool (NOTE: set these values according to your local database location and type):
    - pool name: AlchemyCodingTestPool
    - resource type: javax.sql.DataSource
    - datasource classname: com.mysql.jdbc.jdbc2.optional.MysqlDataSource
    - description: Connection Pool for AlchemyCodingTest RESTful WS App
    - add these properties to the connection pool (NOTE: set these values according to your local database location):
        - URL = jdbc:mysql://localhost:3306/alchemytectest
        - url = jdbc:mysql://localhost:3306/alchemytectest
        - User = XXXXX
        - Password = YYYY


- Create JDBC resource which uses the connection pool.
    - JNDI name: jdbc/alchemycodingtest
    - connection pool: AlchemyCodingTestPool
    - description: DB for AlchemyCodingTest RESTful WS App


TODO:
create a table in your db and put 1 line of sample data in it (e.g. ...)
may have to set context root for app to "/" in app server admin interface (e.g. glassfish admin console).


Test if webservices are working:
    - launch the appliacation and then try to access the Webservices API of the application, e.g. like this:
        http://localhost:8080/api/expenses/
        http://localhost:8080/api/expenses/1
        http://localhost:8080/api/expenses/1/2

    - then try to access the HTML part of the application:
        http://localhost:8080/default.html





Goal
====
Produce a simple web-app backend to complement the supplied front-end code. Note that the front-end renders nicely in Chrome but has some issues in Firefox. This is deliberate - see the 'Extra Credit' section.

Mandatory Work
--------------
Fork this repository. Starting with the provided HTML, CSS, and JS, create a Java-based REST API that:

1. Saves expenses as entered to a database.
2. Retrieves them for display on the page. 
3. Add a new column to the table displaying the VAT amount for each expense.
4. Alter the README to contain instructions on how to build and run your app.

VAT is the UK’s sales tax. It is 20% of the value of the expense, and is included in the amount entered by the user.

Give our account `alchemytec` access to your fork, and send us an email when you’re done. Feel free to ask questions if anything is unclear, confusing, or just plain missing.

Extra Credit
------------
There are rendering issues in Firefox. See if you can fix them.


Questions
---------
##### What frameworks can I use?
That’s entirely up to you, as long as they’re OSS. We’ll ask you to explain the choices you’ve made.

##### What application servers can I use?
Anyone you like, as long as it’s available OSS. You’ll have to justify your decision. We use dropwizard and Tomcat internally. 

##### What database should I use?
MySQL or PostgreSQL. We use MySQL in-house.

##### What will you be grading me on?
Elegance, robustness, understanding of the technologies you use, tests, security. 

##### Will I have a chance to explain my choices?
Feel free to comment your code, or put explanations in a pull request within the repo. If we proceed to a phone interview, we’ll be asking questions about why you made the choices you made. 

##### Why doesn’t the test include X?
Good question. Feel free to tell us how to make the test better. Or, you know, fork it and improve it!
