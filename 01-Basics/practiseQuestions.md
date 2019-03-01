# HTML-CSS Questions 

1. What is HTML
  + HTML stands for Hypertext Markup Language and consists of various tags to describe the content of a document - utilized as the basis for all web pages, along with CSS and JavaScript
2. What is the structure of an HTML document? List some tags. What is `<head>` used for? `<body>`?
  + Start with the doctype declaration, then `<html>`, then `<head>` and `<body>`. The head contains the metadata for the page, while the body contains the content that is rendered to the screen. Other tags: div, span, p, ul, ol, li, strong, em, table
3. What is a doctype?
  + First tag in the document - defines what type of file it is - whether html 4 or 5, etc
4. What is the tag for an ordered list? Unordered list?
  + ordered list: ol, unordered list: ul. Both use li - list items
5. What are some HTML5 tags? Why were HTML5 tags introduced?
  + HTML5 introduced semantic tags to more accurately reflect the content of the tags. Examples: `<strong>` instead of `<b>`, `<em>` instead of `<i>`, `<nav>`, `<header>`, `<footer>`, `<section>`, `<article>`, and `<aside>` instead of reusing `<div>` tags everywhere
6. Do all tags come in a pair? What are the other things inside tags called? list some.
  + No - tags either have a closing tag or are self-closing (`<tag />`). Attributes are contained within tags - examples: id, class, style, height, width, etc
7. What is the syntax for a comment in HTML?
  + `<!-- comments go in here -->`
8. Give me the HTML markup for a table.
```html
<table>
  <caption>optional</caption>
  <thead>
    <tr>
     <td>Heading 1</td><td>Heading 2</td>
   </tr>
  </thead>
   <tr>
    <td>Cell 1</td><td>Cell 2</td>
   </tr>
  <tbody>
  </tbody>
</table>
```
9. What are some tags you would use in a form?
  + Form tags: `<form>`, `<input>`, `<label>`, `<textarea>`, `<button>`, `<select>`, `<option>`
10. What is CSS? what are the different ways of styling an HTML file? Which is best? why?
  + CSS stands for Cascading Style Sheets - it is a language for styling HTML documents by specifying certain rules for layout and display in key/value pairs. There are 3 ways of styling an HTML file:
  + (1) inline - in the `style` attribute
  + (2) internal stylesheet - in the `<style>` tag in the `<head>`
  + (3) external stylesheet - using external `.css` file, use `<link>` in the `<head>`
  + External stylesheet is best practice due to separation of concerns, reusability, modularity
11. Describe the CSS box model.
  + The box model consists of margin (outermost box), then border, then padding, then content (innermost). All box sizes / formatting can be styled with CSS
12. Which way has highest priority when styles cascade: inline, internal, and external.
  + Inline has highest priority, then internal/external depending on order. Cascading rules are determined by (1) importance (`!important` flag), (2) specificity of selector (inline has no selector, highest specificity), then (3) source order.
13. Syntax for styling an element? What is a class and how to style them? What is an id? how to style? difference?
```css
div { property: value}
.class { property: value}
#id { property: value}
```
14. What if I want to select child elements, What syntax is that?
  + use direct descendant selector (`>`) or space for any level nested element
15. Can I select multiple elements at once? How?
  + yes, with a comma
16. What is a psuedo-class? What is syntax for selecting that?
  + psuedo-class selects an element in a certain state - for example, when hovered over. Use colon (`:psuedoselector`) syntax
17. What is Bootstrap?
  + Bootstrap is a CSS framework with pre-written CSS rules to easily style your page and incorporate responsive design seamlessly. Contains various utilities and components for making a great UI
18. Describe the Bootstrap grid system
  + The Bootstrap grid is divided into 12 columns. You wrap the columns in a `.row` which is in a `.container` or `.container-flex`. The columns are responsive - there are classes for different screen sizes which collapse on smaller windows


#Questions 

1. What is JavaScript? What do we use it for?
  + JavaScript is a programming language developed initially and still primarily used for client-side scripting on the web. JS runs natively in the browser, but has expanded into desktop applications and server-side scripting with Node.js
+ Where is the best place to put a script tag in your HTML document?
  + Best practice is to put it just before the close of the `<body>` tag because so that it won't block the rendering of the rest of the page
+ What are the data types in JS?
  + Object, String, number, boolean, null, undefined, Symbol
+ What are the variable scopes in JS?
  + global scope, function scope, block scope
+ What are JS objects? What is the syntax?
  + In JavaScript, objects consist of properties which are key/value pairs
+ What is JSON? is it different from JS objects?
  + JSON stands for JavaScript Object Notation and is used as a data interchange format - it consists of key/value pairs similar to JS objects, but it cannot contain functions or circular references.
+ How to convert JS object to/from JSON?
  + Use the `JSON.parse()` to convert from JSON to JS object, and use `JSON.stringify()` to convert object to JSON
+ What does truthy/falsy mean?
  + Non-boolean data types can take on boolean values when evaluated. For example, 0, empty strings, null, and undefined evaluate to falsy; everything else is truthy
+ What is type coercion?
  + Type coercion refers to the ability of JavaScript to change the type of the variable being evaluated - e.g. 5 == '5' will evalute to true
+ What is the difference between `==` and `===` ?
  +  `==` allows type coercion
+ How does inheritance work in JS?
  + JS has prototypical inheritance - all objects have a link to a *prototype* object which can link to another prototype object in the *prototype chain* until the `Object` prototype is reached
+ What is unique about functions in JS?
  + Functions are objects in JavaScript - they can be passed as parameters, attached to other objects, and nested inside other functions
+ What are callback functions? self-invoking functions?
  + Callback functions are those passed as parameters into other functions and can then be invoked within.
Self-invoking functions are wrapped in parentheses and then invoked immediately - `(function(){...})()`
+ What is closure? Why use closures?
  + Closures are the ability for a function to retain access to an outer function's scope even after returning
+ What is the `this` keyword?
  + `this` refers to the lexical context in which it is used - it is determined by how a function is called. When called in a method, refers to the object the method is called on.
+ Does JS have classes? when were they introduced?
  + ES6 introduced the `class` syntax, but it is only syntactic sugar for prototype inheritance
+ What is new with ES6? What are template literals, `let` keyword, `Symbol`s, Promises?
  + Template literals are a new way of denoting strings with backticks, allowing string interpolation
`let` is a new way to declare a variable - will be block-scoped
`Symbol` is a new primitive - used as the key for an object property when intended to be private for internal use
Promises are a way of doing asynchronous operations - the `Promise` object represents the eventual completion or failure of said operation
+ Arrow function? What makes it different from normal function?
  + Arrow function is a shorthand notation for a function which inherits the lexical context of its enclosing scope
+ What is strict mode?
  + ES5 introduced strict mode - it enforces certain rules like preventing accidental global variables. Syntax: `'use strict'`
+ What will happen when I run this code: `console.log(0.1+0.2==0.3)` ?
  + This will print false due to floating point values - the sum will be close to 0.3 but not exact
+ What are arrays in JS? can you change their size?
  + Arrays are an ordered collection of data. Size can be changed dynamically by adding/removing elements. Indexing starts at 0
+ What is a CDN? What are the benefits?
  + CDN stands for Content Delivery Network - we often use them to download libraries by setting the URL in the `src` attribute of a `<script>` tag
+ What is AJAX? why do we use it?
  + AJAX stands for Asynchronous JavaScript and XML - it is used to make HTTP requests without blocking execution of other code or rendering on the web page
+ What are steps to sending an AJAX request?
  + 1. Create the XmlHttpRequest object (XHR) 2. Attach onreadystatechange event handler. 3. Open the XHR object with `.open(method, url, async)` 4. Send XHR object with `.send()`
+ What is the DOM?
  + The DOM stands for document object model and refers to the tree-like structure of the HTML document.
+ How to select elements from the DOM? How to insert elements dynamically?
  + Use `document.getElementById()` to select elements by their id. Can also get with classname, tagname, queryselector. Use `document.createElement()` or `document.createTextNode()` then invoke `.appendChild()` or `.insertBefore()` on an element to add to the DOM
+ What are events / event listeners? What are some events we can listen for? ways of setting event listeners?
  + Events represent actions that occur in the DOM, whether from user input or from an API. Some examples: mouseclick, dblclick, mouseenter, mouseleave, keyup
+ What is bubbling and capturing and what is the difference?
  + Bubbling refers to events propogating up through the DOM from innermost elements to outermost; capturing refers to the opposite process
+ How do you stop an event from bubbling further?
  + use `event.stopPropogation()`
