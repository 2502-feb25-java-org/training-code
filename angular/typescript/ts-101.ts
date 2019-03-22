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