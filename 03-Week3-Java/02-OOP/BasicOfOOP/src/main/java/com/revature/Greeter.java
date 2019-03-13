//Naming Convention: Packages - small.case, 
//Classes: ProperCase Interface: ProperCase - Nouns
//Variable($,_,1), methods (verbs): camelCase
//CONSTANTS: UPPERCASE
package com.revature;

class Greeter {
    private String name;

    // public Greeter(){//NoArgs Constructor
    // name="Pushpinder Kaur";
    // }
    public Greeter(String name) {// Parameterized Constructor
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
abstract class Person{
    String name;//variables
    String ssn;
    final String SPECIEID="HOMOSAPIENS" ;//constant
    public Person(String name, String ssn){
        this.name=name;
        this.ssn=ssn;
        //SPECIEID="dfgdhg";// cannot assign a value to constants
    }
    protected abstract String getMoreDetails();// method declaration
    protected String getDetails()
    {
        return name  +' '+ssn+' '+SPECIEID;
    }
}
/**
 * Employee extends Person
 */
class Employee extends Person {
    double salary;
    public Employee(String name, String ssn, double salary ){
        super(name, ssn);
        this.salary=salary;
    }
    //@Override
    public String getDetails(){
        return "Name- "+name  +" SSN-"+ssn+" Salary-"+salary;
    }
    @Override
    public String getMoreDetails(){
        return "Name- "+name  +" SSN-"+ssn+" Salary-"+salary+ " Specie Id- "+SPECIEID;
    }
}