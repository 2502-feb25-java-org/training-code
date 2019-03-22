# Introduction to TypeScript

In order to build applications with Angular (nG), you need to be comfortable working with TypeScript. Before we start diving into the Angular framework, let's first acquaint ourselves with the TypeScript language.

### Knowledge goals of this document:

* Type annotations
* Arrow functions
* Interfaces
* Classes
* Constructors
* Access modifiers
* Properties
* Modules

# What is TypeScript?

TypeScript (TS) is a superset of JavaScript (JS). This means that any valid JS code is valid TS code. However, but TS has additional features that do not exist in the current version of JS.

### TypeScript features

* Strong typing (optional, but recommended)
* Object-oriented features (classes, interfaces, enums, access modifiers, generics, etc.)
* Compile-time errors
* Great tooling (Intellisense!)

So, you may wonder why we don't just use TS to code our applications. Why use JS at all if TS is JS with extra features? The reason is because most browsers do not support TS, but all support JS. Because of this, in order to get our TS code to work within the browser it needs to be _*transpiled*_ (a portmandeau of the words _translate_ and _compile_) into JavaScript.

# Installing Node.js & TypeScript to make our first TS app

#### Notes go here for Node.js install...

In order to use TS on our machine, we need to install it globally. In order to do this, we need to make use of the Node Package Manager (NPM) to download the third-party TS package. Open a terminal and enter the following command:

`npm install -g typescript`

To check for success, enter the command below to check your installed version of TS:

`tsc --version`

With TS properly installed we can begin writing our first TS application. Create a file `main.ts`, below is the code we will include in this file:

    function log(message) {
        console.log(message);
    }

    var message = 'Hello, world!';

    log(message);

Back in the terminal, we need to transpile this TS code into JS code so it can be viewed in the browser. To transpile the TS into JS, execute the command:

`tsc main.ts`

This will generate a new file with the same name as our original TS file, but with a JS extension. In fact, when we run our nG applications using `ng serve`, the nG CLI calls the TS compiler to transpile all of our TS code into JS code.

Looking inside of the `main.js`, you will see that the code that we typed in our TS file is exactly the same as the new JS file's contents. This is because the code we typed originally was valid JS code, so there was no need to convert it into anything else.

To execute this code and serve it up, we can use Node.js. Back in the terminal, we execute the command:

`node main.js`

# Declaring Variables in TypeScript

Let's begin our exploration of TS by looking at variable declarations. In TS, there are two ways to declare a variable (no different than ES6 JS, scoping is the exact same):

`var number = 1;`

`let count = 2;`

In our `main.ts` file, let's look at how TS helps us at compile time by pointing out scoping errors that can occur:

    function doSomething() {
        for(let i = 0; i < 5; i++) {
            console.log(i);
        }

        console.log('Finally: ' + i);
    }

Your IDE should show a compilation error on the last `console.log()` statement because the variable `i` is not visible outside of the scope of the `for` block that it was declared within.

It is important to not, that while our IDE shows this as a compilation error within our TS file. The TS compiler will still transpile this code into JS, though it will print an error to the console letting us know that there is an issue. Looking in the generated JS file will show that the issue is actually corrected. The TS compiler transpiled the code, but declared `i` using `var` instead of `let`.

# TypeScript Data Types

One of the main features of TS that sets it apart from JS is its use of strong typing (though this is optional). At this point, open the `main.ts` file found in this repository and review Section 1. 

## TypeScript Data Types

* number
* boolean
* string
* void
* null
* undefined
* never
* any

The `null` and `undefined` data types are often a source of confusion. These data types cannot be used to reference the data type of a variable. However, `null` and `undefined` are _not_ the same thing. A variable initialized with `undefined` means that the variable has no value or object assigned to it. While `null` means that the variable has been set to an object whose value is undefined.

TS also allows users to create their own user-defined types, which includes:

* classes
* interfaces
* enums
* arrays
* tuples

## Continuing on with TypeScript

Please refer to the `ts-demo` files found in this folder to continue learning more about TS and its features. There is file called `ts-exercise.md` that you can use to test your knowledge and get more practice working with TS.

# Changing the target transpilation language

The TS compiler is flexible and can transpile our TS files into several different versions of JS. By default, the target transpilation language is ES5. Using the command below will allow you to transpile into ES6. 

    tsc source-file.ts --target ES6

It should be noted that Node sometimes has issues executing the freshly-transpiled JS. To fix this we include an addition command to tell Node to use the common JS module, where it will find the resources it needs to properly execute our JS.

    tsc source-file.ts --target ES6 --module commonjs

The short hand syntax of this command would be:

    tsc source-file.ts -t ES6 -m commonjs