//'use strict'
//comments
/*dataTypes:
number, string, boolean, object, undefined, NaN
*/
//Variables
/*function func1(){
  alert("x"+x);
}
var y=func1();
alert("y "+y);*/
//var x;
//alert(typeof(x));
//x='$'; //global variables
//y=5.00;
//z="Hello World!!"
// alert(x+y+z);
// alert(z+(x+y));
//alert(typeof(λ));//Infinity/0))//x));//10/'abc');
//truthy and falsy
//falsy= false,0, undefined, NaN, null, ""
//alert(0 =="");
//var undefined=10;
//var arr=[];
//alert(typeof(arr));
//var result=document.getElementById("tbl");
//alert(typeof(result))
//alert(typeof (Math));
//alert(Boolean(NaN))
/*var str=`string 1 \n
string 2`;
alert(`string interpolation 
${str}`)*/

//hoisting
//test(10);
/*function test(x){
   var y=200;
  console.log(`x is ${x}`);
}
test(10);
console.log(y);*/

/*var add = (function () {
     var counter = 0;
      return function () { counter += 1; return counter}
    })();
    var result= add();
    console.log(result);
    result=  add();
    console.log(result);
    result=add();
    console.log(result);
    */

   /* function volume(l, w, h) 
    {
      return l * w * h;
    }
    const curried = _.curry(volume);
   console.log(volume(2, 3, 4)); // 24
    console.log(curried(2)(3)(4)); // 24
    */

   function returns3() {
    return 3;
}
let theFunctionItself = returns3; // a function
let theFunctionsReturnValue = returns3(); // 3


   function varvslet() {
    console.log(i); // i is undefined due to hoisting
    // console.log(j); // ReferenceError: j is not defined
  
    for( var i = 0; i < 3; i++ ) {
      console.log(i); // 0, 1, 2
    };
  
    console.log(i); // 3
    // console.log(j); // ReferenceError: j is not defined
  
    for( let j = 0; j < 3; j++ ) {
      console.log(j);
    };
  
    console.log(i); // 3
    // console.log(j); // ReferenceError: j is not defined
  }


   x = []; // empty array
   x = [1, 2, 3, 4, 5, 'abc', null];
   console.log(x);
   
   x.forEach(function(e) {
       console.log(e);
   });
 //TYPECONVERSION:
        //let info="      123456      ";//null //= true;        
       // info = "Pushpinder Kaur";
       // info = String(info);
       // alert(typeof info);
       // alert(info/"5");
       // alert(Number(info));
        //alert(Boolean(NaN));
        //falsy : null, 0, "", undefined, false, NaN 
        */

//object
x = {}; // empty object
x = {
    name: 'Bill', // properties
    age: 30
};
x.height = 120;
x.height = '6 feet';
// x = x.name; // access properties with dot (.)
x = x['height']; // access properties with indexing ([])

let obj = {
  name: 'Nick',
  sayName: function() {
      console.log('Nick');
  },
  sayName2: function() {
      // "this" refers to the object
      // before the dot when this
      // function is called.
      console.log(this);
      console.log(this.name);
  }
};

let obj2 = {
  name: 'Bob',
  sayName2: obj.sayName2
};

obj.sayName();

obj.sayName2();

obj2.sayName2();


// ES5 has no classes, but it does have constructors
// (we've used Boolean, String)

// name constructors with capital latter
function Person(name, age, fingers) {
  // define data properties of a new Person
  this.name = name;
  this.age = age;
  this.fingers = fingers;

  // define methods/functions of a new Person
  this.sayName = function() {
      console.log(this.name);
  }
}

// we call constructors with the "new" keyword
let nick = new Person('Nick', 26, 10);
console.log(nick);
nick.sayName();
// all that "new" does is...
// 1. make a new empty object ({})
// 2. then call the function you put after
//    the "new" with "this" set to that new object.

// ES5 uses prototypal inheritance to have something LIKE
// a "class heirarchy" without classes.

// a "Student" will have everything a Person has, and also
// a "school" property.
function Student(name, age, fingers, school) {
  this.school = school;
  this.__proto__ = new Person(name, age, fingers);
}

// the way property access works in JS is, if we try to access
// a property on an object, and it's not defined on that object

// ... we fall back to that object's prototype, and on and on
// until we hit Object (which has no prototype).

let student = new Student('Bill', 50, 10, 'UW');
student.fingers = 12;
console.log(student);
console.log(student.name);

console.log({});
console.log({}.toString());

// in ES6, we can use classes instead of old-fashioned constructors and prototypes

class PersonClass {
  constructor(name, age, fingers) {
      // define data properties of a new Person
      this.name = name;
      this.age = age;
      this.fingers = fingers;
  }

  // define methods/functions of a new Person
  // this is called "method" syntax for adding a function property to an object.
  sayName() {
      console.log(this.name);
  }
}

// (method syntax works on objects too)
let x = {
  returns3() {  // new in ES6 (i think)
      return 3;
  }
}

// PersonClass will be the parent class of StudentClass
class StudentClass extends PersonClass {
  constructor(name, age, fingers, school) {
      // "super" means, the parent class's constructor
      super(name, age, fingers);

      this.school = school;
  }
}

let student2 = new StudentClass('Mehrab', 90, 5, 'UH');
console.log(student2);
// ES6 classes are essentially just syntactic sugar around prototypal inheritance