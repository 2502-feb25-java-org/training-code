
# Different types of selectors
Selectors can be divided into the following categories:
#### Simple selectors: 
-Match one or more elements based on element type, class, or id.
#### Attribute selectors: 
-Match one or more elements based on their attributes/attribute values.
#### Pseudo-classes: 
-Match one or more elements that exist in a certain state, such as an element that is being hovered over by the mouse pointer, or a checkbox that is currently disabled or checked, or an element that is the first child of its parent in the DOM tree.
#### Pseudo-elements: 
-Match one or more parts of content that are in a certain position in relation to an element, for example the first word of each paragraph, or generated content appearing just before an element.

Combining selectors
```h2.blue    |	Returns any<h2> elements of class "blue"
h2#blue       |	Returns any <h2> elements with id "blue" 
section, h2   |	Returns any <h2> and any <section> elements 
section h2    |	Returns any <h2> elements nested within a <section> element at any level. 
section > h2  |	Returns any <h2> elements nested immediately under a <section> element 
section + h2  |	Returns any <h2> elements immediately following and sharing the same parent element as a <section> element 
section ~ h2  | Returns any <h2> elements following and sharing the same parent element as a <section> element
```

#### The Attribute Selector
```input[type]     | Returns any <input> elements that use the type attribute, whatever its value.
input[type="text"] | Returns any <input> elements where the type attribute value is exactly equal to the string "text". 
input[abc="red"]   | Returns any <input> elements where the abc attribute (for instance, the class attribute) contains a space-separated list of values, one of which is exactly equal to "red". 
input[type^="sub"] | Returns any <input> elements where the type attribute value begins exactly with the string "sub". 
input[type$="mit"] | Returns any <input> elements where the type attribute value ends exactly with the string "mit". 
input[type*="ubmi"]| Returns any <input> elements where the type attribute value contains the substring "ubmi". 
```
#### pseudo-class
A CSS pseudo-class is a keyword added to a selector that specifies a special state of the selected element(s). For example, :hover can be used to change a button's color when the user's pointer hovers over it.
```/* Selects any invalid <input> */
input:invalid {
  background-color: red;
}
```
#### pseudo-element 
A CSS pseudo-element is a keyword added to a selector that lets you style a specific part of the selected element(s). For example, ::first-line can be used to change the font of the first line of a paragraph.
```/* Selects the first line of a <p> */
p::first-line {
  color: red;
}
```
#### CSS Size:
absolute-size values 
```font-size: xx-small;
font-size: x-small;
font-size: small;
font-size: medium;
font-size: large;
font-size: x-large;
font-size: xx-large;
```
relative-size values
```font-size: smaller;
font-size: larger;
```
length values  px, em, rem
```font-size: 12px;
font-size: 0.8em;
```
percentage values
```
font-size: 80%;
```
[Box Model](https://developer.mozilla.org/en-US/docs/Learn/CSS/Introduction_to_CSS/Box_model#Types_of_CSS_boxes)

[Layout](https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Introduction)

[Form Validation](https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms/Form_validation)
