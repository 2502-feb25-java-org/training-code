# Building Re-usable Components

In *ng-notes-3.md*, we discussed different kinds of data binding: class, style, event, property, attribute, and two-way. Below are two HTML elements that demonstrate the syntax and usage of property and event binding.

    <img [src]="imageUrl" />
    <button (click)="onClick()">My Button</button>

Recall that we use property binding with the square bracket syntax to bind properties of DOM objects to fields or properties in the host component, in this case the `img` DOM object. Think of the property `src` as being an input into this DOM object, allowing us to dynamically set the state of the object.

Similarly, we use event binding to handle events raised from a DOM object, in this case a click event on a button. In the above example, we can see that the `click` event is being assigned to `onClick()` method.

However, if we want to add support for custom event binding we need define a special property within our component that is known as an *output property*. In other words, in order to make a component more reusable we will want include input and output properties.

We use input properties to pass input, or state, to a component. We use output properties to raise events from our custom component. The combination of input and output of a component make up what we know as the *Component API* of the given component.


## Input Properties

In order to use a component field in property binding expressions on our template, we need mark a the field as input property. Let's work with the `FavoriteComponent` and its associated template. 

Component:

    import { Component, OnInit } from '@angular/core';

    @Component({
        selector: 'favorite',
        templateUrl: './favorite.component.html',
        styleUrls: ['./favorite.component.css']
    })
    export class FavoriteComponent {
        isFavorite: boolean;

        onClick() {
            this.isFavorite = !this.isFavorite;
        }
    }

So, we want to be able to use the `isFavorite` field of our `FavoriteComponent` as an input property so we can use it in property binding on our template. To do this, we need include an import from `@angular/core` called `Input`. With the dependency imported into our component, we can include the *Input decorator* in our declaration of `isFavorite`:

    @Input() isFavorite: boolean;

With our `isFavorite` field marked as an input property, the following property binding syntax will functions properly:

    <favorite [isFavorite]="post.isFavorite">

An alternative method of declaring input properties to include input declarations in the component metadata of our `FavoriteComponent`. Below is how the component metadata, which is contained within the Component decorator:

    @Component({
        selector: 'favorite',
        templateUrl: './favorite.component.html',
        styleUrls: ['./favorite.component.css'],
        inputs: ['isFavorite']
    })

You may think that this approach is better than using the Input decorator because we have one less step involved in the process. However, imagine if we changed the name of our `isFavorite` field. Now we need to go into the component's metadata and update the value in the array. This will be very tedious if our component had more than a few input properties.

I should point out that changing the name of the field without updating the `inputs` declaration does *not* cause our code to throw errors, it will just not have any functionality. The reason why it does not create errors is because under the hood, nG is actually creating a component field automatically with the name of the variable(s) declared in the `inputs` array within the component metadata.


### Aliasing Input Properties

Now that we know how to define an input property, let's look at how we can give our input properties aliases, or nicknames, to referenced by. This is useful if you want to use a different naming convention in your template than is used in the component. Because in TS and JS, variable names are camel-cased, but in HTML we use hyphens to separate words. 

Aliases provide a solution to this that allow us to keep the camel-cased convention in our TS code, and use standard HTML conventions in our template. To do this we need to make a few minor changes to our component:

    import { Component, OnInit, Input } from '@angular/core';

    @Component({
        selector: 'favorite',
        templateUrl: './favorite.component.html',
        styleUrls: ['./favorite.component.css']
    })
    export class FavoriteComponent {
        @Input('is-favorite') isFavorite: boolean;

        onClick() {
            this.isFavorite = !this.isFavorite;
        }
    }

Now, the property binding expression used in our template can be refactored to follow proper HTML naming conventions:

    <favorite [is-favorite]="post.isFavorite"></favorite>

In addition to helping us follow various naming conventions, there is another benefit to using input property aliasing. When we alias an input property, we actually stablize the relationship between our component's field and the reference on the template.

When we update a field, using the Refactor ability in VS Code (F2), all occurrences of that property in the current file are updated. This means that while all of the component's references to the field will be updated accordingly, the references to it in our template will *not* be updated - thereby breaking the functionality of our component. 

Using aliasing allows us to change the component field name of our input property within the component without as many adverse effects on the template side.


## Output Properties

Continuing on with our `FavoriteComponent` example, let's explore *output properties*. Say that, we want to be notified whenever some custom event occurs on the component. Just as we were able to create input properties that allowed us to make custom DOM properties, we can also create output properties that allow us to create custom events associated with a DOM object.

Just as was the case with our Input decorator, we also need to import the Output decorator from the `@angular/core` library. In addition to prefix our property declaration with this decorator, we also need to initialize the output property to an `EventEmitter` object.

As an `EventEmitter`, our change property will be able to leverage the methods associated with them. The main one we are concerned with for now is the `emit()` method. This method is used to publish an event, notifying all subscribers that an event has occurred.

It is this `change` event that we will bind another function to enable more functionality. In our case, we will call `this.change.emit()` within the `onClick()` method of our `FavoriteComponent`. The method that we will bind to this custom even will be a simple one that just prints a value to the console.

So, here is what our `FavoriteComponent` is going to look like after we are done:

    import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

    @Component({
        selector: 'favorite',
        templateUrl: './favorite.component.html',
        styleUrls: ['./favorite.component.css']
    })
    export class FavoriteComponent {

        @Input() isFavorite: boolean;
        @Output() change = new EventEmitter();

        onClick() {
            this.isFavorite = !this.isFavorite;
            this.change.emit(); // publishes an event
        }

    }

Back in the browser, we should see that our page is working properly, and that when we click our `FavoriteComponent` it has all of its original functionality, as well as the new functionality that prints a value to the console.


### Passing Event Data

When raising an event, there are times that we want to provide additional information regarding the event itself. For instance, in our previous example, we do not know anything about the event itself. We do not know whether or not the user favorited or unfavorited something.

We can provide this data as an argument to the `emit()` method we invoked back in our `FavoriteComponent`'s `onClick()` method. So the syntax of this will look like:

    onClick() {
        this.isFavorite = !this.isFavorite;
        this.change.emit(this.isFavorite);
    }

Just by including this argument, all subscribers to this event will have access to this data. Back in the subscribed method found in `AppComponent`, we can include some more information with our console log:

    onFavoriteChange(isFavorite) {
        console.log("Favorite changed: ", isFavorite)
    }

We are not quite done yet, we still need to update our template to pass the `$event` object to the `onFavoriteChange()` method bound to the `change` event:

    <favorite [isFavorite]="post.isFavorite" (change)="onFavoriteChange($event)">

Interacting with our component in the browser and inspecting the console reveals the state of the `isFavorite` component property. Keep in mind that for this example we are passing in a boolean argument to our `emit()` method. However, we can pass any kind of argument that we like, even objects to encapsulate several properties of our component.

If you are dealing with a more complex application, you may want to use type annotations to provide some type safety when working with the event arguments. For primitive values inline annotations are fine, but when working with objects it can get a bit verbose. This would be a point when we would likely introduce an interface that describes the properties of our `onFavoriteChange()` method's event arguments.


### Aliasing Output Properties

In the same way that we can alias our input properties to help stablize our component API, we can also alias our output properties. The concept is exactly the same, and it serves the same functions as input property aliasing. In our Output decorator, we will include a string argument that sets an alias that can be used within the template to reference our component's output property.

##### See the *favorite.component.ts*, *app.component.html*, *app.component.ts* files within ng-demo to see these concepts in action


## Templates

The template is what contains the HTML markup that determines how our component will be rendered to the screen. So far, we have seen two ways of writing templates for our components: using the `template` property of the `@Component` decorator and using an external `.html` file that is referenced within the `templateUrl` property of the `@Component` decorator. It is important to note, that you cannot mix these two approaches.

Also, if you open up Chrome Developer Tools (CTRL + SHIFT + I) and open the 'Network' tab, you will find all of the requests made to the server. Looking at the list of requests, you will discover that there are no references to our `.html`. Instead, they are actually bundled with our source code in `main.bundle.js`. Exploring this request will reveal that in the server response is our HTML written as JS values. This is convenient because it reduces the amount of communication required between the server and the client.


## Styles

In nG, there are a few ways to apply styles to a component:

* Using the `<style>` element inline within the HTML template
* Using the `styles` property of the component metadata to write styles inline
* Using the `styleUrls` property of the component metadata to import external stylesheets

Styles declared within the template are applied first (inline styles modifying the `style` attribute first, then those in the `<style>` element). After this nG looks at the component metadata to determine what other styles should be applied. You are able to use both the `styles` and `styleUrls` properties without error. However, nG will only apply one of these styles to our component. The styles that are applied are those that come *last* in the component's metadata.

##### See *favorite.component.ts*, *favorite.component.css*, and *favorite.component.html* for more notes on component styling.


## View Encapsulation

So, how is it that our styles do not leak into other parts of our application? Styling applied to `.glyphicon` within the component is scoped to that component, and will not have an effect on other components. This is possible because of the *Shadow DOM*.

The Shadow DOM allows us to apply scoped styles to elements without the styles leaking to other components within the application. Behind the scenes, when the template for a component is being rendered the JS looks something like this:

    let element = document.querySelector('myComponent');

    element.innerHTML = `
        <style>h1 { color: red }</style>
        <h1>Hello</h1>
    `;

This looks correct, except that the style tag here will leak and cause styling changes to every other `<h1>` in the application (or at least the current page). This is not ideal, and to correct this we only need to add a single line of code, and make one small modification to the existing code:

    let element = document.querySelector('myComponent');
    let root = element.createShadowRoot();
    root.innerHTML = `
        <style>h1 { color: red }</style>
        <h1>Hello</h1>
    `;

Now, our `<h1>` styling will only be applied to this component, and no others. The way this works is that nG attaches an attribute to our styles that allows view encapsulation to be emulated (because most browsers do not support Shadow DOM). Looking at the source code of our webpage will show that the styles defined within our component are included in the `<head>` element, but nG has included a strange attribute which looks something like: `_ngcontent-c#`. It is this feature that allows nG to apply styling rules appropriately, without them being applied out of the intended scope.

We can change the way nG does view encapsulation by working with the `encapsulation` property of the component metadata. This property should be assigned to the `ViewEncapsulation` enum which has three values: `Emulated`, `Native`, and `None`.

`ViewEncapsulation.Emulated` is the default, and is nG's way of getting around the fact that the Shadow DOM is not supported by most browsers. The method described earlier is how this setting operates.

`ViewEncapsulation.Native` attempts to use the browser's native Shadow DOM in order to scope styles to a specific component. However, if the browser does not support Shadow DOM then styles will not be applied.

`ViewEncapsulation.None` tells nG to not perform view encapsulation. This means that our styles will not be scoped to our components and they will be applied globally throughout the application.