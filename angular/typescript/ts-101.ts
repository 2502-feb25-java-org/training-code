/*
TypeScript is a superset of JS, meaning that any valid 
JS code is also valid TS code, however TS code must be 
TRANSPILED into JS code. 
(not compiled, in the sense of turning our code into some
    sort of bytecode but transpiled turning our TS into 
    valid vanilla JS to be interpreted by the browser)

- TS allows for strict typing, arrow notation, interfaces, 
classes, constructors, access modifiers, properties, and 
modules

- Strict typing is optional but it is encouraged 
- number, boolean, string, void, null, undefined, any, never
*/


//Types -- TS allows for strict typing 
let num: number = 10;
//num = 'testing';

let b: boolean = true;

let s: string = 'this is a string';

let arr: number[] = [1, 4, 6, 7, 8];
//arr = [1, 5, 'test'];

/*
TUPLE: allow you to express an array where the 
type of a fixed number of elements is known, but 
need not be the same 
*/

let kv: [number, string] = [1, 'Genesis'];

//generic array types 
let arr2: Array<number> = [1, 5, 7, 8];

//can arrays have fixed sizes?

/*
Enums - a way of giving names to sets of numeric values
*/
enum Days {
    Monday, Tuesday, Wednesday, Thursday, Friday
};

let today = Days[4];
let yesterday = Days.Thursday;

//FUNCTIONS
//we can now give functions both parameter types and return types 
function add(a: number, b:number ): number {
    return a + b;
}

function doThings(): any{
    return 'test';
}

function voidType(): void{
    console.log('simply does not return a value. ');
}

function neverType(): never{
    //this means that the end of the method is unreachable
    throw new Error('never reach end of code!');
}

function anotherNever(): never{
    while(true){

    }
}

/*
Type Assertions 
- a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs 
no special checking or restructuring of data. it is purely
used by the transpiler 
*/

let something: any= 'this is a string';
let len: number = (<string>something).length;

/* INTERFACES
Defining an interface in TS allows you to type-check
combinations of variable objects. They do not transpile to JS
They exist solely to help developers

As we know, the syntax for defining JS objects is 
let obj = { key : value};

we also know that when declaring variables of types, we have the
syntax let var: type = value

We cannot strictly type properties of variable objects 
without using interfaces
*/
interface User{
    id: number;
    username: string;
    password: string;
    socialMedia? : string;
    useApp(): void;
}

let u: User = {
    id: 1,
    username: 'testuser',
    password: '123',
    useApp: () =>{
        console.log('learning things');
    }
}

let o = {
    id: 1, 
    username: 'aodijasoig',
    password: 'adgg'
}

/* CLASSES
classes in TS are similar to classes in most OOP languages 
properties are made public by default but can be made private 
or protected
- when a member is private, it cannot be accessed from outside 
of its containing class
- protected acts similarly to private, except members declared 
protected can also be accessed in deriving classes 
- public entities can be accessed anywhere 
 */

 class Point{
     x: number;
     y: number;

     constructor(x: number, y: number){
         this.x = x;
         this.y = y;
     }

     getDistance(){ //from (0,0)
        return Math.sqrt(this.x*this.x + this.y*this.y);
     }
 }

 let pointA = new Point(5, 6);
 console.log(pointA.getDistance());

 //inheritance 

 class Point3D extends Point{
     z: number;

     constructor(x: number, y:number, z:number){
         super(x, y);
         this.z = z;
     }

     //overriding Point's get distance. must be of the same return type
     getDistance(){
         let dist = super.getDistance();
         return Math.sqrt(dist**2 + this.z**2);
     }
 }

 //private Access modifier -- only accessible within a class
 class Animal{
     private name: string;
     constructor(name:string){
         this.name = name;
     }

     getName(): string{
         return this.name;
     }

     setName(name: string): void{
         this.name = name;
     }
 }

 let pup = new Animal('Max');
 console.log(pup.getName());

 //protected access - only accessible within a class and its subclasses
 class Person{
     protected name: string;
     constructor(name: string){
         this.name = name;
     }
 }

 class Employee extends Person{
     private department: string;
     constructor(name: string, department: string){
         super(name);
         this.department = department;
     }
     
     //fields are public by default, but we can still use the modifier 
     public getElevatorPitch(){
         return `Hello! My name is ${this.name}, I am an employee 
         in the ${this.department} department`;
        }
 }

 /* READONLY modifier
    You can make properties read only. 
    These properties must be initialized at their declaration or in the constructor
    Allows you to work in a functional way(unexpected mutation is bad)
    Can use modifier in interfaces as well. Can be initialized but not reassigned
*/
class Car{
    readonly brand: string;
    readonly numWheels: number = 4;

    constructor(brand: string){
        this.brand = brand;
    }
}

let c = new Car('Benz');
// c.brand = 'Honda';
// c.brand = 'BMW';



/*  STATIC
Thus far, we've only discussed instance members of a class. But it's important
to note that we have static members, which are visible on the class itself
and not instances
*/

class Calculator{
    static add(a: number, b: number):number{
        return a+b;
    }

    static subtract(a:number, b:number):number{
        return a-b;
    }
    
    test(){
        return 'this is an instance method';
    }
}
let numb = Calculator.add(10, 3);
let calc = new Calculator();
calc.test();

/* ABSTRACT CLASS
Abstract classes are base classes from which other classes may be derived. They
may not be instantiated directly. Unlike an interface, an abstract class may
contain implementation details for its members. The abstract keyword is used
to define abstract classes as well as abstract methods within an abstract class

Methods within an abstract class that are marked abstract have no implementation
and must be implemented in derived classes; they must use the abstract keyword;
*/
abstract class Account{
    abstract generateReports():void;
}

class CheckingAccount extends Account{
    generateReports(){
        console.log('concrete');
    }
}


//Typescript also supports 
//https://www.typescriptlang.org/docs/handbook/generics.html