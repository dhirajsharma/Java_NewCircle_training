The examples in this package have been designed to run against a sample Northwind database.

To run the examples:

1) Download MySQL JDBC connector (e.g., mysql-connector-java-5.1.5-bin.jar)
2) Tell JDBC DriverManager about the MySQL driver by passing the following switch to the JVM:
	-Djdbc.drivers=com.mysql.jdbc.Driver
3) Add the driver to the JVM's CLASSPATH:
	-classpath bin:lib/mysql-connector-java-5.1.5-bin.jar
4) Choose the main class that you wish to run. For example: example.jdbc.ListCustomers
5) Specify the MySQL-JDBC URL to your database. 
	The syntax is as follows:
		jdbc:mysql://<host>:<port>/<database>?user=<username>&password=<password>
	For example: 
		jdbc:mysql://localhost:3306/Northwind?user=student&password=secret
6) Specify any additional parameters that examples may require

Note, to create a database user in MySQL do:
GRANT ALL on Northwind.* TO student@localhost IDENTIFIED BY 'secret';

For example:

java -Djdbc.drivers=com.mysql.jdbc.Driver -classpath bin:lib/mysql-connector-java-5.1.5-bin.jar example.jdbc.ShowCustomer "jdbc:mysql://localhost:3306/Northwind?user=student&password=secret" THEBI
CustomerID: THEBI
CompanyName: The Big Cheese
ContactName: Liz Nixon
ContactTitle: Marketing Manager
Address: 89 Jefferson Way Suite 2
City: Portland
Region: OR
PostalCode: 97201
Country: USA
Phone: (503) 555-3612
Fax: null
