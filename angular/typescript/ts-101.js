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
var num = 10;
//num = 'testing';
var b = true;
var s = 'this is a string';
var arr = [1, 4, 6, 7, 8];
//arr = [1, 5, 'test'];
/*
TUPLE: allow you to express an array where the
type of a fixed number of elements is known, but
need not be the same
*/
var kv = [1, 'Genesis'];
//generic array types 
var arr2 = [1, 5, 7, 8];
//can arrays have fixed sizes?
/*
Enums - a way of giving names to sets of numeric values
*/
var Days;
(function (Days) {
    Days[Days["Monday"] = 0] = "Monday";
    Days[Days["Tuesday"] = 1] = "Tuesday";
    Days[Days["Wednesday"] = 2] = "Wednesday";
    Days[Days["Thursday"] = 3] = "Thursday";
    Days[Days["Friday"] = 4] = "Friday";
})(Days || (Days = {}));
;
var today = Days[4];
var yesterday = Days.Thursday;
//FUNCTIONS
//we can now give functions both parameter types and return types 
function add(a, b) {
    return a + b;
}
function doThings() {
    return 'test';
}
function voidType() {
    console.log('simply does not return a value. ');
}
function neverType() {
    //this means that the end of the method is unreachable
    throw new Error('never reach end of code!');
}
function anotherNever() {
    while (true) {
    }
}
/*
Type Assertions
- a way to tell the transpiler "hey i know what im doing"
- its like a type cast in other languages, but performs
no special checking or restructuring of data. it is purely
used by the transpiler
*/
var something = 'this is a string';
var len = something.length;
var u = {
    id: 1,
    username: 'testuser',
    password: '123',
    useApp: function () {
        console.log('learning things');
    }
};
var o = {
    id: 1,
    username: 'aodijasoig',
    password: 'adgg'
};
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
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(5, 6);
console.log(pointA.getDistance());
