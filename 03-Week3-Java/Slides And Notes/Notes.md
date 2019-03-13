# Java
Java is an object-oriented programming language and a platform developed by Sun Microsystems (eaten by Oracle). Using the principle of **WORA** (Write Once, Run Anywhere), a Java application can be compiled and executed on any platform supported by Java. Flexible, popular, and well-supported, Java has helps developers write scalable client-server web applications, desktop and mobile applications, and frameworks and libraries.

## Features
- **Platform independence**: The compiler converts source code to bytecode, then the JVM executes that bytecode. While each operating system has their own JVM implementation, so every JVM can execute bytecode regardless of origin of said code.

- **Clear, verbose syntax** Java has C-like syntax like C++ and C#, many syntax elements of the language are readable and widely used in programming. The Java API (Application Programming Interface) is also written using verbose, descriptive naming conventions making it simple to parse large code bases.

- **Multi-paradigm** While Java is object-oriented, it supports multiple paradigms such as imperative, generic, concurrent, and functional.

- **Garbage collection** The JVM performs automatic memory deallocation of unused objects at runtime. Programs are written without the need for complex memory management.

- **Multithreading** Java supports multithreading at both language and the standard library levels. It allows concurrent and parallel execution of several parts of a Java program.

- **Object-Oriented Programming** Although Java accommodates several paradigms, OOP is the foundation for most applications. In OOP, a program is organized into objects encapsulating related fields (representing its *state*) and methods (usually to control that state or perform related functions). When defining objects, Java reserves the keyword *class* (not to be confused with the *.class* file extension) which serves as their blueprint. An object in Java represents an instance in memory of a class, and also every class implicitly inherits from the *Object* superclass which provides useful convenience methods such as *equals()* and *toString()*. Java popularized several 'Pillars' of OOP design theory. While the numbers vary between OOP languages, Java focuses on four:

    - *Abstraction* - By simplifying objects to a set of useful features, we hide irrelevant details, reduce complexity, and increase efficiency. Abstraction is important at all levels of software and computer engineering, but essential to designing useful objects. Complicated real-world objects are reduced to simple representations.

    - *Encapsulation* - Objects should group together related variables and functions and be in complete control over them. So the state of an object should only change, if ever, through the object itself. Also known as data hiding, because the object has sole responsibility for its fields, and no outside object or function should interfere.

    - *Inheritance* - Code reuse is an important principle of programming (DRY - Don't Repeat Yourself), and new classes can reuse code from existing ones. This establishes a superclass-subclass (or parent-child) relationship where the derived classes inherit (and sometimes change) fields and methods from its parent.

    - *Polymorphism* - With inheritance, an object of a derived class can be referenced as instances of its parent class. This provides flexibility when invoking inherited methods with varying implementations in derived classes.

## Variables
A value is stored and identified in memory by a variable. Variables have a name that makes it possible to access the value, and a type that defines what sort of value it stores.
```java
int variableName = 64;
String txtVar = "Hello World";
```

## Primitive data types
Java handles two kinds of datatypes: primitives and references. Primitives are variables that store simple values. There are eight in Java.
- Integer types: **byte**, **short**, **int**, and **long** (42)  
- Floating-point types: **float**, and **double** (3.1415)  
- Logical types: **boolean** (true)  
- Character type: **char** ('x')

## Reference types
Reference types store the memory address location of more complex data types in the heap. Reference types include:
- Classes
- Interfaces
- Enums
- Arrays

## Naming variables
- Case sensitivity
- Can only use letters, numbers, and *$* or *_* characters
- Cannot begin with a number
- Cannot be a reserved Java keyword

## Scopes of a variable
A variable's reference will only exist within the context of its declared scope, which is based on the location of its declaration.

- **Static** or class scoped variables are visible to all instances of a related class.
- **Instance** or object scoped variables are visible to only that object instance.
- **Local** or method scoped variables are visible only within a method.
- **Block** or loop scoped variables are visible only within a block statement.

Be aware of *shadowing*: when two variables in different scopes share names.

## Methods
Methods accept a list of arguments known as *parameters* and return some value. They are used to implement repeatable, consistent actions on variable input, much like math functions.
```java
public int myMethod(int a, int b);
public int myMethod(int a);
```

## Constructors
Classes not only define object fields and methods, but how it should be instantiated through special methods called constructors. Constructors must have no return type and share the same name as its class. Java will automatically give you a *noargs* constructor. However, if you define any constructor, you will lose the automatically given constructor.

While a constructor may be *private*, used for singletons, it may not be *final*, *static*, or *abstract*.

## Access modifiers
- **private** - accessible only within the context of that class
- **default** - accessible within the context of a package, has no associated keyword so is set when no modifier is used
- **protected** - accessible to the package, but also to derived child classes outside of the package
- **public** - accessible anywhere

Classes should only be public or default. There are no cascading access levels, and unspecified fields will be default. Subclasses can only change inherited fields to be less restrictive.

# Arrays
## Declaration
Java Arrays are special reference types that store similarly typed data iteratively. A pair of brackets define an array of some data type, and can be written anywhere after the type:
```java
// One-Dimensional Arrays
int[] arrayOne;
int []arrayTwo;
int arrayThree[];

// Two-Dimensional Arrays
int[][] 2DArrayOne;
int 2DArrayTwo[][];
int []2DArrayThree[];
```

## Definition
While Java does not allow direct memory access to its arrays like other languages, they are still of fixed size once defined by the `new` keyword or by an array literal.
```java
// One-Dimensional Arrays
int[] instancedArray = new int[3];
int[] literalArray = {1, 2, 3};

// Two-Dimensional Arrays
int[][] instanced2DArray = new int[3][4];
int[][] literal2DArray = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
```

## Iteration
Java for loops can iterate through arrays like most other languages:
```java
// One-Dimensional Arrays
for (int i = 0; i < arrayOne.length; i++) {
    System.out.print(arrayOne[i]);
}

// Two-Dimensional Arrays
for (int i = 0; i < 2DArrayOne.length; i++) {
    for (int j  =0; j < 2DArrayOne[i].length; j++) {
        System.out.print(2DArrayOne[i][j]);
    }
}

// Foreach loops
for (int i : arrayOne) {
    System.out.print(i);
}
```

## Manipulation
The `java.util.Arrays` class provides various methods for manipulating arrays.

```java
int[] messyArray = {234, 5346, 3, 64};
Arrays.sort(messyArray);
System.out.println(Arrays.toString(messyArray));
```

## Varargs
Varargs is a special parameter that can accept multiple arguments of the same type into a dynamically constructed array, and denoted by an ellipsis (...) instead of brackets. A varargs parameter must be the last or only parameter in a method signature. 
```java
varArgMethod("m", 1, 2, 5, 35, 346, 345, 4634);

...

public static void varArgDemo(String m, int... intArgs) {
    for (int i : intArgs) {
        System.out.print(i);
    }
}
```
# Programming and Compiling
Most Java applications only require the **JRE** (Java Runtime Environment). But to write and compile you need the **JDK** (Java Development Kit). While the JRE provides Java's standard libraries and exceptions as well as a JVM, the JDK provides all the above as well as *javac*, the compiler. Java source code is written in text files labeled with *.java* extension. It is then compiled into bytecode in *.class* files by *javac*. Then the bytecode is executed by the JVM, which translates the Java commands into low-level instructions to the operating system.

Since Java 6, all Java programs not run inside a container (such as a Servlet Web Container) start and end with the main method. The class containing the main method can have any name, but the method itself should always be named *main*

```java
class Example {
    public static void main(String[] args) {
        System.out.println("Num args:" + args.length);
    }
}
```

- *public* is a Java access modifier keyword that means the `main` method can be accessed from any method during the program's execution.
- *static* is a Java keyword that means the method can be invoked without creating an instance of the class that contains it, making it a global method.
- *void* is a Java return type keyword that means the method doesn't return any values of any data type.
- *args* is a Java variable of type String array which means the method can take command line arguments as an array of Strings

We can compile this code into a *.class* file of the same name:
>javac Example.java

And to run the resulting `Example.class` file:
>java Example

The `java` and `javac` commands require the full directory path or class path to any source code or binary file respectively. If you have a package `com.demo` in the first line of Example, then you would nest the java file into a `com/demo/` directory and then run:
>javac com/demo/Example.java 

>java com.demo.Example

From here we can add packages and imports, expanding the application into a set of interacting objects. By default, the *javac* compiler implicitly imports several base packages from the standard library.

# Maven 
Build automation and dependency management tool. Once installed, use with the `mvn` command. Allows for a project to be IDE agnostic. See the official Maven project for documentation: http://maven.apache.org/index.html as well as the mvn repository to find available libraries: https://mvnrepository.com/

The minimum `pom.xml` example:
```xml
<project>
	<modelVersion>4.0.0</modelVersion>
	<groupId>YourDomainName</groupId>
	<artifactId>YourProjectName</artifactId>
	<version>0.1.0</version>
</project>
```

## Example commands
Create a new Maven project with the quickstart archetype. Change groupId and artifactId arguments as needed:
>mvn archetype:generate -DgroupId=com.revature -DartifactId=my-first-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Compile class files into target/classes
>mvn compile

Package project into a jar file in target
>mvn package

Remove target folder and compiled build
>mvn clean

Run JUnit tests
>mvn test

# Design Patterns: Dependency Injection
Some classes require another class, a dependency. While the dependency can be defined in the dependant class's own constructor, this introduces several problems such as tightly coupling the two classes and introducing difficulties during unit testing. To solve this, we can inject the dependency as an argument into the dependant class's constructor or setter.

```java
public class Order {
    private Customer customer;

    // Constructor Injection
    public Order(Customer customer) {
        this.customer = customer;
    }

    // Setter Injection
    public setCustomer(Customer customer) {
        this.customer = customer;
    }
}
```

## Testing Benefits
By injecting dependencies, we can more easily test this class without having to also test the dependency which can be independantly tested, if necessary. The injection pattern means that a mocked dependency can be injected in the original dependency's place.

```java
public class MockCustomer extends Customer {
    // Stub methods overriding the super class methods
}
```

```java
public class OrderTest {
    @Test
    public void testMock() {
        Order order = new Order(new MockCustomer);
    }
}
```

# JDBC API
Java Database Connectivity (JDBC) is an API for connecting to a RDBMS such as Oracle, PostgreSQL, or MySQL. As a collection of interfaces it requires a driver from the database vendor on the classpath. Once added, a `java.sql.Connection` is used to send SQL queries with `java.sql.Statement`, `java.sql.PreparedStatement`, or `java.sql.CallableStatement` objects, and retrieve result sets in `java.sql.ResultSet` objects.

```java
// Loading the driver may not be necessary, but it's good to specify
try {
    Class.forName("org.postgresql.Driver");
} catch (java.lang.ClassNotFoundException e) {
    System.out.println(e.getMessage());
}

// Pay attention to the url pattern
String url = "jdbc:postgresql://host:port/database";
String username = "databaseuser"
String password = "password"

try (
    // Be sure to close all connections after use
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
){
    // executeUpdate() returns the number of rows affected for DML
    int rowCount = statement.executeUpdate("insert into pizza values (1, 'cheese')");

    // executeQuery() returns a ResultSet object for queries
    ResultSet pizzas = statement.executeQuery("select * from pizza");

    // Loop through ResultSet for each row returned
    while(pizzas.next()) {
        System.out.println(pizzas.getInt("id"));
        System.out.println(pizzas.getString("flavor"));
    }

} catch (SQLException ex) {
    
} 
```

# Password credentials
Hardcoding url, username, and password is not secure, especially once your source code is pushed to public repositories online. An alternative is to save your information to a properties file:

### connection.properties
```
url = jdbc:postgresql://host:port/database
username = databaseuser
password = password
```

Then, in your Java application, load in the properties using `java.util.Properties`
```java
Properties properties = new Properties();
properties.load(new FileInputStream("connection.properties"));

String url = properties.getProperty("url");
String username = properties.getProperty("username");
String password = properties.getProperty("password");
```
Then simply remember to never add your `connection.properties` file to your git repository.

# SQL CLI program
A demonstration of various JDBC methods
```java
String url = "jdbc:postgresql://host:port/database";
String username = "databaseuser"
String password = "password"
String sql;

// Connect to a Postgres instance and set Scanner to stdin
try (Connection connection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);) {
    // Loop after each user input
    while (true) {
        Statement statement = connection.createStatement();
        System.out.print("sql> ");
        sql = scanner.nextLine();
        if (sql.equalsIgnoreCase("quit"))
            break;

        // Statement.execute(String query) returns true if ResultSet
        boolean isResultSet = statement.execute(sql);
        if (isResultSet) {
            // Get and print column names from metadata
            ResultSet resultSet = statement.getResultSet();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                System.out.print(rsmd.getColumnLabel(j) + "\t");
            }
            System.out.println();

            // Get and print column values from ResultSet
            while (resultSet.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
            resultSet.close();
        } else {
            // If other DML, return rows affection
            System.out.println(statement.getUpdateCount() + " rows affected");
        } 				
        statement.close();
    }

} catch (SQLException e) {
    e.printStackTrace();
}
```

## Statement
A Statement object sends queries and updates, as well as receive errors or ResultSets.

**Statement** is prone to SQL Injection attacks, especially if you use a raw string to write the query.

**PreparedStatement** is a precompiled SQL statement. It is best used for writing several similar queries in a loop, but will also as a side effect protect against SQL Injections
```java
PreparedStatement ps = myConnection.prepareStatement("UPDATE ANIMALS SET name=? WHERE id=?");
ps.setString(1, "Hippo");
ps.setInt(2, 7);
ps.executeQuery();
```
**CallableStatement** execute stored procedures and can return 1 or many ResultSets.
```java
CallableStatement cs = myConnection.prepareCall("{CALL BIRTHDAY_SP(?, ?)}");
cs.setInt(1, aid);
cs.setInt(2, yta);
cs.execute();
```

# Collections API
Java provides the **Collection** interface which provides a framework for several diffrent containers which will be disscussed below. All interfaces except **Map** share **Collection** as their superinterface.  
  
- **List** is an ordered collection of elements. A user has the ability to place an element anywhere in the list. The elements are accessable by their index. Unlike **Set**, **List** typically allows for duplicate elements such that element1.equals(element2). In addition to duplicates, **List** allow for multiple null elements to be stored.  
  
- **Set** is a collection of non duplicate elements meaning there will never exist a situation where element1.equals(element2). In addition to this, it is implied that there can only exist one null element due to the no duplicates rule.  

- **Queue** is a collection of elements who in essence cannot be iterated, instead the **Queue** follows the **FIFO** (First In First Out) rule. When an element is added to the **Queue** it is placed at the back and when an element is pulled it is pulled from the from the front (index :0).  
  
- **Deque** extends **Queue** but augments the ability to insert and remove elements at either end. The name is short for "Double Ended Queue" and is pronounced "Deck".  
  
- **Map** is an interface which stores data with a key. A map cannot contain duplicate keys; each key can map to at most one value. **Map** can be visualized like a dictionary where only one word is paired with one definition.  

## Example Implementations
  
**ArrayList** extends **AbstractList** and implements **List** (among others). **ArrayList** provides a dynamic array implementation. **ArrayList** has a dynimic capacity which is resized when the user fills the container. At all times the **ArrayList** capacity will be either larger or the same size as the number of elements it contians.  
  
**HashSet** extends **AbstractSet** and implements **Set** (among others). **HashSet** implements the **Set** interface which organizes elemts based on a hash map. Due to the hash map, there is no guananteed order of iteration.  
  
**TreeSet** extends **AbstractSet** and implements **NavigableSet**. Elements in the set are ordered using natural ordering (sorted and ascending order). **TreeSet** does not preserve the insertion order of elements but elements are sorted by keys. Alternatively, a Comparator can be passed in the constructor to achieve other orderings. Elements in a **TreeSet** must be homogenous and comparable with the default sorting or else a runtime *ClassCastException* will occur. **TreeSet** is essentially an implementation of a self-balancing binary search tree.  
  
**LinkedList** extends **AbstractSequentialList** and implements **List** and **Deque** (among others). **LinkedList** is implemented using a doubly-linked list (meaning it is iterable both forward and backwards).  
  
**HashMap** is an implementation of the **Map** interface. This container allows for both null keys and elements. Unlike the **Map** keys are generated using a hashing algorithm.  
  
**Hashtable** maps keys to values. Any non-null object can be used as a key or as a value. To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method. The HashMap class is roughly equivalent to Hashtable, except that it is non synchronized and permits nulls. (HashMap allows null values as key and value whereas Hashtable doesn't allow nulls).  
  
![alt text](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/java-collection.jpg "Collections Tree")


# I/O Streams
The JVM can connect to sources of data that exist outside itself, from files on the hard drive to network port sockets and of course the standard input/output channels of a console.
- Byte Input Streams
    - **BufferedInputStream** Reads a buffer of bytes from an InputStream, and then returns bytes from the buffer, making small reads more efficient.

    - **ByteArrayInputStream** Reads bytes sequentially from an array.

    - **FileInputStream** Reads bytes sequentially from a file.

    - **ObjectInputStream** Reads binary representations of Java objects and primitive values from a byte stream. This class is used for the deserialization of objects.

- Character Input Streams
    - **BufferedReader** Reads a buffer of characters from a Reader, and then returns characters from the buffer, making small reads more efficient.

    - **FileReader** Reads characters sequentially from a file. An InputStreamReader subclass that reads from an automatically-created FileInputStream.

    - **InputStreamReader** Reads characters from a byte input stream. Converts bytes to characters using the encoding of the default locale, or a specified encoding.

- Byte Output Streams
    - **BufferedOutputStream** Buffers byte output for efficiency; writes to an OutputStream only when the buffer fills up.

    - **FileOutputStream** Writes bytes sequentially to a file.

    - **ObjectOutputStream** Writes binary representations of Java objects and primitive values to an OutputStream. Used for the serialization of objects.

- Character Output Streams
    - **BufferedWriter** Buffers output for efficiency; writes characters to a Writer only when the buffer fills up.

    - **FileWriter** Writes characters sequentially to a file. A subclass of OutputStreamWriter that automatically creates a FileOutputStream.

    - **OutputStreamWriter** Writes characters to a byte output stream. Converts characters to bytes using the encoding of the default locale, or a specified encoding.

    - **PrintWriter** Writes textual representations of Java objects and primitive values to a Writer.
