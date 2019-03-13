package com.revature;// User Defined Package
//import java.lang.*;-- call to external or internal prebuilt Java packages

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //Greeter greet=new Greeter("Dylan McBee");
        //greet.setName("Pushpinder Kaur");
        //String name=greet.getName();
        //System.out.println("Hello "+name);

        //Person p=new Person("Pushpinder Kaur", "123fhjg2");
        //System.out.println(p.getDetails());

        Person emp=new Employee("Carol Baxtor", "123jghj", 200.50);//Upcasting
        //Person emp1=new Person("Carol Baxtor", "123jghj");//Downcasting
        Employee emp2=(Employee)emp;//Downcasting 
        System.out.print(emp2.getDetails());
    }
}
