# JDBC
How to do CRUD Operation using JDBC
----

----
##### 1st Step
Create a Maven Project 

** How to create Maven Project **

* Go to file 
* New 
* Select Maven Project 
* Check the Simple project 
* Give file location 
* Click on Next 
* Give GroupId which is package name 
* Give ArtifactId which is Project Name 
* Finish

*If got any error in the Maven Project*

* Right click on the Maven Project 
* Click on Maven 
* Update 
* Check the checkbox of force update
* Next

##### 2nd Step 
Add the Persistence code in the pom.xml file within dependencies tag.

** How to add the persistence code **

* Search [Maven Repository](https://mvnrepository.com/) 
* Then search for Mysql Connector and click on the result with high usages 
* Click on the version with high usage 
* Copy the dependency codes 

##### Final Step
Write the codes.

----

### Steps To Connect To The Database & Writing The Codes


1 Load & Register the Driver <br>
2 Establish the Connection <br>
3 Create a Statement <br>
4 Execute the Statement <br>
5 Process the Result <br>
6 Close the Connection <br>

---

#### Explanation Regarding Steps To Connect

* **Load & Register the Driver**

###### Class.forName("Path of the Driver File"); <br>
Path -> com.mysql.cj.jdbc.Driver
If the path is wrong i.e. Class is not found then it will throw ClassNotFoundException <br>
That's why we have to enclose it within **try/catch block** or Add **throws declaration**

* **Establish the Connection**

##### DriverManager.getConnection("Path of database with schema name", "User Name" , "Password"); <br>
To establish the connection we have **DriverManager class** which is an inbuilt class which belong to java.sql package which is internally connect with JDBC API. <br>
In DriverManager we have **getconnection static method**, which is overloaded by different arguments. <br>

These will return Connection Interface which belongs to 'java.sql' package , it is present in JDBC API.<br>
We cannot create objet of Interface , so we create reference variable of interface type.

**Connection referene_variable = DriverManager.getConnection("Path of database with schema name", "User Name" , "Password");**

Connection connection = DriverManager.getConnection("Path of database with schema name", "User Name" , "Password");


* **Create a Statement**

##### connection.createStatement();
These will return Statement Interface. <br>

**Statement statement = connection.createStatement();**

 Statement Interface have many abstract method like -
 * execute() -> It is used for Insertion -> Return type is Boolean
 * executeQuery() -> It is used for fetching the data from db -> Return type is **ResultSet Interface**
 * executeUpdate() -> It is used for Updating and for Deletion -> Return type is Integer
 
 
 **ResultSet Interface** <br>
 
 ResultSet is an interface whih belongs to 'java.sql' package. <br>
 In ResultSet we have abstract method like - <br>
 next(), getInt(), getString(), getDouble() based on the datatype.
 
 
 * **Execute the Statement**
 
 Based on insert,update, fetch, delete it have different statement
 
 * For Insertion -> boolean b = state.execute("Insert into table_name values (? ,?, .....) ");
 * For Fetching/Reading all the data -> ResultSet res = state.executeQuery("SELECT * FROM table_name ");
 * For Fetching/Reading by seletion -> ResultSet res =  state.executeQuery("SELECT * FROM table_name WHERE id = ?");
 * For Updating ->  int row = state.executeUpdate("UPDATE table_name SET key = 'value'where id = ? ");
* For Deleting -> int rows = state.executeUpdate("DELETE FROM table_name WHERE id = ?"); <br>



 
* **Process the Result**

Based on insert,update, fetch, delete it have different types of result

* For Insertion -> It will give boolean value, if it is exeuted it will return false else throw errors.
* For Fetching/Reading -> It will fetch the total records based on query.
For showing all the records a while loop will be needed i.e, 


while(res.next())
		
		{
		According to the number of columns present that number of we have to write the printing statement and according to the value type i.e, integer , float,double etc , we have to use the abstract method
			System.out.println(res.getInt(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
		}

* For Updating -> It will give integer value, i.e. how many rows is effected.
* For Deleting ->It will give integer value, i.e. how many rows is effected.


* **Close the Connection**

##### statement.close();
##### connection.close();
For closing the connection we have abstrat method **close()**.<br>
After completion of the program all the connection need to be closed because connection plays an important role for transferring the data, retrieving the data as it is costlier resource.

---

### Demonstration of the way to Connect

Class.forName("com.cj.mysql.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_static", "root", "****");

Statement state = con.createStatement();

boolean b = state.execute("Insert into demo_table values (1,'Ben',8044322442) ");

System.out.println(b);
		
state.close();

con.close();
