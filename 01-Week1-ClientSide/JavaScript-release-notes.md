## JavaScript Release Notes (ECMAScript)
[JavaScript](https://en.wikipedia.org/wiki/JavaScript) has a storied history starting at Netscape in the early 1990's.
Originally named Mocha, the name changed to LiveScript, and then finally JavaScript -
mainly as a marketing ploy due to the contemporary popularity of Java as a programming language.
Despite the similar name, JavaScript is not related to or based on Java in any way.

[ECMAScript](https://en.wikipedia.org/wiki/ECMAScript) was developed in 1997 as a technical scripting-language specification
in order to standardize JavaScript. JavaScript remains by far the most popular
implementation of ECMAScript. The major releases of ECMAScript are below:

### ES3
Released in 1999, this version provided the basis for early web client-side scripting.
Major features introduced included:
* Regular expressions
* Exception handling with `try/catch/finally` blocks
* Better string handling
* Formatting for numeric output

### ES5
ES4 was abandoned due to disagreements among contributors, and ES5 was released in 2009.
Major features include:
* `strict` mode
* new `Array` methods
* Support for JSON: `JSON.parse()` and `JSON.stringify()` methods
* Property getters and setters
* Reserved words can be used as property names
* Multi-line string literals - escape the end of the line with a backslash (`\`)
* `Date.now()` method

### ES6 / ES2015
Originally called ES6, this version was renamed ES2015 and was released 6 years after ES5.
This is a **major** new release and provides next-generation functionality and syntax
used commonly used in modern JavaScript. [Here is an entire site](http://es6-features.org)
describing the new features. The highlights:
* Block-scoped variables (`let`) and constants (`const`)
* Default parameter values
* `class` syntax
  * `static` members
  * getters/setters within classes (`get/set`)
* Modules
* Arrow functions (`(param) => {...}`)
* Template literals - using the backtick (``` ` ```)
* Iterators
* `for-of` loops
* Generator functions
* Rest parameter / Spread operator (`...`)
* String interpolation for single and multi-line strings - ```var message = `Hello, ${customer.name}` ```
* Destructuring assignment
* `Symbol` primitive type
* Data structures
  * `Set`, `Map`, `WeakSet`, `WeakMap`
* Promises

### ES7 / ES2016
After ES6, it was decided a new version would be released every year, so ES7 was
released in 2016. Thus, it is a smaller release with only two new features:
* `Array.prototype.includes()`
* Exponentiation operator - `**`

### ES8 / ES2017
Again, a minor release with a few new features:
* `Object.entries()` and `Object.values()`
* `async` / `await` syntax for simplifying Promise handling
* String padding with `String.padStart()` and `String.padEnd()` functions

### ES9 / ES2018
The newest version of JavaScript, containing the following features:
* Asynchronous iterators
* `Promise.prototype.finally`
